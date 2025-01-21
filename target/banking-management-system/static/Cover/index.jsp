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
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/Cover/style/general.css' />">  <!-- Correct path for CSS -->
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
        <div class="admin-login" onclick="location.href='<c:url value="/banking_management_system_war/admin_login" />';">Admin</div>
    </div>
</div>

<div class="background">
    <img src="<c:url value='/static/Cover/style/icons/bg.jpeg' />" alt="bg" class="bg">  <!-- Correct path for background -->
</div>

<div class="contant">
    <div class="info">
        <h1 class="text">Online Banking</h1> <!-- Fixed invalid <h> tag -->
        <div class="buttons">
            <div class="button1" onclick="location.href='<c:url value="/banking_management_system_war/user_register" />';">Sign Up</div>
            <div class="button2" onclick="location.href='<c:url value="/banking_management_system_war/user_login" />';">Login</div>
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
