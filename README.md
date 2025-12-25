🎓 Exam Seat Optimizer

A web-based application to generate conflict-free exam seating arrangements for colleges using Java Servlets, JDBC, and MySQL.

📌 Features

Admin Login & Logout

Student Management

Room Management

Automatic Seat Allocation

Visual Classroom-style Seating Chart

🛠️ Tech Stack
Layer	Technology
Frontend	HTML, CSS
Backend	Java Servlets
Database	MySQL
Server	Apache Tomcat
IDE	IntelliJ IDEA
🗄️ Database Setup

Create database:

CREATE DATABASE examseatoptimizer;
USE examseatoptimizer;


Create tables:

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

🔄 Workflow
Admin Login
→ Add Students
→ Add Rooms
→ Generate Seating Plan
→ View Final Seating Chart

🚀 How to Run

Import project in IntelliJ as Java Web Project

Add MySQL JDBC connector to classpath

Configure Tomcat Server

Run project

Open browser:

http://localhost:8080/ExamSeatOptimizer/login

📂 Main URLs
URL	Action
/login	Admin Login
/student	Add Student
/room	Add Room
/allocate	Generate Seats
/view	View Seating Chart
/logout	Logout
👨‍🏫 Project Objective

To automate college exam seating arrangements ensuring
students of the same department are not seated side-by-side.

👤 Author

Pratyush Kumar Thakur
B.Tech – Computer Science & Engineering
CUSAT
