<html>
<head>
    <title>Admins</title>
</head>
<body>
    <h1>Admin List</h1>
    <table border="1">
        <tr>
            <th>Admin ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Role</th>
        </tr>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <td>${admin.adminId}</td>
                <td>${admin.name}</td>
                <td>${admin.email}</td>
                <td>${admin.phoneNumber}</td>
                <td>${admin.role}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
