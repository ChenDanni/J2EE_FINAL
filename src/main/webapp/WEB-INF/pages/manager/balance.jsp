<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/13
  Time: 下午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="平台财务"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/manager/managerSidebar.jsp" var="sidebar">
    <c:param name="current" value="platform-account"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div>
                <p>会员充值: ${recharge}</p>
                <p>退课结算: ${mh}</p>
                <p>机构结算: ${oh}</p>
                <p>平台余额: ${balance}</p>
            </div>

            <hr>

            <h5 class="page-header">收支记录</h5>
            <ul class="nav nav-tabs">
                <c:if test="${type eq 0}">
                    <li role="presentation" class="active"><a href="#">会员充值</a></li>
                    <li role="presentation"><a href="/manager_balance?type=1">退课结算</a></li>
                    <li role="presentation"><a href="/manager_balance?type=2">平台结算</a></li>
                </c:if>
                <c:if test="${type eq 1}">
                    <li role="presentation"><a href="/manager_balance?type=0">会员充值</a></li>
                    <li role="presentation" class="active"><a href="#">退课结算</a></li>
                    <li role="presentation"><a href="/manager_balance?type=2">平台结算</a></li>
                </c:if>
                <c:if test="${type eq 2}">
                    <li role="presentation"><a href="/manager_balance?type=0">会员充值</a></li>
                    <li role="presentation"><a href="/manager_balance?type=1">退课结算</a></li>
                    <li role="presentation" class="active"><a href="#">平台结算</a></li>
                </c:if>
            </ul>

            <c:if test="${type eq 0}">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>会员卡号</th>
                            <th>金额</th>
                            <th>平台充值总额</th>
                            <th>时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ops}" var="op">
                            <tr>
                                <td>1</td>
                                <td>${op.cardId}</td>
                                <td>${op.money}</td>
                                <td>${op.recharge}</td>
                                <td>${op.time}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>


            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>操作</th>
                        <th>金额</th>
                        <th>余额</th>
                        <th>剩余积分</th>
                        <th>日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ops}" var="op">
                        <tr>
                            <td>1</td>
                            <td>${op.name}</td>
                            <td>${op.charge}</td>
                            <td>${op.balance}</td>
                            <td>${op.points}</td>
                            <td>${op.time}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>