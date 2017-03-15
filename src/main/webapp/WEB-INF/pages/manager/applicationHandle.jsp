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
    <c:param name="title" value="申请信息处理"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/manager/managerSidebar.jsp" var="sidebar">
    <c:param name="current" value="apply-handle"/>
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
                    <li><a href="#">已审批</a></li>
                    <li><a href="#">未审批</a></li>
                </ul>
            </div>

            <hr>

            <c:forEach items="${applications}" var="a">
                <c:if test="${a.state eq 0}">
                    <div class="panel panel-info">
                        <div class="panel-body">
                            <p><b class="text-info">[未审批]</b>${a.orgName}: ${a.name} | 开课时间: ${a.start_time}</p>
                            <a href="/manage_apply_handle_detail?id=${a.id}" class="btn btn-info">审批</a>
                        </div>
                    </div>
                </c:if>

                <c:if test="${a.state ne 0 && a.state ne -1}">
                    <div class="panel panel-info">
                        <div class="panel-body">
                            <p><b class="text-success">[已审批]</b>${a.orgName}: ${a.name} | 开课时间: ${a.start_time}</p>
                            <a href="/manage_apply_handle_detail?id=${a.id}" class="btn btn-default">查看详情</a>
                        </div>
                    </div>
                </c:if>

            </c:forEach>

        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>