<%--
  Created by IntelliJ IDEA.
  User: chendanni
  Date: 17/3/1
  Time: 下午3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="component/_head.jsp" var="head">
    <c:param name="title" value="注册成功"/>
</c:import>
${head}
<body>
<div class="container">

    <p>注册成功,您的会员卡号为:${cardId}</p>
    <a href="/memberLogin">去登陆</a>

</div> <!-- /container -->

<c:import url="component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>

