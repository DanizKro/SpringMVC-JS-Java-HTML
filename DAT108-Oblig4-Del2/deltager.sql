-- Names in SQL must begin with a letter (a-z) or underscore (_). 
-- Subsequent characters in a name can be letters, digits (0-9), or underscores.

-- Dette eksemplet innholder en 1:N-forbindelse mellom entitetstypene ansatt og avdeling. 

-- Sletter hele sulamitten og oppretter på nytt.

DROP SCHEMA IF EXISTS DAT108_oblig4 CASCADE;
CREATE SCHEMA DAT108_oblig4;
SET search_path TO DAT108_oblig4;
    
-- 

CREATE TABLE deltager
(
	mobil VARCHAR(8) PRIMARY KEY,
    fornavn VARCHAR(30),
    etternavn VARCHAR(30),
    kjonn VARCHAR(6),
    hash VARCHAR(64) NOT NULL,
    salt VARCHAR(32) NOT NULL
);