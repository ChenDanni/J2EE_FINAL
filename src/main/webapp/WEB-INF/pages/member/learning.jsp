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
                    <div class="panel panel-default">
                        <div class="panel-body course-detail-card">
                            <img src="assets/images/black.jpeg" alt="...">
                            <div class="course-card-info">
                                <h4>课程名</h4>
                                <p>价格: 3900 人数: 20 人</p>
                                <p>上课时间: 每周三 20:00-21:00</p>
                                <p>来自: 新东方 | 发布时间: 2017-02-27</p>
                                <p> <a href="#" class="btn btn-default packup-btn" role="button">收起进度</a></p>
                            </div>
                        </div>
                        <div class="list-group">
                            <a href="#" class="list-group-item disabled">第一课 2017-03-01</a>
                            <a href="#" class="list-group-item  active">第二课 2017-03-08</a>
                            <a href="#" class="list-group-item">第三课 2017-03-15</a>
                            <a href="#" class="list-group-item">第四课 2017-03-23</a>
                            <a href="#" class="list-group-item">第五课 2017-03-30</a>
                        </div>
                    </div>
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
