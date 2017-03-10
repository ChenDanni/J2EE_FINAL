<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17/3/1
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="课程详情"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/sidebar.jsp" var="sidebar">
    <c:param name="current" value="all-courses"/>
</c:import>
<c:import url="../component/courseCard.jsp" var="courseCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h3>${name}</h3>
                    <p class="text-muted">2100 人学过</p>
                    <hr>
                    <p>价格: <span class="text-info">${price}</span></p>
                    <p>时间: <span class="text-info">${learn_time}</span></p>
                    <p>来自: <span class="text-info">${orgName}</span></p>
                    <p>教师: <span class="text-info">${teacher}</span></p>
                    <p>开课时间: <span class="text-info">${start_time}</span></p>
                    <c:if test="${state == 0}">
                        <p class="btn btn-default disabled">已预定</p>
                    </c:if>
                    <c:if test="${state != 0}">
                        <p> <a href="/course_detail" class="btn btn-primary">预约</a></p>
                    </c:if>

                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <h3>简介</h3>
                    <hr>
                    <p>${description}</p>
                </div>
            </div>

        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
