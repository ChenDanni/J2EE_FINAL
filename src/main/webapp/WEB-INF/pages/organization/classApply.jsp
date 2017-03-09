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

                <label for="course-name">课程名</label>
                <input type="text" id="course-name" class="form-control" placeholder="课程名" required autofocus>

                <label for="course-time">开课时间</label>
                <input type="text" id="course-time" class="form-control" placeholder="开课时间" required autofocus>


                <label for="teacher">教师</label>
                <input type="text" id="teacher" class="form-control" placeholder="教师" required autofocus>

                <label for="price">价格</label>
                <input type="text" id="price" class="form-control" placeholder="价格" required autofocus>

                <label for="description">课程简介</label>
                <%--<input type="" id="description" class="form-control" placeholder="价格" required autofocus>--%>
                <textarea id="description" class="form-control" placeholder="课程简介" rows="5"></textarea>

                <%--<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>--%>
                <%--<p class="lead">--%>
                <a href="/card" class="btn btn-lg btn-default">取消</a>
                <a href="/card" class="btn btn-lg btn-default">申请开班</a>
                <%--</p>--%>
            </form>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>