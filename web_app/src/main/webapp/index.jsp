<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>

<%--Create URL--%>
<%--Page url--%>
<c:url var="listCourses" value="/courses/getCourses">
    <c:param name="page" value="1" />
</c:url>

<h4><a href="${listCourses}">Next Page</a></h4>




</body>
</html>
