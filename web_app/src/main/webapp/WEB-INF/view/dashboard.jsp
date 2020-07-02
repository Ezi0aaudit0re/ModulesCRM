<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: amannagpal
  Date: 2020-07-01
  Time: 00:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/view/includes/header.jsp" %>
<%--<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/includes/header.jsp" />--%>

<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">

                <table class="">
                    <thead>
                    <tr class="table100-head thead-dark">
                        <th>School</th>
                        <th>Code</th>
                        <th>Department</th>
                        <th>Name</th>
                        <%--<th>URL</th>--%>
                        <th>Credits</th>
                        <th>Action</th>
                        <%--<th>Pre Requisites</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${courses}" >

                        <%--Create a URL --%>
                        <c:url var="getCourseInformation" value="/courses/getCourseInformation">
                            <c:param name="courseId" value="${course.coursesid}" />
                        </c:url>

                        <%--Create a URL to register for a course --%>
                        <c:url var="registerCourse" value="/courses/register">
                            <c:param name="courseId" value="${course.coursesid}" />
                        </c:url>


                        <tr>
                            <td >${course.school}</td>
                            <td >${course.code}</td>
                            <td >${course.department}</td>
                            <td >${course.name}</td>
                            <td >${course.credits}</td>
                            <td>
                                <a href="${getCourseInformation}" class="btn btn-warning">View</a> | <a href="${registerCourse}" class="btn btn-primary">Register</a>
                            </td>
                        </tr>
                        </a>


                    </c:forEach>

                    </tbody>

                </table>



        </div>
    </div>
</div>


<%--Create URL--%>
<%--Page url--%>



<%--<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/includes/footer.jsp" />--%>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>

