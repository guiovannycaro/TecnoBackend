CREATE DATABASE tecnoFackBD;

CREATE SEQUENCE public.usuarios_idusuario_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.persona_idpersona_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.tipodocumento_idtipodocumento_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.preferencia_idpreferencia_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.perfil_idperfil_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.perfil_usuario_idpu_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.pais_idpais_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.generos_idgenero_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.departamentoestado_iddepartamento_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.commic_idcommic_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.genero_commic_seq INCREMENT BY 1 START 1;
CREATE SEQUENCE public.ciudad_idciudad_seq INCREMENT BY 1 START 1;

/******************** Add Table: public.usuario ************************/
CREATE TABLE public.usuario
(
	idusuario INTEGER DEFAULT nextval('usuarios_idusuario_seq'::regclass) NOT NULL,
	idpersona BIGINT NOT NULL,
	username VARCHAR NOT NULL,
	contrasena TEXT NOT NULL,
	is_activo BOOL NOT NULL,
	is_cambiarcontrasena BOOL NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.usuario ADD CONSTRAINT pk_usuario
	PRIMARY KEY (idusuario);
	
/******************** Add Table: public.persona ************************/
	
	CREATE TABLE public.persona
(
	idpersona BIGINT DEFAULT nextval('persona_idpersona_seq'::regclass) NOT NULL,
	nombres VARCHAR NOT NULL,
	apellidos VARCHAR NOT NULL,
	idtipodocumento INTEGER NOT NULL,
	numdocumento NUMERIC(20, 0) NOT NULL,
	num_telefono NUMERIC(15, 0) NULL,
	email VARCHAR NULL,
	direccion VARCHAR NULL,
	idciudad INTEGER NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.persona ADD CONSTRAINT pk_persona
	PRIMARY KEY (idpersona);	
	
	
		/******************** Add Table: public.tipodocumento ************************/
	

	
CREATE TABLE public.tipodocumento
(
	idtipodocumento INTEGER DEFAULT nextval('tipodocumento_idtipodocumento_seq'::regclass) NOT NULL,
	descripcion VARCHAR NOT NULL,
	is_activo BOOL NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.tipodocumento ADD CONSTRAINT pk_tipodocumento
	PRIMARY KEY (idtipodocumento);
	
	
	
	/******************** Add Table: public.preferencias ************************/
	
	CREATE TABLE public.preferencias
(
	idpreferencia BIGINT DEFAULT nextval('preferencia_idpreferencia_seq'::regclass) NOT NULL,
	idpersona INTEGER NOT NULL,
	idgenero INTEGER NOT NULL,
	idcommic INTEGER NOT NULL,
	estado BOOL NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.preferencias ADD CONSTRAINT pk_preferencias
	PRIMARY KEY (idpreferencia);	
	
	
	/******************** Add Table: public.perfil ************************/

/* Build Table Structure */
CREATE TABLE public.perfil
(
	idperfil INTEGER DEFAULT nextval('perfil_idperfil_seq'::regclass) NOT NULL,
	descripcion VARCHAR NOT NULL,
	is_activo BOOL NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.perfil ADD CONSTRAINT pk_perfil
	PRIMARY KEY (idperfil);	


/******************** Add Table: public.perfil_usuario ************************/

/* Build Table Structure */
CREATE TABLE public.perfil_usuario
(
	idpu INTEGER DEFAULT nextval('perfil_usuario_idpu_seq'::regclass) NOT NULL,
	idperfil INTEGER NOT NULL,
	idusuario INTEGER NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.perfil_usuario ADD CONSTRAINT pk_perfil_usuario
	PRIMARY KEY (idpu);
	
	
	/******************** Add Table: public.pais ************************/

/* Build Table Structure */
CREATE TABLE public.pais
(
	idpais INTEGER DEFAULT nextval('pais_idpais_seq'::regclass) NOT NULL,
	nombre VARCHAR NOT NULL,
	cod_oficial_iso VARCHAR NULL,
	iso2 VARCHAR NOT NULL,
	iso3 VARCHAR NOT NULL,
	latitud DOUBLE PRECISION NULL,
	longitud DOUBLE PRECISION NULL,
	codpostal VARCHAR NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.pais ADD CONSTRAINT pk_pais
	PRIMARY KEY (idpais);
	
	
	/******************** Add Table: public.genero************************/

/* Build Table Structure */
CREATE TABLE public.genero
(
	idgenero INTEGER DEFAULT nextval('generos_idgenero_seq'::regclass) NOT NULL,
	nombre VARCHAR NOT NULL,
	descripcion VARCHAR NULL,
	imagen VARCHAR NOT NULL,
	is_activo BOOL NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.genero ADD CONSTRAINT pk_genero
	PRIMARY KEY (idgenero);
	
/******************** Add Table: public.departamentoestado ************************/
	
	/* Build Table Structure */
CREATE TABLE public.departamentoestado
(
	iddepartamento INTEGER DEFAULT nextval('departamentoestado_iddepartamento_seq'::regclass) NOT NULL,
	idpais         INTEGER NOT NULL,
	codoficial     VARCHAR NOT NULL,
	nombre         VARCHAR NOT NULL,
	latitud        DOUBLE PRECISION NULL,
	longitud       DOUBLE PRECISION NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.departamentoestado ADD CONSTRAINT pk_departamentoestado
	PRIMARY KEY (iddepartamento);
	
	
	/******************** Add Table: public.commic ************************/
	
	/* Build Table Structure */
CREATE TABLE public.commic
(
	idcommic    INTEGER DEFAULT nextval('commic_idcommic_seq'::regclass) NOT NULL,
	nombre      VARCHAR NULL,
	fechapublic VARCHAR  NULL,
	escritor    VARCHAR  NULL,
	dibujante   VARCHAR  NULL,
	artportada  VARCHAR  NULL,
	descripcion VARCHAR NULL,
	imagen      VARCHAR  NULL,
    is_activo   BOOL   NULL
	
	
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.commic ADD CONSTRAINT pk_commic
	PRIMARY KEY (idcommic);
	
	
	/******************** Add Table: public.genero_commic ************************/

/* Build Table Structure */
CREATE TABLE public.genero_commic
(
	idgc INTEGER DEFAULT nextval('genero_commic_seq'::regclass) NOT NULL,
	idcommic INTEGER NOT NULL,
	idgenero INTEGER NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.genero_commic ADD CONSTRAINT pk_genero_commic
	PRIMARY KEY (idgc);
		
			/******************** Add Table: public.ciudad ************************/
		
	CREATE TABLE public.ciudad
(
	idciudad INTEGER DEFAULT nextval('ciudad_idciudad_seq'::regclass) NOT NULL,
	nombre VARCHAR  NULL,
	codoficial VARCHAR NULL,
	latitud DOUBLE PRECISION NULL,
	longitud DOUBLE PRECISION NULL,
	iddepartamento INTEGER NULL,
	codpostal VARCHAR NULL,
	updated_at TIMESTAMP NULL,
	created_at TIMESTAMP NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.ciudad ADD CONSTRAINT pk_ciudad
	PRIMARY KEY (idciudad);
	
	
	/* Add Foreign Key: fk_ciudad_departamentoestado */
ALTER TABLE public.ciudad ADD CONSTRAINT fk_ciudad_departamentoestado
	FOREIGN KEY (iddepartamento) REFERENCES public.departamentoestado (iddepartamento)
	ON UPDATE NO ACTION ON DELETE NO ACTION;
	
	/* Add Foreign Key: fk_departamentoestado_pais */
ALTER TABLE public.departamentoestado ADD CONSTRAINT fk_departamentoestado_pais
	FOREIGN KEY (idpais) REFERENCES public.pais (idpais)
	ON UPDATE NO ACTION ON DELETE NO ACTION;
	
	
		/* Add Foreign Key: fk_usuario_persona */
ALTER TABLE public.usuario ADD CONSTRAINT fk_usuario_persona
	FOREIGN KEY (idpersona) REFERENCES public.persona (idpersona)
	ON UPDATE NO ACTION ON DELETE NO ACTION;
	
	
	/* Add Foreign Key: fk_perfil_has_usuario_usuario */
ALTER TABLE public.perfil_usuario ADD CONSTRAINT fk_perfil_usuario
	FOREIGN KEY (idusuario) REFERENCES public.usuario (idusuario)
	ON UPDATE NO ACTION ON DELETE NO ACTION;
	
	/* Add Foreign Key: fk_perfil_has_usuario_usuario */
ALTER TABLE public.perfil_usuario ADD CONSTRAINT fk_perfil_perfil_usuario
	FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil)
	ON UPDATE NO ACTION ON DELETE NO ACTION;
	
	
	ALTER TABLE public.persona ADD CONSTRAINT fk_persona_tipodocumento
	FOREIGN KEY (idtipodocumento) REFERENCES public.tipodocumento (idtipodocumento)
	ON UPDATE NO ACTION ON DELETE NO ACTION;
	
	
	ALTER TABLE public.genero_commic ADD CONSTRAINT fk_commic_genero
	FOREIGN KEY (idcommic) REFERENCES public.commic (idcommic)
	ON UPDATE NO ACTION ON DELETE NO ACTION;
	
	ALTER TABLE public.genero_commic ADD CONSTRAINT fk_genero_commic
	FOREIGN KEY (idgenero) REFERENCES public.genero (idgenero)
	ON UPDATE NO ACTION ON DELETE NO ACTION;