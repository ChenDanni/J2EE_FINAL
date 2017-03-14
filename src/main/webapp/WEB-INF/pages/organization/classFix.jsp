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
    <c:param name="title" value="课程修改申请"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="class-apply"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h5 class="page-header">开班申请</h5>

            <%--<form class="form-signin">--%>
            <form>
                <input type="hidden" name="classId" value="${id}">
                <label for="course-name">课程名</label>
                <input type="text" name="course-name" id="course-name" class="form-control" value="${name}" required autofocus>

                <label for="start-time">开课时间</label>
                <input type="date" id="start-time" name="start-time" class="form-control" value="${start_time}" required autofocus>

                <label for="learn-time">上课时间</label>
                <input type="text" id="learn-time" name="learn-time" class="form-control" placeholder="上课时间" required autofocus>

                <label for="teacher">教师</label>
                <input type="text" id="teacher" class="form-control" name="teacher" value="${teacher}" required autofocus>

                <label for="price">价格</label>
                <input type="text" id="price" class="form-control" value="${price}" name="price" required autofocus>

                <label for="memberNum">班级人数</label>
                <input type="text" id="memberNum" class="form-control" value="${memberNum}" name="memberNum" required autofocus>

                <label for="description">课程简介</label>
                <%--<input type="" id="description" class="form-control" placeholder="价格" required autofocus>--%>
                <textarea id="description" class="form-control" name="description" rows="5">${description}</textarea>

                <h5 class="page-header">课时详情</h5>


                <div id="lessons">
                    <c:forEach items="${lessons}" var="lesson">
                        <p>课时${lesson.order}: <input type="text" name="lesson-title-${lesson.order}" class="form-control" value="${lesson.title}" required autofocus>
                            <input type="text" name="lesson-des-${lesson.order}" class="form-control" value="${lesson.context}" required autofocus></p>
                    </c:forEach>

                </div>


            </form>
            <%--<button id="add-lesson" class="btn btn-lg btn-default">增加课时</button>--%>
            <hr>
            <a href="/org_courses" class="btn btn-lg btn-default">取消</a>
            <button id="apply-btn" class="btn btn-lg btn-default">申请修改</button>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
<script src="../../assets/js/classFix.js"></script>
</body>
</html>