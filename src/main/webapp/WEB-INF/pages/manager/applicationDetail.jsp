<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/13
  Time: 下午1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="申请详情"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/manager/managerSidebar.jsp" var="sidebar">
    <c:param name="current" value="apply-handle"/>
</c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>${name}</h3>
                        <hr>
                        <p>价格: <span class="text-info">${price}</span></p>
                        <p>时间: <span class="text-info">${learn_time}</span></p>
                        <p>总人数: <span class="text-info">${memberNum}</span> 剩余名额: <span class="text-info">${leftMember}</span></p>
                        <p>来自: <span class="text-info">${orgName}</span></p>
                        <p>教师: <span class="text-info">${teacher}</span></p>
                        <p>开课时间: <span class="text-info">${start_time}</span></p>

                        <c:if test="${state eq 1 || state eq 3}">
                            <p class="bg-success">已审批通过</p>
                        </c:if>
                        <c:if test="${state eq 2}">
                            <p class="bg-danger">审批未通过</p>
                        </c:if>

                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>简介</h3>
                        <hr>
                        <p>${description}</p>
                    </div>
                </div>
                <c:if test="${state eq 0}">
                    <form action="/application_success" method="post">
                        <input type="hidden" name="id" value="${id}">
                        <button href="#" class="btn btn-success">审批通过</button>
                    </form>
                    <form action="/application_fail" method="post">
                        <input type="hidden" name="id" value="${id}">
                        <button href="#" class="btn btn-danger">审批不通过</button>
                    </form>
                </c:if>
            </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
