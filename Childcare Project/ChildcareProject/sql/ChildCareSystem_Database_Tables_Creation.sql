CREATE DATABASE CHILDCARESYSTEM;
USE CHILDCARESYSTEM;

DROP TABLE IF EXISTS Teacher;
DROP TABLE IF EXISTS Activity;
DROP TABLE IF EXISTS ClassRoom;
DROP TABLE IF EXISTS Kids;
DROP TABLE IF EXISTS Weeks;
DROP TABLE IF EXISTS Parents;
DROP TABLE IF EXISTS Payments;
DROP TABLE IF EXISTS Schedule;

CREATE TABLE Teacher(
	Teacher_ID	INT NOT NULL PRIMARY KEY,
	First_Name VARCHAR(20) NOT NULL,
    Last_Name VARCHAR(20) NOT NULL,
    Phone_Number VARCHAR(15),
    Address VARCHAR(50) NOT NULL,
    Start_date DATE
)ENGINE=InnoDB;  

CREATE TABLE Weeks(
	Week_ID INT NOT NULL PRIMARY KEY,
    Start_Date DATE,
    End_Date DATE,
    Days_Worked INT NOT NULL
)ENGINE=InnoDB;

CREATE TABLE Activity(
	Activity_ID INT NOT NULL PRIMARY KEY,
	Tile VARCHAR(20) NOT NULL,
    Activity_date DATE NOT NULL
)ENGINE=InnoDB;

CREATE TABLE Parents(
	Parents_ID INT NOT NULL PRIMARY KEY,
    First_Name VARCHAR(20) NOT NULL,
    Last_Name VARCHAR(20) NOT NULL,
    Phone_Number VARCHAR(15),
    Address VARCHAR(50) NOT NULL,
    Number_of_Kids INT
)ENGINE=InnoDB;

CREATE TABLE Kids(
	Kids_ID INT NOT NULL PRIMARY KEY,
    First_Name VARCHAR(20) NOT NULL,
    Last_Name VARCHAR(20) NOT NULL,
    Date_Of_Birth DATE,
	Start_Date DATE NOT NULL,
    End_Date DATE,
    kids_Status VARCHAR(10),
    Parents_ID INT NOT NULL,
    FOREIGN KEY FK_Parents_ID(Parents_ID) REFERENCES Parents(Parents_ID)
)ENGINE=InnoDB;

CREATE TABLE ClassRoom(
	ClassRoom_ID INT NOT NULL PRIMARY KEY,
    ClassRoom_Date DATE NOT NULL UNIQUE,
    Teacher_ID INT NOT NULL,
    Activity_ID INT NOT NULL,
    Week_ID INT NOT NULL,
    ClassRoom_Report VARCHAR(60),
    NumberOfKids INT,
    FOREIGN KEY FK_Teacher_ID(Teacher_ID) REFERENCES Teacher(Teacher_ID),
    FOREIGN KEY FK_Activity_ID(Activity_ID) REFERENCES Activity(Activity_ID),
    FOREIGN KEY FK_Num_Week(Week_ID) REFERENCES Weeks(Week_ID)
)ENGINE=InnoDB;

CREATE TABLE Payments(
	Payments_ID INT NOT NULL PRIMARY KEY,
    Parents_ID INT NOT NULL,
    Payment_Date DATE,
    Payment_Method VARCHAR(15),
    FOREIGN KEY FK_Parents_ID(Parents_ID) REFERENCES Parents(Parents_ID)
)ENGINE=InnoDB;

CREATE TABLE Schedule(
	Schedule_ID INT NOT NULL PRIMARY KEY,
    ClassRoom_ID INT NOT NULL,
    Kids_ID INT NOT NULL,
    Schedule_date DATE,
    Start_time VARCHAR(10),
    End_time VARCHAR(10),
    FOREIGN KEY FK_kids_ID(kids_ID) REFERENCES kids(kids_ID),
    FOREIGN KEY FK_ClassRoom(ClassRoom_ID) REFERENCES ClassRoom(ClassRoom_ID)
)ENGINE=InnoDB;