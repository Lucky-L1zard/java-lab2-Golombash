<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h2>Список студентів</h2>
    <a href="students?action=new">Додати нового студента</a>
    <table border="1">
        <tr>
            <th>ID</th><th>ПІБ</th><th>Email</th><th>Дисципліна (ID)</th><th>Дії</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.fullName}</td>
                <td>${student.email}</td>
                <td>
                    <c:forEach var="d" items="${disciplines}">
                        <c:if test="${d.id == student.disciplineId}">
                            ${d.name} <small>(${d.teacherName})</small>
                        </c:if>
                    </c:forEach>
                </td>
                    <a href="students?action=edit&id=${student.id}">Редагувати</a>
                    <a href="students?action=delete&id=${student.id}">Видалити</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>