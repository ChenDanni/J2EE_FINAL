<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/8
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="修改信息"/>
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
            <h5 class="page-header">信息修改</h5>

            <%--<form class="form-signin">--%>
            <form>

                <label for="username">用户名</label>
                <input type="text" id="username" class="form-control" placeholder="用户名" required autofocus>

                <label for="phone">电话</label>
                <input type="text" id="phone" class="form-control" placeholder="电话" required autofocus>

                <label for="account-id">绑定银行卡号</label>
                <input type="text" id="account-id" class="form-control" placeholder="银行卡号" required autofocus>


                <%--<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>--%>
                <%--<p class="lead">--%>
                <a href="/card" class="btn btn-lg btn-default">取消</a>
                <a href="/card" class="btn btn-lg btn-default">确认修改</a>
                <%--</p>--%>
            </form>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>