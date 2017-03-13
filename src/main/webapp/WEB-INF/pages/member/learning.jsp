<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/7
  Time: 下午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="正在学习的课程"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/sidebar.jsp" var="sidebar">
    <c:param name="current" value="courses-stu"/>
</c:import>
<c:import url="../component/siftButtons.jsp" var="shiftButtons"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            ${shiftButtons}
            <div class="row">
                <div class="col-sm-12 col-md-10">
                    <c:forEach items="${lessons}" var="lesson">
                        <div class="panel panel-default">
                            <div class="panel-body course-detail-card">
                                <img src="assets/images/black.jpeg" alt="...">
                                <div class="course-card-info">
                                    <h4>${lesson.name}</h4>
                                    <p>价格: ${lesson.price} 总人数: ${lesson.totalMember} 人</p>
                                    <p>上课时间: ${lesson.learn_time}</p>
                                    <p>来自: ${lesson.orgName} | 开课时间: ${lesson.start_time}</p>
                                    <p> <a href="#" class="btn btn-info packup-btn" role="button">收起进度</a> <a href="#" class="btn btn-danger quit-btn" role="button">退课</a></p>
                                </div>
                            </div>
                            <div class="list-group">
                                <c:forEach items="${lesson.attendance}" var="at">
                                    <c:if test="${at.attendance eq 0}">
                                        <p class="list-group-item">${at.lesson_name} <a class="btn btn-info disabled">未开始</a></p>
                                    </c:if>
                                    <c:if test="${at.attendance eq 1}">
                                        <p class="list-group-item">${at.lesson_name} <a class="btn btn-success disabled">出席</a></p>
                                    </c:if>
                                    <c:if test="${at.attendance eq 2}">
                                        <p class="list-group-item">${at.lesson_name} <a class="btn btn-danger disabled">缺席</a></p>
                                    </c:if>
                                </c:forEach>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
<script src="../../assets/js/learning.js"></script>
</body>
</html>
