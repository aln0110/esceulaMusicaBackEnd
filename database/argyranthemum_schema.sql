
IF NOT EXISTS (
    SELECT name 
    FROM sys.databases 
    WHERE name = N'argyranthemum'
)
BEGIN
    CREATE DATABASE argyranthemum;
END;

-- Switch to the new database
USE argyranthemum;

-- Create schema for grouping related tables
IF NOT EXISTS (
    SELECT * FROM sys.schemas WHERE name = 'person'
)
BEGIN
    EXEC('CREATE SCHEMA person');
END;

-- Table: person.tbPerson
CREATE TABLE person.tbPerson (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    type_idcard VARCHAR(100) NOT NULL,
    idcard VARCHAR(100) NOT NULL UNIQUE,
    birth_date DATE NOT NULL,
    nationality VARCHAR(100) NOT NULL,
    gender VARCHAR(100) NOT NULL,
    status BIT NOT NULL
);

-- Table: person.tbUser
CREATE TABLE person.tbUser (
    id INT IDENTITY(1,1) PRIMARY KEY,
    id_persona INT NOT NULL UNIQUE,
    rol_user VARCHAR(50) NOT NULL,
    user_name VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) DEFAULT NULL,
    provider VARCHAR(50) NOT NULL, 
    oauth_id VARCHAR(255) DEFAULT NULL,
    avatar_url VARCHAR(MAX) DEFAULT NULL, 
    created_at DATETIME DEFAULT GETDATE(),
    last_login DATETIME DEFAULT GETDATE(), 
    status BIT NOT NULL,
    CONSTRAINT fk_user_persona
        FOREIGN KEY (id_persona) REFERENCES person.tbPerson(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Table: person.tbAddress
CREATE TABLE person.tbAddress (
    id INT IDENTITY(1,1) PRIMARY KEY, 
    id_persona INT NOT NULL UNIQUE,
    province VARCHAR(100) NOT NULL, 
    canton VARCHAR(100) NOT NULL, 
    district VARCHAR(100) NOT NULL,
    full_address VARCHAR(MAX) NOT NULL,
    status BIT NOT NULL,
    CONSTRAINT fk_address_persona
        FOREIGN KEY (id_persona) REFERENCES person.tbPerson(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Trigger for cascading status update
CREATE TRIGGER trg_UpdateRelatedStatus
ON person.tbPerson
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    UPDATE person.tbUser
    SET status = inserted.status
    FROM person.tbUser
    INNER JOIN inserted ON person.tbUser.id_persona = inserted.id;

    UPDATE person.tbAddress
    SET status = inserted.status
    FROM person.tbAddress
    INNER JOIN inserted ON person.tbAddress.id_persona = inserted.id;
END;
