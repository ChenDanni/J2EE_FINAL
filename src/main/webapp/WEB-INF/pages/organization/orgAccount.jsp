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
    <c:param name="title" value="机构账户"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="org-account"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h5 class="page-header">机构账户</h5>

            <p>账户余额: ${balance}</p>
            <%--<p>银行卡号: 3241****6352 <a>修改</a></p>--%>
            <hr>
            <h5 class="page-header">结算明细</h5>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>课程</th>
                        <th>用户</th>
                        <th>状态</th>
                        <th>金额</th>
                        <th>账户余额</th>
                        <th>时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ops}" var="op">
                    <tr>
                        <td>${op.className}(${op.classId})</td>
                        <td>${op.cardId}</td>
                        <c:if test="${op.state eq 0}">
                            <td>退课</td>
                        </c:if>
                        <c:if test="${op.state eq 1}">
                            <td>完成课程</td>
                        </c:if>
                        <td>${op.money}</td>
                        <td>${op.balance}</td>
                        <td>${op.time}</td>
                    </tr>
                    </c:forEach>

                </table>
            </div>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>