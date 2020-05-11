
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: amannagpal
  Date: 2020-05-11
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Courses</title>
</head>
<body>
    <h1>Courses: Page: ${page}</h1>

    <%--Create URL--%>
    <%--Page url--%>
    <c:url var="nextPage" value="/courses/getCourses">
        <c:param name="page" value="${page}" />
    </c:url>

    <a href="${nextPage}">Next Page</a>

</body>
</html>
