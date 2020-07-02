
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: amannagpal
  Date: 2020-05-11
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/view/includes/header.jsp" %>
<%--<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/includes/header.jsp" />--%>

    <div class="limiter">
        <div class="row">
            <h2 class="display-2 heading">
                ${heading}
            </h2>

        </div>
        <!-- /.row -->
        <div class="container-table100">
            <div class="row">
                <c:if test="${!empty message}">
                    <div class="row alert alert-success">
                            ${message}
                    </div>
                    <!-- /.alert -->

                </c:if>
            </div>
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
                                    <c:param name="page" value="${page-1}" />
                                </c:url>

                                <%--Create a URL to un-register for a course --%>
                                <c:url var="unregister" value="/courses/unregister">
                                    <c:param name="courseId" value="${course.coursesid}" />
                                </c:url>

                                    <tr>
                                        <td >${course.school}</td>
                                        <td >${course.code}</td>
                                        <td >${course.department}</td>
                                        <td >${course.name}</td>
                                        <td >${course.credits}</td>
                                        <td>
                                            <a href="${getCourseInformation}" class="btn btn-warning">View</a> |
                                            <c:if test="${!empty page}">
                                                <a href="${registerCourse}" class="btn btn-primary">Register</a>

                                            </c:if>
                                            <c:if test="${empty page}">
                                                <a href="${unregister}" class="btn btn-danger">Unregister</a>

                                            </c:if>

                                        </td>

                                    </tr>
                                </a>


                            </c:forEach>

                        </tbody>

                    </table>


                    <c:url var="nextPage" value="/courses/getCourses">
                        <c:param name="page" value="${page}" />
                    </c:url>

                    <c:url var="prevPage" value="/courses/getCourses">
                        <c:param name="page" value="${page - 2}" />
                    </c:url>

                    <c:if test="${!empty page}">
                        <div class="row" style="">
                            <div class="col">
                                <a href="${prevPage}" class="btn btn-primary">Prev Page</a>
                                <a href="${nextPage}" class="btn btn-primary">Next Page</a>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </c:if>

                    <!-- Url for home -->
                    <c:url var="home" value="/">
                    </c:url>
                    <a href="${home}" class="btn btn-primary action-button">Home</a>

                </div>
            </div>
        </div>
    </div>





<%--<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/includes/footer.jsp" />--%>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>

