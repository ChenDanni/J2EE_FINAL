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
    <c:param name="title" value="热门课程"/>
</c:import>
<c:import url="../nav.jsp" var="nav"></c:import>
<c:import url="../component/sidebar.jsp" var="sidebar">
    <c:param name="current" value="hot-courses"/>
</c:import>
<c:import url="../component/courseCard.jsp" var="courseCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h5 class="page-header">类型</h5>
            <div class="row">
                ${courseCard}
                ${courseCard}
                ${courseCard}
                ${courseCard}
            </div>
            <h5 class="page-header">地区</h5>
            <div class="row">
                ${courseCard}
                ${courseCard}
                ${courseCard}
            </div>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
