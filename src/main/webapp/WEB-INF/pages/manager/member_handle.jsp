<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/13
  Time: 下午8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="退课结算"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/manager/managerSidebar.jsp" var="sidebar">
    <c:param name="current" value="member-account"/>
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
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    所有申请 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">所有申请</a></li>
                    <li><a href="#">已审批</a></li>
                    <li><a href="#">未审批</a></li>
                </ul>
            </div>

            <hr>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>用户</th>
                    <th>课程</th>
                    <th>机构</th>
                    <th>完成度</th>
                    <th>课程总价</th>
                    <th>申请时间</th>
                    <th>退款</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${logs}" var="log">
                <tr>
                    <td>${log.username}(${log.cardId})</td>
                    <td>${log.className}(${log.classId})</td>
                    <td>${log.orgName}</td>
                    <td>${log.finish}/${log.total}</td>
                    <td>${log.price}</td>
                    <td>${log.time}</td>
                    <c:if test="${log.state eq 1}">
                    <td><input type="number" disabled="disabled" value="${log.money_back}"/>
                    </c:if>
                    <c:if test="${log.state eq 0}">
                    <td>
                        <input type="number"/>
                        <button class="btn btn-info money-back-btn">退款</button>
                        <input type="hidden" value="${log.cardId}"/>
                        <input type="hidden" value="${log.classId}"/>
                    </td>
                    </c:if>

                </tr>
                </c:forEach>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
<script src="../../assets/js/member_handle.js"></script>
</body>
</html>
