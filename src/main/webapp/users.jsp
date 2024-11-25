<html>
<head>
    <title>Users</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Account Balance</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.accountBalance}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
