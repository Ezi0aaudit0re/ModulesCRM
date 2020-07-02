<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amannagpal
  Date: 2020-05-13
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="includes/header.jsp"%>

<div class="limiter" style="height: 100%; margin: 0 auto">
    <%--<div id="course-information-img">--%>
        <%--<img src="${pageContext.request.contextPath}/resources/images/bu-img.jpg" alt="" width="100%" height="200px">--%>
    <%--</div>--%>
     <div class="row" style="border-bottom: 2px solid white">

         <h3 class="display-3">Name: ${courseInformation.name}</h3>
     </div>

     <div class="row">
         <div class="col" >


             <h3 class="description">Description</h3>
             <p class="lead">${courseInformation.description}</p>

         </div>
         <!-- /.col -->

         <div class="col">

             <h4 class="display-4">${courseInformation.school} ${courseInformation.department} ${courseInformation.code}</h4>

             <a href="${courseInformation.url}" target="_blank" class="display-4"></a>

             <h3 class="display-3">Pre Requisites</h3>
             <p class="lead">${courseInformation.preReq}</p>



         </div>
         <!-- /.col -->


     </div>
        <%--Create a URL to register for a course --%>
        <c:url var="registerCourse" value="/courses/register">
            <c:param name="courseId" value="${courseInformation.coursesid}" />
            <c:param name="page" value="${page-1}" />
        </c:url>

        <%-- Create a URL to go back for a course --%>
        <c:url var="back" value="/courses/getCourses">
            <c:param name="page" value="${page-1}" />
        </c:url>
        <div class="row">
        <a href="${registerCourse}" class="btn btn-primary" class="action-button">Register</a>
        <a href="${back}" class="btn btn-secondary" class="action-button">Back</a>
    </div>
    <!-- /.row -->


</div>


<%@ include file="includes/footer.jsp"%>
