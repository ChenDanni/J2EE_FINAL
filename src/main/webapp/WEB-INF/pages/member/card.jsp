<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/7
  Time: 下午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="会员卡管理"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/sidebar.jsp" var="sidebar">
    <c:param name="current" value="card-manage"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
<style type="text/css">
    .user-info-container{
        margin-top: 50px;
        display: flex;
        flex-direction: column;
        text-align: left;
    }
</style>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="../../assets/images/black.jpeg" width="150" height="150" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h5>
                        <c:if test="${state eq 1}">
                            <p class="text-success"><b>[已激活]</b></p>
                        </c:if>
                    ${name} <a href="/setCardInfo">修改信息</a>
                    </h5>
                </div>

                <div class="col-xs-6 col-sm-3">
                    <div class="user-info-container">
                        <p class="text-muted">等级: Lv.${level} <a href="#">关闭会员</a></p>
                        <p>账户余额: ${balance}
                            <%--<a href="/recharge">充值</a>--%>
                            <c:if test="${state == 0}">
                                <a class="btn btn-info btn-xs" href="/recharge">充值激活</a>
                            </c:if>
                            <c:if test="${state ne 0}">
                                <a class="btn btn-default btn-xs" href="/recharge">充值</a>
                            </c:if>
                        </p>
                        <p>积分: ${points} <a href="/use_points">使用积分</a></p>
                    </div>


                </div>
            </div>

            <h5 class="page-header">消费记录</h5>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
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