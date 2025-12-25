<!DOCTYPE html>
<html>
<head>
    <title>College Exam Seat Optimizer</title>
</head>
<body style="background:#0f172a;font-family:Segoe UI,Arial,sans-serif;color:#e2e8f0;">

<div style="width:80%;margin:40px auto;">

    <h2>🎓 College Exam Seat Arrangement Panel</h2>
    <p>Manage student records, rooms, and generate seating plans.</p>
    <hr style="border-color:#6366f1">

    <div style="display:grid;grid-template-columns:repeat(2,1fr);gap:25px;margin-top:30px;">

        <div style="background:#1e293b;padding:25px;border-radius:12px;">
            <h3>👨‍🎓 Student Management</h3>
            <p>Add and manage student details.</p>
            <a href="/ExamSeatOptimizer/student" style="color:#a78bfa;">Open</a>
        </div>

        <div style="background:#1e293b;padding:25px;border-radius:12px;">
            <h3>🏫 Room Management</h3>
            <p>Add rooms and define capacity.</p>
            <a href="/ExamSeatOptimizer/room" style="color:#a78bfa;">Open</a>
        </div>

        <div style="background:#1e293b;padding:25px;border-radius:12px;">
            <h3>🧠 Generate Seating Plan</h3>
            <p>Create seating arrangement for exams.</p>
            <a href="/ExamSeatOptimizer/allocate" style="color:#a78bfa;">Generate</a>
        </div>

        <div style="background:#1e293b;padding:25px;border-radius:12px;">
            <h3>📄 View Seating Chart</h3>
            <p>View final allocated seats.</p>
            <a href="/ExamSeatOptimizer/view" style="color:#a78bfa;">View</a>
        </div>

    </div>

    <p style="margin-top:40px;">
        <a href="/ExamSeatOptimizer/logout" style="color:#f87171;">Logout</a>
    </p>

</div>

</body>
</html>
