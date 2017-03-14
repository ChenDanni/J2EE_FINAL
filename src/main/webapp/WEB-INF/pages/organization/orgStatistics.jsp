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
    <c:param name="title" value="机构统计信息"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="org-statistics"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h5 class="page-header">课程数据</h5>
            <div id="courses-analysis" style="height: 400px;width: 500px;">

            </div>
            <div id="courses-start-analysis" style="height: 400px;width: 500px;">

            </div>
            <h5 class="page-header">学员学习情况</h5>
            <div id="learning-status" style="height: 400px;width: 500px;">

            </div>

            <h5 class="page-header">机构财务</h5>
            <div id="org-balance-analysis" style="height: 400px;width: 500px;">

            </div>


        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
<script src="../../assets/js/orgStatistics.js"></script>
</body>
</html>
