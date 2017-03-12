<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/8
  Time: 下午4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="学习登记"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="learn-record"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h5 class="page-header">已开课课程</h5>

            <c:forEach items="${courses}" var="course">
                <div class="panel panel-default">
                    <div class="panel-body course-detail-card">
                        <img src="assets/images/black.jpeg" alt="...">
                        <div class="course-card-info">
                            <h4>${course.name}</h4>
                            <p>价格: ${course.price} 总人数: ${course.memberNum} 人 剩余名额: ${course.leftMembers} 人</p>
                            <p>上课时间: ${course.learn_time}</p>
                            <p>开课日期: ${course.start_time}</p>
                            <p><a href="/org_learn_record_detail?id=${course.id}" class="btn btn-default" role="button">学习登记</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
