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
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>用户</th>
                    <th>课程</th>
                    <th>机构</th>
                    <th>完成度</th>
                    <th>最多可退</th>
                    <th>申请时间</th>
                    <th>退款</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>cdnn(1000001)</td>
                    <td>操作系统(10000007)</td>
                    <td>网易云</td>
                    <td>7/12</td>
                    <td>5000</td>
                    <td>2017-03-13 20:00</td>
                    <td><input type="number" /> <a class="btn btn-info">退款</a></td>
                </tr>
                <tr>
                    <td>cdnn(1000001)</td>
                    <td>操作系统(10000007)</td>
                    <td>J2ee</td>
                    <td>7/12</td>
                    <td>5000</td>
                    <td>2017-03-13 20:00</td>
                    <td><input type="number" disabled="disabled" value="4500"/></td>
                </tr>

                <c:forEach items="${attendances}" var="attendance">
                    <tr>
                        <td>${attendance.name}</td>
                        <c:forEach items="${attendance.ats}" var="at">
                            <c:if test="${at.state eq 0}">
                                <td>
                                    <div>
                                        <input type="hidden" class="lesson-id" name="lessonId" value="${at.lessonId}"/>
                                        <input type="hidden" class="card-id" name="cardId" value="${attendance.cardId}"/>
                                        <button class="btn btn-success attend-btn">出席</button>
                                    </div>
                                    <div>
                                        <input type="hidden" class="lesson-id" name="lessonId" value="${at.lessonId}"/>
                                        <input type="hidden" class="card-id" name="cardId" value="${attendance.cardId}"/>
                                        <button class="btn btn-danger absence-btn">缺席</button>
                                    </div>
                                </td>
                            </c:if>
                            <c:if test="${at.state eq 1}">
                                <td><button disabled="disabled" class="btn btn-info">出席</button></td>
                            </c:if>
                            <c:if test="${at.state eq 2}">
                                <td><button disabled="disabled" class="btn btn-danger">缺席</button></td>
                            </c:if>
                        </c:forEach>
                        <td>
                            <c:if test="${attendance.score ne 0}">
                                <input type="number" name="score" value="${attendance.score}" disabled="disabled"/>
                            </c:if>
                            <c:if test="${attendance.score eq 0}">
                                <div>
                                    <input type="hidden" class="class-id" value="${classId}"/>
                                    <input type="hidden" class="card-id" value="${attendance.cardId}"/>
                                    <input type="number" name="score"/>
                                    <button class="btn btn-info score-btn">确认</button>
                                </div>
                            </c:if>


                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <c:forEach items="${applications}" var="a">
                <c:if test="${a.state eq 0}">
                    <div class="panel panel-info">
                        <div class="panel-body">
                            <p><b class="text-info">[未审批]</b>${a.orgName}: ${a.name} | 开课时间: ${a.start_time}</p>
                            <a href="/manage_apply_handle_detail?id=${a.id}" class="btn btn-info">审批</a>
                        </div>
                    </div>
                </c:if>

                <c:if test="${a.state ne 0}">
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
