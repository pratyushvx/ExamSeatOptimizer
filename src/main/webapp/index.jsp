<!DOCTYPE html>
<html>
<head>
    <title>Exam Seat Optimizer</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .hero{
            padding:70px 20px;
            text-align:center;
        }
        .hero h1{
            font-size:36px;
            color:#7f1d1d;
        }
        .hero p{
            max-width:700px;
            margin:20px auto;
            line-height:1.7;
        }

        .section{
            background:white;
            margin:40px auto;
            padding:40px;
            width:85%;
            border-radius:14px;
        }
    </style>
</head>
<body>

<div class="header"> Exam Seat Optimizer</div>

<div class="hero">
    <h1>Smart Classroom Seating Automation</h1>
    <p>
        Exam Seat Optimizer is an intelligent web-based system designed to automate
        classroom seating for college examinations. It avoids department-wise clustering
        and ensures fair, conflict-free seating using graph coloring algorithms.
    </p>

    <a href="login"><button style="width:160px;margin:10px">Login</button></a>
    <a href="signup"><button style="width:160px;margin:10px">Signup</button></a>
</div>

<div class="section">
    <h2> Features</h2>
    <ul>
        <li>Automatic student seat allocation</li>
        <li>Prevents same department students from sitting together</li>
        <li>8×3 real classroom bench visualization</li>
        <li>Graph Coloring based conflict-free algorithm</li>
    </ul>
</div>

<div class="section">
    <h2> How It Works</h2>
    <p>
        Admin adds students and rooms.
        System builds a conflict graph based on departments and assigns seats such that no
        two students of the same department are placed side by side or one behind another.
    </p>
</div>

</body>
</html>
