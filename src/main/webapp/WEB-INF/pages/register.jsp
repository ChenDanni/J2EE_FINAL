<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17/3/1
  Time: 下午3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="component/_head.jsp" var="head">
    <c:param name="title" value="注册"/>
</c:import>
<style type="text/css">
    .form-control{
        margin-bottom: 16px;
        height:40px;
    }
    .register-container{
        float: right;
        padding:20px 20px;
        background-color: white;
        height:400px;
        width:370px;
        box-shadow: 2px 2px 6px black;
        border-radius: 2px;
        margin-top: 100px;
        margin-right: 60px;
    }
</style>
${head}
<body  style="background-image: url('../../assets/images/background.jpg');background-size:1460px 870px;">
<div class="container">
<div class="register-container">
    <form class="form-signin col-md-12" action="/register" method="post">
        <h2 class="form-signin-heading">学员注册</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="inputUsername" class="form-control" name="username" placeholder="用户名" required autofocus>
        <label for="inputPhone" class="sr-only">手机</label>
        <input type="text" id="inputPhone" class="form-control" placeholder="手机" name="phone" required autofocus>
        <label for="inputPassword" class="sr-only">输入密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="输入密码" name="password" required>
        <label for="inputPasswordAgain" class="sr-only">再次输入密码</label>
        <input type="password" id="inputPasswordAgain" class="form-control" name="pwd_again" placeholder="再次输入密码" required>

        <c:if test="${!empty message}">
            <span class="text-danger">${message}</span>
        </c:if>

        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div>



</div> <!-- /container -->

<c:import url="component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
