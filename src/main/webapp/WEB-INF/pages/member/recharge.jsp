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
    <c:param name="title" value="会员卡充值"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/sidebar.jsp" var="sidebar">
    <c:param name="current" value="card-manage"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h5 class="page-header">会员卡充值</h5>

            <%--<form class="form-signin">--%>
            <form class="col-md-4" action="/recharge" method="post">
                <p>会员卡号: ${cardId}</p>
                <p>账户余额: ${balance}</p>
                <p>银行卡号: ${accountId}</p>
                <hr>
                <label for="rechargeNum">充值金额</label>

                <input type="text" id="rechargeNum" class="form-control" name="rechargeNum" placeholder="充值金额" required autofocus>

                <%--<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>--%>
                <%--<p class="lead">--%>
                <a href="/card" class="btn btn-lg btn-default">取消</a>
                <button type="submit" class="btn btn-lg btn-default">充值</button>
                <%--</p>--%>
            </form>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>