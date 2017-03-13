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
            <%--</div>--%>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>学员</th>
                        <c:forEach var="i" begin="1" end="${lessonNum}">
                            <th>课时${i}</th>
                        </c:forEach>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${attendances}" var="attendance">
                        <tr>
                            <td>${attendance.name}</td>
                            <c:forEach items="${attendance.ats}" var="at">
                                <c:if test="${at eq 0}">
                                    <td>
                                        <button class="btn btn-success">出席</button>
                                        <button class="btn btn-danger">缺席</button>
                                    </td>
                                </c:if>
                                <c:if test="${at eq 1}">
                                    <td><button disabled="disabled" class="btn btn-info">出席</button></td>
                                </c:if>
                                <c:if test="${at eq 2}">
                                    <td><button disabled="disabled" class="btn btn-danger">缺席</button></td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>


        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>