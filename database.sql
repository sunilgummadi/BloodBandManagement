CREATE DATABASE blood_bank;
USE blood_bank;

 

CREATE TABLE bb_user(ID INT(5) NOT NULL AUTO_INCREMENT,USER_NAME VARCHAR(25) NOT NULL UNIQUE,USER_PASSWD VARCHAR(25) NOT NULL,PRIMARY KEY (ID));
DESC bb_user;

 

SELECT * FROM bb_user;

 

CREATE TABLE bb_request(patient_id INT(5) NOT NULL auto_increment,patient_name VARCHAR(50)  NOT NULL,blood_group VARCHAR(5)  NOT NULL,city VARCHAR(20) NOT NULL,
doctor_name VARCHAR(50)  NOT NULL,hospital_address VARCHAR(100)  NOT NULL, when_date VARCHAR(10)  NOT NULL,contact_name VARCHAR(50)  NOT NULL,
contact_number VARCHAR(10)  NOT NULL,contact_email VARCHAR(50)  NOT NULL,request_status VARCHAR(20) NOT NULL,account_id INT(5) NOT NULL,PRIMARY KEY(patient_id), 
FOREIGN KEY (account_id) REFERENCES bb_user(ID));
DESC bb_request;

 

SELECT * FROM bb_request;

 

 

CREATE TABLE bb_donar(patient_id INT(5) NOT NULL AUTO_INCREMENT,donar_name VARCHAR(50) NOT NULL,blood_group VARCHAR(5) NOT NULL,city VARCHAR(20) NOT NULL,
glucose_level VARCHAR(10) NOT NULL,sample_time VARCHAR(5) NOT NULL,donation_status VARCHAR(20) NOT NULL,account_id INT(5) NOT NULL,PRIMARY KEY(patient_id),
 FOREIGN KEY (account_id) REFERENCES bb_user(ID));

 

DESC bb_donar;
SELECT * FROM bb_donar;