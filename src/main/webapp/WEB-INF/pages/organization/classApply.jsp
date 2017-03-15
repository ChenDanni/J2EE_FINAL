<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/8
  Time: 下午4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="开班申请"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="class-apply"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
<style type="text/css">
    label{
        margin-top: 16px;
    }
</style>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-6 col-sm-offset-3 col-md-7 col-md-offset-2 main">
            <h4 class="page-header">开班申请</h4>

            <%--<form class="form-signin">--%>
            <form>
                <label for="course-name">课程名</label>
                <input type="text" name="course-name" id="course-name" class="form-control" placeholder="课程名" required autofocus>

                <label for="start-time">开课时间</label>
                <input type="date" id="start-time" name="start-time" class="form-control" placeholder="开课时间" required autofocus>

                <label for="learn-time">上课时间</label>
                <input type="text" id="learn-time" name="learn-time" class="form-control" placeholder="上课时间" required autofocus>

                <label for="teacher">教师</label>
                <input type="text" id="teacher" class="form-control" name="teacher" placeholder="教师" required autofocus>

                <label for="price">价格</label>
                <input type="text" id="price" class="form-control" placeholder="价格" name="price" required autofocus>

                <label for="memberNum">班级人数</label>
                <input type="text" id="memberNum" class="form-control" placeholder="班级人数" name="memberNum" required autofocus>

                <label for="description">课程简介</label>
                <%--<input type="" id="description" class="form-control" placeholder="价格" required autofocus>--%>
                <textarea id="description" class="form-control" placeholder="课程简介" name="description" rows="5"></textarea>

                <h5 class="page-header">课时详情</h5>
                <div id="lessons">
                    <p>课时1: <input type="text" name="lesson-title-1" class="form-control" placeholder="本节标题" required autofocus>
                        <input type="text" name="lesson-des-1" class="form-control" placeholder="本节内容" required autofocus></p>
                </div>

            </form>
            <button id="add-lesson" class="btn btn-lg btn-default">增加课时</button>
            <hr>
            <a href="/card" class="btn btn-lg btn-default">取消</a>
            <button id="apply-btn" class="btn btn-lg btn-default">申请开班</button>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
<script src="../../assets/js/classApply.js"></script>
</body>
</html>