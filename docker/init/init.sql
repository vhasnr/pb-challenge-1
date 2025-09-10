-- Create login for chal1 user
CREATE LOGIN chal1 WITH PASSWORD = '0e0e6bcb-db71-4256-b2a4-a7719f52e263';

-- Create the challenge1 database
CREATE DATABASE challenge1;
GO

-- Use the challenge1 database
USE challenge1;

-- Create user chal1 in the challenge1 database
CREATE USER chal1 FOR LOGIN chal1;

-- Grant full access to chal1 user in challenge1 database
ALTER ROLE db_owner ADD MEMBER chal1;

-- Grant additional permissions for full access
GRANT CONTROL TO chal1;
GRANT CREATE TABLE TO chal1;
GRANT CREATE VIEW TO chal1;
GRANT CREATE PROCEDURE TO chal1;
GRANT CREATE FUNCTION TO chal1;
GRANT CREATE SCHEMA TO chal1;
