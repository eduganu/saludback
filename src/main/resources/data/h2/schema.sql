DROP TABLE REGISTROS IF EXISTS;
DROP TABLE USUARIOS	IF EXISTS;

DROP TABLE DEMO IF EXISTS;
DROP TABLE PEOPLE IF EXISTS;



CREATE TABLE PEOPLE (
	DATETIME 		TIMESTAMP		NOT NULL,
	USER_ID			BIGINT			NOT NULL
);



CREATE TABLE USUARIOS (

	USER_ID			BIGINT			NOT NULL,
	NOMBRE			VARCHAR(100)	NOT NULL,
	APELLIDO		VARCHAR(100)	NOT NULL,
	SEXO			VARCHAR(100)	NOT NULL,
	NACIMIENTO		DATE			NOT NULL,
	ALTURA			DOUBLE(6)		NOT NULL,
	PESO			DOUBLE(6)		NOT NULL,
	PROFESION		VARCHAR(100)	NOT NULL,
	HOBBY			VARCHAR(100)	NOT NULL,
	PRIMARY KEY (USER_ID)
	
);


CREATE TABLE REGISTROS (

	DATETIME 		TIMESTAMP		NOT NULL,
	USER_ID			BIGINT			NOT NULL,
	BPM				INT				NOT NULL,
	STEP_ACC		INT				NOT NULL,
	SET_ACTIVO		BIT(1)			NOT NULL,
	LATITUD			DOUBLE(6)		NOT NULL,
	LONGITUD		DOUBLE(6)		NOT NULL,
	PRECISION		INT				NOT NULL,
	ESTADO			INT				NOT NULL

);


