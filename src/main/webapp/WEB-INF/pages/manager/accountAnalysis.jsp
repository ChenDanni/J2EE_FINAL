<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/15
  Time: 上午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="平台财务统计"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/manager/managerSidebar.jsp" var="sidebar">
    <c:param name="current" value="account-analysis"/>
</c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h5 class="page-header">会员充值情况</h5>
            <div id="recharge" style="height: 400px;width: 600px;">

            </div>
            <h5 class="page-header">退课结算情况</h5>
            <div id="quit" style="height: 400px;width: 600px;">

            </div>
            <h5 class="page-header">机构结算情况</h5>
            <div id="set-account" style="height: 400px;width: 600px;">

            </div>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
<script src="../../assets/js/accountAnalysis.js"></script>
</body>
</html>