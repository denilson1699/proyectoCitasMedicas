--Creamos la base de datos
CREATE DATABASE BD_CITASMEDICAS

/*==============================================================*/
/* Table: CITAS                                                 */
/*==============================================================*/
create table CITAS
(
   CODIGOCITA           VARCHAR(6) not null,
   IDLOCAL              int not null,
   IDPAC                int not null,
   IDHORARIO            int not null,
   FECHAREGCITA         datetime not null,
   ESTADOCITA           char(15) not null,
   COMENTARIOCITA       char(100) not null,
   primary key (CODIGOCITA)
);

/*==============================================================*/
/* Table: ESPECIALIDADMEDICO                                    */
/*==============================================================*/
create table ESPECIALIDADMEDICO
(
   IDMEDICO             INTEGER not null AUTO_INCREMENT,
   IDESP                int not null,
   IDTEMEDICO           int not null,
   DNIMED               char (8)UNIQUE CHECK (DNIMED LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
   APELLIDOPATMED       char(50) not null,
   APELLIDOMATMED       char(50) not null,
   NOMBREMED            char(30) not null,
   SEXOMED              CHAR(1) CHECK (SEXOMED IN ('M','F')),
   TELEFONOMED          char(9) UNIQUE CHECK (TELEFONOMED LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
   EMAILMED             char(50) CHECK (EMAILMED Like '%@'),
   FECHAINGRESOMED      char(15) not null,
   FECHASALIDAMED       char(15) not null,
   PASSMED              char(15) not null,
   ESTADOMED            char(10) not null,
   primary key (IDMEDICO)
);

/*==============================================================*/
/* Table: ESPECIALISTA                                          */
/*==============================================================*/
create table ESPECIALISTA
(
   IDESP                INTEGER not null AUTO_INCREMENT,
   DNIESP               char(8) UNIQUE CHECK (DNIESP LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')NOT NULL,
   APELLIDOMATESP       char(50) not null,
   NOMBREESP            char(30) not null,
   SEXOESP              CHAR(1) CHECK (SEXOESP IN ('M','F')),
   TELEFESP             char(9) UNIQUE CHECK (TELEFESP LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
   EMAILESP             char(50) CHECK (EMAILESP Like '%@'),
   FECHAINSCRIPCIONESP  datetime not null,
   PASSESP              char(15) not null,
   ESTADOESP            char(10) not null,
   primary key (IDESP)
);

/*==============================================================*/
/* Table: HORARIOS                                              */
/*==============================================================*/
create table HORARIOS
(
   IDHORARIO            INTEGER not null AUTO_INCREMENT,
   IDMEDICO             int not null,
   FECHA                datetime not null,
   HORA                 datetime not null,
   primary key (IDHORARIO)
);

/*==============================================================*/
/* Table: LOCAL                                                 */
/*==============================================================*/
create table LOCAL
(
   IDLOCAL              INTEGER not null AUTO_INCREMENT,
   DESCRIPCIONLOCAL     char(50) not null,
   DIRECCION            char(50) not null,
   PROVINCIA            char(30) not null,
   DISTRITO             char(30) not null,
   primary key (IDLOCAL)
);

/*==============================================================*/
/* Table: PACIENTE                                              */
/*==============================================================*/
create table PACIENTE
(
   IDPAC                INTEGER not null AUTO_INCREMENT,
   DNIPAC               char(8) UNIQUE CHECK (DNIPAC LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
   APELLIDOPATPAC       char(50) not null,
   APELLIDOMATPAC       char(50) not null,
   NOMBREPAC            char(30) not null,
   EMAILPAC             char(50) CHECK (EMAILPAC Like '%@'),
   GENEROPAC            CHAR(1) CHECK (GENEROPAC IN ('M','F')),
   TELEFPAC             char(9) UNIQUE CHECK (TELEFPAC LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
   FECHAREGISTROPAC     datetime not null,
   ESTADOPAC            char(10) not null,
   PASSPAC              char(15) not null,
   primary key (IDPAC)
);

/*==============================================================*/
/* Table: TIPOESPECIALIDADMEDICO                                */
/*==============================================================*/
create table TIPOESPECIALIDADMEDICO
(
   IDTEMEDICO           INTEGER not null AUTO_INCREMENT,
   DESCRIPCION          char(50) not null,
   primary key (IDTEMEDICO)
);


alter table CITAS add constraint FK_CITAS_LOCAL foreign key (IDLOCAL)
      references LOCAL (IDLOCAL);

alter table CITAS add constraint FK_HORARIOS_CITAS foreign key (IDHORARIO)
      references HORARIOS (IDHORARIO);

alter table CITAS add constraint FK_PACIENTE_CITAS foreign key (IDPAC)
      references PACIENTE (IDPAC);

alter table ESPECIALIDADMEDICO add constraint FK_ESPECILIDADMEDICO_ESPECIALISTA foreign key (IDESP)
      references ESPECIALISTA (IDESP);

alter table ESPECIALIDADMEDICO add constraint FK_ESPECILIDADMEDICO_TIPOESPECIALIDADMEDICO foreign key (IDTEMEDICO)
      references TIPOESPECIALIDADMEDICO (IDTEMEDICO);

alter table HORARIOS add constraint FK_ESPECIALIDADMEDICO_HORARIO foreign key (IDMEDICO)
      references ESPECIALIDADMEDICO (IDMEDICO);
