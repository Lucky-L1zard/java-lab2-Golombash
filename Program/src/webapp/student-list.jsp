<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список студентів</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }
        th { background-color: #f2f2f2; }
        .actions a { text-decoration: none; margin-right: 10px; color: blue; }
    </style>
</head>
<body>
    <h2>Список студентів</h2>
    <p><a href="students?action=new">➕ Додати нового студента</a></p>

    <table>
        <tr>
            <th>ID</th>
            <th>ПІБ</th>
            <th>Email</th>
            <th>ID Дисципліни</th> <%-- Спрощено згідно з завданням --%>
            <th>Дії</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.fullName}</td>
                <td>${student.email}</td>
                <td>
                    <%-- Показуємо лише ідентифікатор допоміжної сутності --%>
                    ID: ${student.disciplineId}
                </td>
                <td class="actions">
                    <a href="students?action=edit&id=${student.id}">Редагувати</a>
                    <a href="students?action=delete&id=${student.id}"
                       onclick="return confirm('Ви впевнені?')">Видалити</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>