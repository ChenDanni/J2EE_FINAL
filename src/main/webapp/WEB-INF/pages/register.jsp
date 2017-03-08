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
${head}
<body>
<div class="container">

    <form class="form-signin">
        <h2 class="form-signin-heading">学员注册</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="email" id="inputUsername" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPhone" class="sr-only">手机</label>
        <input type="email" id="inputPhone" class="form-control" placeholder="手机" required autofocus>
        <label for="inputPassword" class="sr-only">输入密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="输入密码" required>
        <label for="inputPasswordAgain" class="sr-only">再次输入密码</label>
        <input type="password" id="inputPasswordAgain" class="form-control" placeholder="再次输入密码" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div> <!-- /container -->





<c:import url="component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
