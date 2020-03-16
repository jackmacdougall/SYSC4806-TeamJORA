CREATE DATABASE IF NOT EXISTS jora;
USE jora;


/*CREATE TABLE student_groups (
    ID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    maxSize INT,
    PRIMARY KEY(ID));*/

CREATE TABLE persons (
    ID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    type VARCHAR(255),
    PRIMARY KEY(ID))

/*CREATE TABLE students (
    ID INT NOT NULL AUTO_INCREMENT,
    groupID INT,
    name VARCHAR(255),
    studentNumber INT UNIQUE,
    PRIMARY KEY(ID),
    FOREIGN KEY(groupID) REFERENCES student_groups(ID)
);*/
