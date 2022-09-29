CREATE DATABASE DemoApp;

SHOW DATABASES;

USE DemoApp;

SHOW TABLES;

CREATE TABLE librarydb(
book_name VARCHAR(60),
id VARCHAR(50),
isbn VARCHAR(50),
aisle int,
author VARCHAR(60),
PRIMARY KEY(id) 
);

INSERT INTO librarydb(book_name, id, isbn, aisle, author)
VALUES
("Appium","fdsefr343", "fdsefr3", 43, "Rahul Sheety");

SELECT * FROM librarydb WHERE id = "fdsefr343";

SELECT * FROM librarydb;

DROP TABLE LibraryDB;

USE sys;

SHOW TABLES;

SELECT * FROM host_summary;

DELETE FROM librarydb WHERE id = 'kkdit0';