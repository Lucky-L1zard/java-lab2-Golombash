<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Форма студента</title>
    <style>
            .error { color: red; font-weight: bold; }
            .details-box {
                border: 1px solid #000;
                padding: 10px;
                background-color: #f0f0f0;
                margin: 15px 0;
            }
            .label { font-weight: bold; }
        </style>
</head>
<body>
    <c:if test="${not empty errorMessage}">
        <p class="error">${errorMessage}</p>
    </c:if>

    <h2>
        <c:choose>
            <c:when test="${student != null && student.id != 0}">Редагувати студента</c:when>
            <c:otherwise>Додати нового студента</c:otherwise>
        </c:choose>
    </h2>

    <form action="students" method="post">
        <c:if test="${student != null && student.id != 0}">
            <input type="hidden" name="id" value="${student.id}" />
            <p><span class="label">ID:</span> ${student.id}</p>
        </c:if>

        <p>
            ПІБ: <br>
            <input type="text" name="fullName" value="${student.fullName}" required />
        </p>

        <p>
            Email: <br>
            <input type="email" name="email" value="${student.email}" required />
        </p>

        <p>
            Дисципліна: <br>
            <select name="disciplineId" required>
                <option value="">-- Оберіть предмет --</option>
                <c:forEach var="disc" items="${disciplines}">
                    <option value="${disc.id}" ${disc.id == student.disciplineId ? 'selected' : ''}>
                        ${disc.name} (Викладач: ${disc.teacherName})
                    </option>
                </c:forEach>
            </select>
        </p>

        <c:if test="${student != null && student.disciplineId != 0}">
            <div class="details-box" style="border: 1px solid #ccc; padding: 10px; background: #f9f9f9;">
                <h4>Повна інформація про попередню обрану та збережену дисципліну:</h4>
                <c:forEach var="d" items="${disciplines}">
                    <c:if test="${d.id == student.disciplineId}">
                        <p><strong>Назва курсу:</strong> ${d.name}</p>
                        <p><strong>ПІБ Викладача:</strong> ${d.teacherName}</p>
                    </c:if>
                </c:forEach>
            </div>
        </c:if>

        <button type="submit">Зберегти</button>
        <a href="students">Скасувати</a>
    </form>
</body>
</html>