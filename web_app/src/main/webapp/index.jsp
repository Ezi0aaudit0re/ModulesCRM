<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>

<%--Create URL--%>
<%--Page url--%>
<c:url var="listCourses" value="/courses/getCourses">
    <c:param name="page" value="0" />
</c:url>

<h4><a href="${listCourses}">All Courses</a></h4>

<c:url var="registeredCourses" value="/courses/registeredCourses">
</c:url>

<h4><a href="${registeredCourses}">Registered Courses</a></h4>

</body>
</html>
