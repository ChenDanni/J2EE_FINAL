<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:import url="_head.jsp" var="head">
    <c:param name="title" value="登陆"/>
</c:import>
${head}
<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="inner cover">
                <p class="lead">
                    <a href="#" class="btn btn-lg btn-default">机构入口</a>
                </p>
                <p class="lead">
                    <a href="/memberLogin" class="btn btn-lg btn-default">学员入口</a>
                </p>
            </div>
        </div>

    </div>

</div>


<c:import url="_script.jsp" var="script"></c:import>
${script}
</body>
</html>
