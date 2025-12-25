Exam Seat Optimizer

A web-based system to automate college exam seating arrangements using Java Servlets and MySQL.

Features

Admin login & logout

Add students

Add exam rooms with capacity

Automatic seating allocation

Visual seating chart display

Tech Stack

Frontend: HTML, CSS

Backend: Java Servlets

Database: MySQL

Server: Apache Tomcat

IDE: IntelliJ IDEA

Database Setup
CREATE DATABASE examseatoptimizer;
USE examseatoptimizer;

CREATE TABLE student(
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100),
 rollno VARCHAR(30),
 department VARCHAR(50)
);

CREATE TABLE room(
 id INT AUTO_INCREMENT PRIMARY KEY,
 room_no VARCHAR(20),
 capacity INT
);

CREATE TABLE allocation(
 id INT AUTO_INCREMENT PRIMARY KEY,
 student_id INT,
 room_id INT,
 seat_no INT
);

Workflow

Login as admin

Add students

Add rooms

Generate seating plan

View seating chart

Important URLs
URL	Purpose
/login	Login
/student	Add student
/room	Add room
/allocate	Generate seats
/view	View seating
/logout	Logout
How to Run

Import project in IntelliJ as a web project

Add MySQL JDBC connector

Configure Apache Tomcat

Start server

Open browser:

http://localhost:8080/ExamSeatOptimizer/login

Author

Pratyush Kumar Thakur
B.Tech – Computer Science & Engineering
CUSAT
