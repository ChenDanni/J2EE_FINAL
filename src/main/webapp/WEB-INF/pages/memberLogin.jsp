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
<c:import url="_head.jsp" var="head">
    <c:param name="title" value="学员登陆"/>
</c:import>
${head}

<body>
<div class="container">

    <form class="form-signin">
        <h2 class="form-signin-heading">学员登陆</h2>
        <label for="inputCardId" class="sr-only">会员卡号</label>
        <input type="email" id="inputCardId" class="form-control" placeholder="会员卡号" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <a href="/register" class="btn btn-lg btn-default">注册</a>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me">记住密码
            </label>
        </div>
        <%--<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>--%>
        <%--<p class="lead">--%>
            <a href="/memberHome" class="btn btn-lg btn-default">登陆</a>
        <%--</p>--%>
    </form>

</div> <!-- /container -->


<c:import url="_script.jsp" var="script"></c:import>
${script}
</body>
</html>
