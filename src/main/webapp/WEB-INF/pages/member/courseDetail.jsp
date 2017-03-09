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
    <c:param name="title" value="所有课程"/>
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
                    <h3>课程名</h3>
                    <p class="text-muted">2100 人学过</p>
                    <hr>
                    <p>价格: <span class="text-info">1980</span></p>
                    <p>时间: <span class="text-info">每周三20:00-21:00</span></p>
                    <p>来自: <span class="text-info">新东方南京店</span></p>
                    <p>教师: <span class="text-info">教师名</span></p>
                    <p> <a href="/course_detail" class="btn btn-primary" role="button">预约</a></p>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <h3>简介</h3>
                    <hr>
                    <p>新东方在线资深一线名师
                        结合近3年托福动向，紧跟趋势
                        独家1对1平台，全程跟踪学习进程
                        15大金牌服务，360°保障学习进度
                        未达目标，协议重读，分数有保障
                        ETS官方TPO，正版授权
                        适中，平均382元/小时</p>
                </div>
            </div>

        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
