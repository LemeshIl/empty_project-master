CREATE TABLE IF NOT EXISTS Person (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    age        INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS House (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    address    VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Person_House (
    person_id   INTEGER  NOT NULL,
    house_id    INTEGER  NOT NULL,

    PRIMARY KEY (person_id, house_id)
);

CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(50),
    full_name  VARCHAR(50),
    inn        VARCHAR(50),
    kpp        VARCHAR(50),
    address    VARCHAR(50),
    phone      VARCHAR(50),
    is_Active    NUMBER(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    org_Id      INTEGER NOT NULL,
    name       VARCHAR(50),
    address    VARCHAR(50),
    phone      VARCHAR(50),
    is_Active   NUMBER (1) NOT NULL
);

CREATE TABLE IF NOT EXISTS User_Bell (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    first_Name         VARCHAR(50),
    second_Name        VARCHAR(50),
    middle_Name        VARCHAR(50),
    position          VARCHAR(50),
    phone             VARCHAR(50),
     doc_Name          VARCHAR(50),
     doc_Number        VARCHAR(50),
     doc_Date           VARCHAR(50),
     citizenship_Name   VARCHAR(50),
     citizenship_Code   VARCHAR(50),
     office_Id          INTEGER NOT NULL,
     is_Identified       NUMBER(1) NOT NULL
);

CREATE INDEX IX_Person_House_Id ON Person_House (house_id);
ALTER TABLE Person_House ADD FOREIGN KEY (house_id) REFERENCES House(id);

CREATE INDEX IX_House_Person_Id ON Person_House (person_id);
ALTER TABLE Person_House ADD FOREIGN KEY (person_id) REFERENCES Person(id);

CREATE SEQUENCE SEQ_OFFICE MINVALUE 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_ORGANIZATION MINVALUE 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_USER_BELL MINVALUE 1 INCREMENT BY 1;
