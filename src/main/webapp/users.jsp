<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>
    <table border="1">
        <tr>
            <th>User ID</th>
            <td>${user.userId}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>Phone Number</th>
            <td>${user.phoneNumber}</td>
        </tr>
        <tr>
            <th>Account Balance</th>
            <td>${user.accountBalance}</td>
        </tr>
        <tr>
            <th>Status</th>
            <td>${user.status}</td>
        </tr>
    </table>
</body>
</html>
