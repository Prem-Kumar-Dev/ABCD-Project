<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <title>Cover</title>
    <style>body{
        font-family: 'Roboto', sans-serif;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        opacity: 0;
        transition: opacity 0.5s ease-in-out;
    }

    body.fade-in {
        opacity: 1;
    }
    .bar{
        position: relative;
        display: flex;
        justify-content: space-between;
        padding: 20px 80px 20px 100px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        background:none;

    }
    .logo {
        width: 30px;
        height: 30px;
        object-fit: cover;
    }
    .right-section{
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .right-section div{
        margin-right: 20px;
    }


    .contact:hover, .about:hover, .admin-login:hover{
        cursor: pointer;
        color:rgba(253, 146, 58, 0.837);
    }
    .background {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: -1;
    }

    .bg {
        width: 100%;
        height: 100%;
        object-fit: cover;

    }
    .contant {
        display: flex;
        margin-top: 70px;
        justify-content: center;
        align-items: center;
        overflow: hidden;


    }
    .bgim {
        box-shadow: 5px 1px #0017B2;
        border-radius: 50px;
        width: 500px;
        height: 500px;
        object-fit: cover;
    }
    .info {
        padding-top: 70px;
        width: 500px;
        height: 500px;
    }
    .text {
        font-size: 90px;
        font-weight: 700;
        color: white;
        margin-bottom: 20px;
    }

    .buttons {
        display: flex;
        margin-top: 100px;
    }


    .button1,.button2 {
        position: relative;
        border: 1px solid #00abf0;
        color: rgba(245, 245, 245, 0.856);
        padding: 13px 25px;
        border-radius: 10px;
        font-size: 18px;
        font-weight: 500;
        margin-right: 50px;
        transition: all 0.3s ease-in-out;
        overflow: hidden;
        z-index: 1;

    }
    .button1 {
        color: #081b29;
        background-color: #82d6f7;
    }


    .button1::before,
    .button2::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        width: 0;
        height: 100%;
        background-color:#0025BE;
        z-index: -1;
        transition: 0.5s;
    }
    .button2::before {
        background-color: #82d6f7;
    }
    .button2:hover {
        cursor: pointer;
        color: #081b29;
    }
    .button1:hover{
        cursor: pointer;
        color: rgba(245, 245, 245, 0.856);
    }

    .button1:hover::before,
    .button2:hover::before {
        width: 100%;

    }

    </style>
</head>

<body>
<div class="bar">
    <div class="logo">
        <img src="<c:url value='/static/Cover/style/icons/icon.png' />" alt="logo" class="logo">  <!-- Correct path for logo -->
    </div>
    <div class="right-section">
        <div class="about" onclick="location.href='<c:url value="/static/Profile/index.html" />';">About Us</div>
        <div class="FAQ">FAQ</div>
        <div class="contact" onclick="location.href='<c:url value="/static/Portfolio/index.html" />';">Contact Us</div>
        <div class="admin-login" onclick="location.href='<c:url value="/admin_login" />';">Admin</div>
    </div>
</div>

<div class="background">
    <img src="<c:url value='/static/Cover/style/icons/bg.jpeg' />" alt="bg" class="bg">  <!-- Correct path for background -->
</div>

<div class="contant">
    <div class="info">
        <h1 class="text">Online Banking</h1> <!-- Fixed invalid <h> tag -->
        <div class="buttons">
            <div class="button1" onclick="location.href='<c:url value="/user_register" />';">Sign Up</div>
            <div class="button2" onclick="location.href='<c:url value="/user_login" />';">Login</div>
        </div>
    </div>
    <div class="img">
        <img src="<c:url value='/static/Cover/style/icons/bgim.jpeg' />" alt="bgim" class="bgim">
    </div>
</div>

<script>
    function navigateWithFade(url) {
        document.body.classList.remove('fade-in');
        setTimeout(() => {
            window.location.href = url;
        }, 500);
    }

    window.addEventListener('DOMContentLoaded', () => {
        document.body.classList.add('fade-in');
    });
</script>

</body>

</html>
