<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Форма студента</title>
</head>
<body>
    <h2>
        <c:if test="${student != null}">Редагувати студента</c:if>
        <c:if test="${student == null}">Додати нового студента</c:if>
    </h2>

    <form action="students" method="post">
        <c:if test="${student != null}">
            <input type="hidden" name="id" value="${student.id}" />
        </c:if>

        ПІБ: <input type="text" name="fullName" value="${student.fullName}" required /><br><br>
        Email: <input type="email" name="email" value="${student.email}" required /><br><br>

        Дисципліна:
        <select name="disciplineId">
            <c:forEach var="disc" items="${disciplines}">
                <option value="${disc.id}" ${disc.id == student.disciplineId ? 'selected' : ''}>
                    ${disc.name} (Викладач: ${disc.teacherName}) <%-- ПОВНА інформація --%>
                </option>
            </c:forEach>
        </select><br><br>

        <button type="submit">Зберегти</button>
        <a href="students">Скасувати</a>
    </form>
</body>
</html>