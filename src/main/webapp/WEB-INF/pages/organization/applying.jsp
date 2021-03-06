<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/8
  Time: 下午4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="申请信息"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="applying"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="btn-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    所有申请 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">所有申请</a></li>
                    <li><a href="#">申请中</a></li>
                    <li><a href="#">已通过</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">未通过</a></li>
                </ul>
            </div>

            <hr>

            <c:forEach items="${applications}" var="a">
                <div class="panel panel-info">
                    <div class="panel-body">
                        <p>
                        <c:if test="${a.state eq 0}">
                            <b class="text-info">[申请中]</b>${a.name}
                        </c:if>
                        <c:if test="${a.state eq 1 || a.state eq 3}">
                            <b class="text-success">[申请成功]</b>${a.name}
                        </c:if>
                        <c:if test="${a.state eq 2}">
                            <b class="text-danger">[申请失败]</b>${a.name}
                            <a href="/org_course_fix?id=${id}" class="btn btn-info">修改信息</a>
                        </c:if>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>