🎓 EXAM SEAT OPTIMIZER
College Exam Seating Arrangement System
╔══════════════════════════════════════════════════════╗
║                  ADMIN DASHBOARD                    ║
╠══════════════════════════════════════════════════════╣
║  👨‍🎓 Student Mgmt   |  🏫 Room Mgmt   |  🧠 Allocate  ║
║──────────────────────────────────────────────────────║
║  📄 View Seating   |  🔓 Logout                     ║
╚══════════════════════════════════════════════════════╝

📌 Project Overview

This project automatically generates conflict-free exam seating arrangements ensuring students from the same branch never sit side-by-side.

🛠️ Technology Stack
Layer	Technology
Frontend	HTML, CSS
Backend	Java Servlets
Database	MySQL
Server	Apache Tomcat
IDE	IntelliJ IDEA
🗄️ Database Structure
STUDENT TABLE
+----+-------------------+--------+------------+
| id | name              | rollno | department |
+----+-------------------+--------+------------+

ROOM TABLE
+----+---------+----------+
| id | room_no | capacity |
+----+---------+----------+

ALLOCATION TABLE
+----+------------+---------+---------+
| id | student_id | room_id | seat_no |
+----+------------+---------+---------+

🔄 System Flow
Admin Login
     │
     ▼
Add Students ──► Add Rooms
     │
     ▼
Generate Seating Plan
     │
     ▼
View Seating Chart

🪑 Seating Algorithm

Students are grouped by branch and assigned in round-robin order:

CSE → IT → ME → CSE → IT → ME


So no two same-branch students sit together.

🌐 Important URLs
URL	Function
/login	Admin Login
/student	Add Student
/room	Add Room
/allocate	Generate Seats
/view	Seating Chart
/logout	Logout
▶️ How to Run
1️⃣ Import project in IntelliJ  
2️⃣ Add MySQL JDBC Connector  
3️⃣ Configure Tomcat  
4️⃣ Start Server  
5️⃣ Open Browser → http://localhost:8080/ExamSeatOptimizer/login

🎯 Objective

To automate college exam seating with zero conflicts and easy management.

👤 Author

Pratyush Kumar Thakur
B.Tech – Computer Science & Engineering
CUSAT
