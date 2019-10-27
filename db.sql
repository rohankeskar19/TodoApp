CREATE DATABASE todoapp;
USE todoapp;
CREATE TABLE users (username varchar(20) PRIMARY KEY,password varchar(100) NOT NULL);
CREATE TABLE todo (id varchar(50) NOT NULL PRIMARY KEY,username varchar(20) NOT NULL,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,content varchar(200)  NOT NULL,completed enum("Y","N") DEFAULT "N",due date NOT NULL);
