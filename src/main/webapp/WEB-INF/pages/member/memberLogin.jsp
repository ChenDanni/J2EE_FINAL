<%--
  Created by IntelliJ IDEA.
  User: chendanni
  Date: 17/3/1
  Time: 下午3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="登录"/>
</c:import>
${head}
<style type="text/css">
    .login-btn{
        margin:16px 10px;
        height:40px;
        font-size: 16px;
        padding:10px 40px;

    }
    .login-input{
        margin-top: 16px;
        height:40px;
    }

    .login-container{
        float: right;
        padding:20px 20px;
        background-color: white;
        height:270px;
        width:370px;
        box-shadow: 2px 2px 6px black;
        border-radius: 2px;
        margin-top: 150px;
        margin-right: 60px;
        /*opacity: .9;*/

    }
</style>

<body style="background-image: url('../../assets/images/background.jpg');background-size:1460px 870px;">

<div class="container">
    <div class="login-container">
        <form class="form-signin col-md-12" action="/memberHome" method="post">
            <h4 class="form-signin-heading">登录</h4>
            <label for="inputCardId" class="sr-only">帐号</label>
            <input type="text" id="inputCardId" class="form-control login-input" placeholder="会员卡号" name="cardId" required autofocus>
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" id="inputPassword" class="form-control login-input" placeholder="密码" name="password" required>
            <button type="submit" class="btn btn-lg btn-primary login-btn">登陆</button>
            <a href="/register" class="btn btn-lg btn-default login-btn">注册</a>

        </form>
    </div>


</div> <!-- /container -->


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
