--================= CREACION DE BASE DE DATOS ========================================
drop database BD_CITASMEDICAS

create database BD_CITASMEDICAS
on primary 
--( NAME=BD_Banco_DATA, FILENAME='C:\Users\Robert\Documents\Cursos Visual Basic NET\Semana 11\BD_Banco.MDF', SIZE= 10MB, MAXSIZE=20 MB, FILEGROWTH=30%)
(NAME=BD_Banco_DATA, FILENAME='C:\MisBD_SQLSERVER\BD_CITASMEDICAS.MDF', SIZE= 10MB, MAXSIZE=20 MB, FILEGROWTH=30%)
LOG ON
--( NAME=BD_Banco_LOG, FILENAME='C:\Users\Robert\Documents\Cursos Visual Basic NET\Semana 11\BD_Banco.LDF', SIZE= 5MB, MAXSIZE=10 MB, FILEGROWTH=30%)
(NAME=BD_Banco_LOG, FILENAME='C:\MisBD_SQLSERVER\BD_CITASMEDICAS.LDF', SIZE= 5MB, MAXSIZE=10 MB, FILEGROWTH=30%)
Go
use BD_CITASMEDICAS
/*==============================================================*/
/* Table: CITAS                                                 */
/*==============================================================*/
select * from ESPECIALISTA
select * from CITAS
create table CITAS
(
   CODIGOCITA           VARCHAR(6) not null,
   IDPAC                 VARCHAR(6) not null,
   IDHORARIO             VARCHAR(6) not null,
   FECHAREGCITA         varchar (35) not null,
   ESTADOCITA           char(20) not null,
   COMENTARIOCITA       char(200) not null,
   primary key (CODIGOCITA)
);
select *from Horarios
/*==============================================================*/
/* Table: ESPECIALIDADMEDICO                                    */
/*==============================================================*/
select * from CITAS
create table MEDICO
(
   IDMEDICO             VARCHAR(6) not null,
   IDESP                VARCHAR(6) not null,
   IDTEMEDICO           VARCHAR(6) not null,
   DNIMED               char (8)UNIQUE CHECK (DNIMED LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
   APELLIDOPATMED       char(50) not null,
   APELLIDOMATMED       char(50) not null,
   NOMBREMED            char(30) not null,
   SEXOMED              CHAR(1) CHECK (SEXOMED IN ('M','F')) NOT NULL,
   TELEFONOMED          char(9) CHECK (TELEFONOMED LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')NOT NULL,
   EMAILMED             char(50) not null,
   HORAINGRESOMED      varchar (10)not null,
   HORASALIDAMED       varchar (10)not null,
   PASSMED              char(15) not null,
   ESTADOMED            char(20) not null ,
   primary key (IDMEDICO)
);

/*==============================================================*/
/* Table: ESPECIALISTA                                          */
/*==============================================================*/
create table ESPECIALISTA
(
   IDESP                 VARCHAR(6) not null,
   DNIESP               char(8) UNIQUE CHECK (DNIESP LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
   APELLIDOPATESP		CHAR(50) not null,
   APELLIDOMATESP       char(50) not null,
   NOMBREESP            char(30) not null,
   SEXOESP              CHAR(1) CHECK (SEXOESP IN ('M','F')) NOT NULL,
   TELEFESP             char(9) CHECK (TELEFESP LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
   EMAILESP             char(50) NOT NULL,
   FECHAINSCRIPCIONESP  varchar (35)not null,
   PASSESP              char(15) not null,
   ESTADOESP            char(20) not null,
   primary key (IDESP)
);

/*==============================================================*/
/* Table: HORARIOS                                              */
/*==============================================================*/
create table HORARIOS
(
   IDHORARIO             VARCHAR(6) not null,
   IDMEDICO             VARCHAR(6) not null,
   IDLOCAL              VARCHAR(6) not null,
   FECHA                varchar (15)not null,
   HORA                 varchar (15)not null,
   ESTADO           char(30) not null,
   primary key (IDHORARIO)
);

/*==============================================================*/
/* Table: LOCAL                                                 */
/*==============================================================*/
create table LOCAL
(
   IDLOCAL               VARCHAR(6) not null,
   DESCRIPCIONLOCAL     char(50) not null,
   DIRECCION            char(50) not null,
   PROVINCIA            char(40) not null,
   DISTRITO             char(40) not null,
   primary key (IDLOCAL)
);

/*==============================================================*/
/* Table: PACIENTE                                              */
/*==============================================================*/
create table PACIENTE
(
   IDPAC                 VARCHAR(6) not null,
   DNIPAC               char(8) UNIQUE CHECK (DNIPAC LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
   APELLIDOPATPAC       char(50) not null,
   APELLIDOMATPAC       char(50) not null,
   NOMBREPAC            char(30) not null,
   EMAILPAC             char(50) NOT NULL,
   GENEROPAC            CHAR(1) CHECK (GENEROPAC IN ('M','F')) NOT NULL,
   TELEFPAC             char(9) CHECK (TELEFPAC LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
   FECHAREGISTROPAC     varchar (35) not null,
   ESTADOPAC            char(20) not null,
   PASSPAC              char(15) not null,
   primary key (IDPAC)
);

/*==============================================================*/
/* Table: TIPOESPECIALIDADMEDICO                                */
/*==============================================================*/
create table TIPOESPECIALIDADMEDICO
(
   IDTEMEDICO             VARCHAR(6) not null,
   DESCRIPCION           char(50) not null,
   primary key (IDTEMEDICO)
);


alter table HORARIOS add constraint FK_HORARIOS_LOCAL foreign key (IDLOCAL)
      references LOCAL (IDLOCAL);

alter table CITAS add constraint FK_HORARIOS_CITAS foreign key (IDHORARIO)
      references HORARIOS (IDHORARIO);

alter table CITAS add constraint FK_PACIENTE_CITAS foreign key (IDPAC)
      references PACIENTE (IDPAC);

alter table MEDICO add constraint FK_MEDICO_ESPECIALISTA foreign key (IDESP)
      references ESPECIALISTA (IDESP);

alter table MEDICO add constraint FK_MEDICO_TIPOESPECIALIDADMEDICO foreign key (IDTEMEDICO)
      references TIPOESPECIALIDADMEDICO (IDTEMEDICO);

alter table HORARIOS add constraint FK_MEDICO_HORARIO foreign key (IDMEDICO)
      references MEDICO (IDMEDICO);


/*==============================================================*/
/* PROCEDIMIENTOS ALMACENADOS                                   */
/*==============================================================*/

--================= STORE PROCEDURE MANTENIMIENTO PACIENTE =========================================
use BD_CITASMEDICAS
Go
if exists(select name from dbo.sysobjects WHERE name ='sp_paciente_mantenimiento')
DROP procedure sp_paciente_mantenimiento
Go
  
CREATE procedure sp_paciente_mantenimiento
@OPERACION varchar(200) output,
@_IDPACIENTE           VARCHAR(6),
@_DNIPAC               char(8),
@_APELLIDOPATPAC       char(50), 
@_APELLIDOMATPAC       char(50),
@_NOMBREPAC            char(30),
@_EMAILPAC             char(50),
@_GENEROPAC            CHAR(1) ,
@_TELEFPAC             char(9),
@_FECHAREGISTROPAC     varchar(35),
@_ESTADOPAC            char(20), 
@_PASSPAC              char(15)  
as
begin
DECLARE @RESPUESTA NVARCHAR (200)
if(@OPERACION='1') --=========== PARA INSERTAR PACIENTE
   begin
    IF NOT EXISTS(SELECT IDPAC from PACIENTE where DNIPAC=@_DNIPAC )
      begin
	   IF NOT EXISTS(SELECT IDPAC from PACIENTE where IDPAC=@_IDPACIENTE )
		begin
			INSERT INTO paciente(IDPAC,DNIPAC,APELLIDOPATPAC,APELLIDOMATPAC,NOMBREPAC,EMAILPAC,GENEROPAC,TELEFPAC,FECHAREGISTROPAC,ESTADOPAC,PASSPAC)
			VALUES(@_IDPACIENTE,@_DNIPAC,@_APELLIDOPATPAC,@_APELLIDOMATPAC,@_NOMBREPAC,@_EMAILPAC,@_GENEROPAC,@_TELEFPAC,@_FECHAREGISTROPAC,@_ESTADOPAC,@_PASSPAC);
			set @RESPUESTA='Se registro Paciente con codigo '+@_IDPACIENTE
			select @RESPUESTA as respuesta
		end
		else 
		begin	
         set @RESPUESTA='ya existe un registrado con '+@_IDPACIENTE
		select @RESPUESTA as respuesta
		end
	  end
   else
      begin
         set @RESPUESTA='ya existe un paciente registrado con '+@_DNIPAC
		select @RESPUESTA as respuesta
      end
   end
else if (@operacion='2')  --=============== PARA MODIFICAR PACIENTE
   begin
    	UPDATE PACIENTE SET APELLIDOPATPAC=@_APELLIDOPATPAC, APELLIDOMATPAC=@_APELLIDOMATPAC, NOMBREPAC=@_NOMBREPAC, EMAILPAC=@_EMAILPAC,
		GENEROPAC=@_GENEROPAC, TELEFPAC=@_TELEFPAC, PASSPAC=@_PASSPAC, ESTADOPAC=@_ESTADOPAC WHERE IDPAC=@_IDPACIENTE
		set @RESPUESTA='Se actualizo los datos del paciente correctamente'
		select @RESPUESTA as respuesta
   end
else if(@operacion='3')  --=============== PARA ELIMINAR PACIENTE
   begin
    IF EXISTS(SELECT @_IDPACIENTE from PACIENTE where IDPAC=@_IDPACIENTE )
      begin
		 delete from PACIENTE 	 where IDPAC=@_IDPACIENTE
		set @RESPUESTA='Se elimino datos del paciente.'
		select @RESPUESTA as respuesta
      end
   else
      begin
		set @RESPUESTA='No esiste registro'
		select @RESPUESTA as respuesta
	  end
	end
end
Go

declare @operacion varchar(100)
set @operacion='2'
exec sp_paciente_mantenimiento @operacion output,'PAC001','76131028','Jaramill001','Castillo01','Denilson01','jaramillod1699@gmail.com01','M','933569101','10/05/01','Activ01','Pac01'
print @operacion

select * from PACIENTE
Go



--================= STORE PROCEDURE MANTENIMIENTO ESPECIALISTA =========================================
use BD_CITASMEDICAS
Go
if exists(select name from dbo.sysobjects WHERE name ='sp_especialista_mantenimiento')
DROP procedure sp_especialista_mantenimiento
Go
  
CREATE procedure sp_especialista_mantenimiento
@OPERACION varchar(200) output,
@_IDESP                VARCHAR(6),
@_DNIESP               char(8),
@_APELLIDOPATESP	   CHAR(50),
@_APELLIDOMATESP       char(50),
@_NOMBREESP            char(30),
@_SEXOESP              CHAR(1),
@_TELEFESP             char(9),
@_EMAILESP             char(50),
@_FECHAINSCRIPCIONESP  varchar (35),
@_PASSESP              char(15),
@_ESTADOESP            char(20) 
as
begin
DECLARE @RESPUESTA NVARCHAR (200)
if(@OPERACION='1') --=========== PARA INSERTAR ESPECIALISTA
   begin
    IF NOT EXISTS(SELECT IDESP from ESPECIALISTA where DNIESP=@_DNIESP )
      begin
	  IF NOT EXISTS(SELECT IDESP from ESPECIALISTA where IDESP=@_IDESP)
      begin
		INSERT INTO ESPECIALISTA(IDESP, DNIESP,APELLIDOPATESP,APELLIDOMATESP,NOMBREESP,SEXOESP,TELEFESP,EMAILESP,FECHAINSCRIPCIONESP,PASSESP,ESTADOESP)
		VALUES(@_IDESP, @_DNIESP,@_APELLIDOPATESP,@_APELLIDOMATESP,@_NOMBREESP,@_SEXOESP,@_TELEFESP,@_EMAILESP,@_FECHAINSCRIPCIONESP,@_PASSESP,@_ESTADOESP);
		set @RESPUESTA='Se registro especialista con codigo '+@_IDESP
		select @RESPUESTA as respuesta
      end
	  ELSE
	  BEGIN
         set @RESPUESTA='ya existe un registrado con '+@_IDESP
		select @RESPUESTA as respuesta
	  END
	  END
   else
      begin
         set @RESPUESTA='ya existe un especialita registrado con '+@_DNIESP
		select @RESPUESTA as respuesta
      end
   end
else if (@operacion='2')  --=============== PARA MODIFICAR ESPECIALISTA
   begin
     UPDATE ESPECIALISTA SET APELLIDOPATESP=@_APELLIDOPATESP, APELLIDOMATESP=@_APELLIDOMATESP, NOMBREESP=@_NOMBREESP,
	 SEXOESP=@_SEXOESP, TELEFESP=@_TELEFESP, EMAILESP=@_EMAILESP, PASSESP=@_PASSESP, ESTADOESP=@_ESTADOESP WHERE IDESP=@_IDESP
     set @RESPUESTA='Se actualizo los datos del especialista correctamente'
		select @RESPUESTA as respuesta
   end
else if(@operacion='3')  --=============== PARA ELIMINAR ESPECIALISTA
   begin
    IF EXISTS(SELECT IDESP from ESPECIALISTA where IDESP=@_IDESP )
      begin
		--delete from ESPECIALISTA WHERE IDESP=@_IDESP
        set @RESPUESTA='se encontro datos del especialista pero debe eliminar la relacion con la tabla medico '
		select @RESPUESTA as respuesta
      end
   else
      begin
		set @RESPUESTA='No esiste registro'
		select @RESPUESTA as respuesta
	  end
   end
end
Go

declare @operacion varchar(100)
set @operacion='2'
exec sp_especialista_mantenimiento @operacion output,'ESP001','76131029','Jaramillo2','Castillo','Deni','M','933569122','jaramillod@gmail.com','10/5/2021','esp','Activo'
--exec sp_especialista_mantenimiento @operacion output,'ESP002','11111111','Jara','Cast','Deni','M','933569121','jaramillod@gmail.com','10/5/2021','adm','Administrador'

SELECT * FROM ESPECIALISTA


--================= STORE PROCEDURE MANTENIMIENTO MEDICO =========================================
use BD_CITASMEDICAS
Go
if exists(select name from dbo.sysobjects WHERE name ='sp_medico_mantenimiento')
DROP procedure sp_medico_mantenimiento
Go
  
CREATE procedure sp_medico_mantenimiento
@OPERACION varchar(200) output,
@_IDMED                VARCHAR(6),
@_IDESP                VARCHAR(6),
@_IDTEMEDICO           VARCHAR(6),
@_DNIMED               char(8),
@_APELLIDOPATMED	   CHAR(50),
@_APELLIDOMATMED       char(50),
@_NOMBREMED            char(30),
@_SEXOMED              CHAR(1),
@_TELEFMED             char(9),
@_EMAILMED             char(50),
@_HORAINSGRMED  varchar (35),
@_HORASALIDMED  varchar (35),
@_PASSMED              char(15),
@_ESTADOMED            char(20) 
as
begin
DECLARE @RESPUESTA NVARCHAR (200)
if(@OPERACION='1') --=========== PARA INSERTAR MEDICO
   begin
    IF NOT EXISTS(SELECT DNIMED from MEDICO where DNIMED=@_DNIMED )
      begin
		IF NOT EXISTS(SELECT DNIMED from MEDICO where  IDMEDICO=@_IDMED)
		BEGIN
			INSERT INTO MEDICO(IDMEDICO, IDESP,IDTEMEDICO,DNIMED,APELLIDOPATMED,APELLIDOMATMED,NOMBREMED,SEXOMED,TELEFONOMED,EMAILMED,HORAINGRESOMED,HORASALIDAMED,PASSMED,ESTADOMED)
			VALUES(@_IDMED, @_IDESP,@_IDTEMEDICO,@_DNIMED,@_APELLIDOPATMED,@_APELLIDOMATMED,@_NOMBREMED,@_SEXOMED,@_TELEFMED,@_EMAILMED,@_HORAINSGRMED,@_HORASALIDMED,@_PASSMED,@_ESTADOMED);
			set @RESPUESTA='Se registro medico con codigo '+@_IDMED
			select @RESPUESTA as respuesta
		END
		ELSE
			BEGIN
				 set @RESPUESTA='ya existe un registro con codigo'+@_IDMED
				select @RESPUESTA as respuesta
			END
      end
  else
      begin
         set @RESPUESTA='ya existe un medico registrado con '+@_DNIMED 
		select @RESPUESTA as respuesta
      end
   end
else if (@operacion='2')  --=============== PARA MODIFICAR MEDICO
   begin
     UPDATE MEDICO SET APELLIDOPATMED=@_APELLIDOPATMED, APELLIDOMATMED=@_APELLIDOMATMED, NOMBREMED=@_NOMBREMED,	 SEXOMED=@_SEXOMED, TELEFONOMED=@_TELEFMED,
	 EMAILMED=@_EMAILMED,HORAINGRESOMED=@_HORAINSGRMED, HORASALIDAMED=@_HORASALIDMED, PASSMED=@_PASSMED, ESTADOMED=@_ESTADOMED WHERE IDMEDICO=@_IDMED
     set @RESPUESTA='Se actualizo los datos del medico correctamente'
		select @RESPUESTA as respuesta
   end
else if(@operacion='3')  --=============== PARA ELIMINAR MEDICO
   begin
    IF EXISTS(SELECT IDMEDICO from MEDICO where IDMEDICO=@_IDMED )
      begin
		UPDATE MEDICO SET ESTADOMED='De baja' WHERE IDMEDICO=@_IDMED
		set @RESPUESTA='Se medico '+@_IDMED+' esta dado de baja'
		select @RESPUESTA as respuesta
      end
   else
      begin
		set @RESPUESTA='No esiste registro'
		select @RESPUESTA as respuesta
	  end
   end
 end
Go

declare @operacion varchar(100)
set @operacion='1'
exec sp_medico_mantenimiento @operacion output,'MED002','ESP003','TEM002','12345659','apellido paterno2','apellido materno2','medico 12','M','933569112','medico@gmail.com2','08:00am','06:00pm','med22','Activo'
print @operacion
SELECT * FROM MEDICO



--================= STORE PROCEDURE MANTENIMIENTO TIPOESPECIALIDADMEDICO =========================================
use BD_CITASMEDICAS
Go
if exists(select name from dbo.sysobjects WHERE name ='sp_TipoEspecialidadMedico_mantenimiento')
DROP procedure sp_TipoEspecialidadMedico_mantenimiento
Go
  
CREATE procedure sp_TipoEspecialidadMedico_mantenimiento
@OPERACION varchar(200) output,
@_IDTEMEDICO           VARCHAR(6),
@_DESCRIPCION          char(50) 
as
BEGIN
DECLARE @RESPUESTA NVARCHAR (200)
if(@OPERACION='1') --=========== PARA INSERTAR tipoespecialidad
   begin
    IF NOT EXISTS(SELECT IDTEMEDICO from TIPOESPECIALIDADMEDICO where IDTEMEDICO=@_IDTEMEDICO)
      begin
		INSERT INTO TIPOESPECIALIDADMEDICO (IDTEMEDICO, DESCRIPCION) VALUES(@_IDTEMEDICO, @_DESCRIPCION);
		set @RESPUESTA='Se registro la especialidad medico con codigo '+@_IDTEMEDICO 
		select @RESPUESTA as respuesta
      end
   else
      begin
         set @RESPUESTA='ya existe la especialiad con codigo '+@_IDTEMEDICO 
		select @RESPUESTA as respuesta
      end
   end
else if (@operacion='2')  --=============== PARA MODIFICAR tipoespecialidad
   begin
     UPDATE TIPOESPECIALIDADMEDICO SET DESCRIPCION=@_DESCRIPCION WHERE  IDTEMEDICO=@_IDTEMEDICO
     set @RESPUESTA='Se actualizo los datos correctamente' 
		select @RESPUESTA as respuesta
   end
else if(@operacion='3')  --=============== PARA ELIMINAR tipoespecialidad
   begin
    IF EXISTS(SELECT IDTEMEDICO from TIPOESPECIALIDADMEDICO where IDTEMEDICO=@_IDTEMEDICO )
      begin
		delete TIPOESPECIALIDADMEDICO WHERE IDTEMEDICO=@_IDTEMEDICO
        set @RESPUESTA='se elimino el resgitro con exito' 
		select @RESPUESTA as respuesta
      end
   else
      begin
		set @RESPUESTA='No esiste registro' 
		select @RESPUESTA as respuesta
	  end
   end
end
Go

declare @operacion varchar(100)
set @operacion='1'
exec sp_TipoEspecialidadMedico_mantenimiento @operacion output,'TEM002','fisioterapeuta'
print @operacion
SELECT * FROM TIPOESPECIALIDADMEDICO



--================= STORE PROCEDURE MANTENIMIENTO LOCAL =========================================
use BD_CITASMEDICAS
Go
if exists(select name from dbo.sysobjects WHERE name ='sp_local_mantenimiento')
DROP procedure sp_local_mantenimiento
Go
  
CREATE procedure sp_local_mantenimiento
@OPERACION varchar(200) output,
@_IDLOCAL               VARCHAR(6),
@_DESCRIPCIONLOCAL     char(50),
@_DIRECCION            char(50),
@_PROVINCIA            char(40),
@_DISTRITO             char(40) 
as
begin
DECLARE @RESPUESTA NVARCHAR (200)
if(@OPERACION='1') --=========== PARA INSERTAR LOCAL
   begin
    IF NOT EXISTS(SELECT IDLOCAL from LOCAL where IDLOCAL=@_IDLOCAL)
      begin
		INSERT INTO LOCAL(IDLOCAL,DESCRIPCIONLOCAL,DIRECCION,PROVINCIA,DISTRITO) VALUES(@_IDLOCAL,@_DESCRIPCIONLOCAL,@_DIRECCION,@_PROVINCIA,@_DISTRITO);
		set @RESPUESTA='Se registro local con codigo '+@_IDLOCAL 
		select @RESPUESTA as respuesta
      end
   else
      begin
         set @RESPUESTA='ya existe local' 
		select @RESPUESTA as respuesta
      end
   end
else if (@operacion='2')  --=============== PARA MODIFICAR LOCAL
   begin
     UPDATE LOCAL SET DESCRIPCIONLOCAL=@_DESCRIPCIONLOCAL, DIRECCION=@_DIRECCION, PROVINCIA=@_PROVINCIA, DISTRITO=@_DISTRITO WHERE  IDLOCAL=@_IDLOCAL
     set @RESPUESTA='Se actualizo los datos correctamente' 
		select @RESPUESTA as respuesta
   end
else if(@operacion='3')  --=============== PARA ELIMINAR LOCAL
   begin
    IF EXISTS(SELECT IDLOCAL from LOCAL where IDLOCAL=@_IDLOCAL )
      begin
		delete LOCAL WHERE IDLOCAL=@_IDLOCAL
        set @RESPUESTA='se elimino el resgitro con exito' 
		select @RESPUESTA as respuesta
      end
   else
      begin
		set @RESPUESTA='No esiste registro' 
		select @RESPUESTA as respuesta
	  end
   end
end
Go

declare @operacion varchar(100)
set @operacion='1'
execute sp_local_mantenimiento @operacion output,'LOC001','La casa del Pediatra','av.28 de julio 2308','Lima','Lima'
print @operacion
select * from LOCAL



--================= STORE PROCEDURE MANTENIMIENTO HORARIOS =========================================
use BD_CITASMEDICAS
Go
if exists(select name from dbo.sysobjects WHERE name ='sp_horario_mantenimiento')
DROP procedure sp_horario_mantenimiento
Go
  
CREATE procedure sp_horario_mantenimiento
@OPERACION varchar(200),
@IDHORARIO VARCHAR (6),
@_IDMEDICO VARCHAR (6),
@_IDLOCAL  VARCHAR (6),
@_FECHA    char(20),
@_HORA     char(30),
@_ESTADO   char(30)
as
BEGIN
DECLARE @RESPUESTA NVARCHAR (200)
if(@OPERACION='1') --=========== PARA INSERTAR HORARIOS
   begin
    IF NOT EXISTS(SELECT IDHORARIO from HORARIOS where FECHA=@_FECHA and HORA=@_HORA)
      begin
		INSERT INTO HORARIOS(IDHORARIO,IDMEDICO,IDLOCAL,FECHA,HORA,ESTADO)
		VALUES(@IDHORARIO,@_IDMEDICO,@_IDLOCAL,@_FECHA,@_HORA,@_ESTADO);
		set @RESPUESTA='Horario registrado con codigo '+@IDHORARIO	  
		select @RESPUESTA as respuesta
      end
   else
      begin
         set @RESPUESTA='Ya existe un horario registrado con las fecha elegidas'	  
		select @RESPUESTA as respuesta
      end
   end

else if (@operacion='2')  --=============== PARA MODIFICAR HORARIO
   begin
    IF NOT EXISTS(SELECT IDHORARIO from HORARIOS where FECHA=@_FECHA and HORA=@_HORA and IDMEDICO=@_IDMEDICO)
      begin
		UPDATE HORARIOS SET FECHA=@_FECHA, HORA=@_HORA, ESTADO=@_ESTADO WHERE IDHORARIO=@IDHORARIO
		set @RESPUESTA='Horario Actualizado correctamente'
		select @RESPUESTA as respuesta
      end	
   else
      begin
         set @RESPUESTA='Un medico ya tiene asignado la fecha  y hora elegida'
		select @RESPUESTA as respuesta
      end
   end
else if(@operacion='3')  --=============== PARA ELIMINAR horario
   begin
    IF EXISTS(SELECT IDHORARIO from HORARIOS where IDHORARIO=@IDHORARIO )
      begin
	     delete from HORARIOS where IDHORARIO=@IDHORARIO
	     set @RESPUESTA='Se elimino el Horario.'
		select @RESPUESTA as respuesta
      end
   else
      begin
		set @RESPUESTA='No existe registro'
		select @RESPUESTA as respuesta
	  end
   end
END
Go

declare @operacion varchar(100)
set @operacion='1'
exec sp_horario_mantenimiento  @operacion,'HOR010','MED001','LOC001','15/6/21','14:00','Disponible'
print @operacion

select * from HORARIOS




--================= STORE PROCEDURE MANTENIMIENTO CITAS =========================================
use BD_CITASMEDICAS
Go
if exists(select name from dbo.sysobjects WHERE name ='sp_citas_mantenimiento')
DROP procedure sp_citas_mantenimiento
Go

CREATE procedure sp_citas_mantenimiento
@OPERACION varchar(200) output,
@_CODIGOCITA           VARCHAR(6),
@_IDPAC                 VARCHAR(6),
@_IDHORARIO             VARCHAR(6),
@_FECHAREGCITA         varchar (35),
@_ESTADOCITA           char(20),
@_COMENTARIOCITA       char(100)
as
BEGIN
DECLARE @RESPUESTA NVARCHAR (200)
if(@OPERACION='1') --=========== PARA INSERTAR CITAS
   begin
    IF NOT EXISTS(SELECT CODIGOCITA from CITAS where IDHORARIO=@_IDHORARIO)
      begin
		IF NOT EXISTS(SELECT CODIGOCITA from CITAS where CODIGOCITA=@_CODIGOCITA)
		BEGIN
		INSERT INTO CITAS(CODIGOCITA,IDPAC,IDHORARIO,FECHAREGCITA,ESTADOCITA, COMENTARIOCITA)
			VALUES(@_CODIGOCITA,@_IDPAC,@_IDHORARIO,@_FECHAREGCITA,@_ESTADOCITA, @_COMENTARIOCITA);
			set @RESPUESTA='Se registro la cita con codigo '+@_CODIGOCITA	 
			select @RESPUESTA as respuesta  
		END
		ELSE
		BEGIN
			set @RESPUESTA='Ya esiste el registrado.' 
			select @RESPUESTA as respuesta
		END
      end
   else
      begin
         set @RESPUESTA='Ya se ha registrado una cita con este horario.' 
		select @RESPUESTA as respuesta
      end
   end

else if (@operacion='2')  --=============== PARA MODIFICAR CITA
   begin
    IF EXISTS(SELECT CODIGOCITA from CITAS where CODIGOCITA=@_CODIGOCITA)
      begin
		UPDATE CITAS SET ESTADOCITA=@_ESTADOCITA, COMENTARIOCITA=@_COMENTARIOCITA WHERE CODIGOCITA=@_CODIGOCITA
		 set @RESPUESTA='Se actualizo los datos de la cita correctamente' 
		select @RESPUESTA as respuesta
		  end
   else
      begin
         set @RESPUESTA='No existe la cita'
      end
   end
else if(@operacion='3')  --=============== PARA ELIMINAR CITA
   begin
    IF EXISTS(SELECT CODIGOCITA from CITAS where CODIGOCITA=@_CODIGOCITA)
      begin
	     UPDATE CITAS SET ESTADOCITA='De Baja' WHERE CODIGOCITA=@_CODIGOCITA
		 set @RESPUESTA='Cita '+@_CODIGOCITA +' dada de baja'
		select @RESPUESTA as respuesta
      end
   else
      begin
		set @RESPUESTA='No esiste registro' 
		select @RESPUESTA as respuesta
	  end
   end
end
Go

declare @operacion varchar(100)
set @operacion='1'
exec sp_citas_mantenimiento @operacion output,'CIT001','PAC001','HOR001','12/6/21','Pendiente',''
print @operacion
select * from CITAS
Go



/********************************
PROCEDMIENTO LOGIN
*********************************/

CREATE PROCEDURE LOGIN_PACIENTE
(
   @_USER               char(8),
   @_PASSPAC              char(15)  
)
WITH ENCRYPTION
as
BEGIN
SELECT * FROM PACIENTE WHERE DNIPAC= @_USER AND PASSPAC=@_PASSPAC AND ESTADOPAC like 'Activo';
END
GO


CREATE PROCEDURE LOGIN_ESPECIALISTA
( @_USER    char(8),
  @_PASSESPE  char(15)
)
WITH ENCRYPTION
AS
SELECT * FROM ESPECIALISTA WHERE DNIESP= @_USER AND PASSESP=@_PASSESPE AND ESTADOESP like 'Activo';
GO



/**************************************
PROCEDMIENTO HORARIOS DISPONIBLES 
***************************************/
CREATE VIEW vista_ListarHorariosDisponibles
AS SELECT * FROM HORARIOS where ESTADO='Disponible'

SELECT * FROM vista_ListarHorariosDisponibles


/**************************************
PROCEDMIENTO BUSCAR CITAS DNI PACIENTE 
***************************************/
CREATE PROCEDURE SP_ListarCitaIDPac
@_IDPAC VARCHAR(6)
AS
BEGIN
	SELECT *FROM CITAS WHERE IDPAC= @_IDPAC
END

EXECUTE SP_ListarCitaIDPac 'PAC001'


select * from  citas where CODIGOCITA='CIT001' AND IDPAC='PAC002'


/********************************
PROCEDMIENTO BUSCAR 
*********************************/

CREATE PROCEDURE BUSCAR_ID_TABLAS
@_TABLE VARCHAR(50),
@_ID   VARCHAR(6)
AS
if(@_TABLE='LOCAL') 
	BEGIN
	SELECT *FROM LOCAL WHERE IDLOCAL= @_ID
	END
else if(@_TABLE='MEDICO') 
	BEGIN
	SELECT *FROM MEDICO WHERE IDMEDICO= @_ID
	END
else if(@_TABLE='HORARIOS') 
	BEGIN
	SELECT *FROM HORARIOS WHERE IDHORARIO= @_ID
	END
else if(@_TABLE='CITAS') 
	BEGIN
	SELECT *FROM CITAS WHERE CODIGOCITA= @_ID
	END
else if(@_TABLE='ESPECIALISTA') 
	BEGIN
	SELECT *FROM ESPECIALISTA WHERE IDESP= @_ID
	END
else if(@_TABLE='PACIENTE') 
	BEGIN
	SELECT *FROM PACIENTE WHERE IDPAC= @_ID
	END
else if(@_TABLE='TIPOESPECIALIDADMEDICO') 
	BEGIN
	SELECT *FROM TIPOESPECIALIDADMEDICO WHERE IDTEMEDICO= @_ID
	END
GO
EXECUTE BUSCAR_ID_TABLAS 'PACIENTE','PAC001'



/********************************
LISTAR ALL CONTENIDO DE TABLAS
*********************************/

CREATE PROCEDURE SP_LISTAR_TABLAS_ALL
@_TABLE VARCHAR(50)
AS
if(@_TABLE='LOCAL') 
	BEGIN
	SELECT *FROM LOCAL 
	END
else if(@_TABLE='MEDICO') 
	BEGIN
	SELECT *FROM MEDICO 
	END
else if(@_TABLE='HORARIOS') 
	BEGIN
	SELECT *FROM HORARIOS
	END
else if(@_TABLE='CITAS') 
	BEGIN
	SELECT *FROM CITAS 
	END
else if(@_TABLE='ESPECIALISTA') 
	BEGIN
	SELECT *FROM ESPECIALISTA 
	END
else if(@_TABLE='PACIENTE') 
	BEGIN
	SELECT *FROM PACIENTE 
	END
else if(@_TABLE='TIPOESPECIALIDADMEDICO') 
	BEGIN
	SELECT *FROM TIPOESPECIALIDADMEDICO 
	END
GO
EXECUTE SP_LISTAR_TABLAS_ALL 'paciente'


   
/********************************
SCRIP TRANSACCIONES EN LA BD
*********************************/

--EXAMANINAR EL ARCHIVO LDF
SELECT [Current LSN],
[Operation],
[Transaction Name],
[Transaction ID],
[Transaction SID],
[SPID],
[Begin Time]

FROM fn_dblog(null, null)
WHERE [Transaction Name] IS NOT NULL
