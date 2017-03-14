<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/12
  Time: 下午8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="学习登记"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="learn-record"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h5 class="page-header">学习详情登记</h5>

            <%--<div class="panel panel-default">--%>
            <div class="course-detail-card">
                <img src="assets/images/black.jpeg" alt="...">
                <div class="course-card-info">
                    <h4>${name}</h4>
                    <p>选课人数: ${totalMember} 人</p>
                    <p>价格: ${price}</p>
                    <p>上课时间: ${learn_time}</p>
                    <p>开课日期: ${start_time}</p>
                    </p>
                </div>
            </div>
            <hr>

            <div>

                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">会员登记</a></li>
                    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">非会员登记</a></li>
                    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">新增非会员</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>学员</th>
                                    <c:forEach var="i" begin="1" end="${lessonNum}">
                                        <th>课时${i}</th>
                                    </c:forEach>
                                    <th>成绩</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${attendances}" var="attendance">
                                    <c:if test="${attendance.state ne 4}">
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
                                    </c:if>


                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="profile">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>学员</th>
                                    <c:forEach var="i" begin="1" end="${lessonNum}">
                                        <th>课时${i}</th>
                                    </c:forEach>
                                    <th>成绩</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${attendances}" var="attendance">
                                    <c:if test="${attendance.state eq 4}">
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
                                    </c:if>


                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="messages">
                        <form class="form-signin col-md-4" action="/user/book/${classId}" method="post">
                            <h2 class="form-signin-heading">增加非会员</h2>
                            <label for="inputUsername" class="sr-only">用户名</label>
                            <input type="text" id="inputUsername" class="form-control" name="name" placeholder="用户名" required autofocus>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
                        </form>
                    </div>
                </div>

            </div>

        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
<script src="../../assets/js/recordDetail.js"></script>
</body>
</html>