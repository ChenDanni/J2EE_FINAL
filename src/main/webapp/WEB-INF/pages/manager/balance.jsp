<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/13
  Time: 下午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="平台财务"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/manager/managerSidebar.jsp" var="sidebar">
    <c:param name="current" value="platform-account"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div>
                <p>会员充值: ${recharge}</p>
                <p>退课结算: ${mh}</p>
                <p>机构结算: ${oh}</p>
                <p>平台余额: ${balance}</p>
            </div>

            <hr>
            <h5 class="page-header">收支记录</h5>
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">会员充值</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">退课结算</a></li>
                <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">平台结算</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>会员卡号</th>
                                <th>金额</th>
                                <th>平台充值总额</th>
                                <th>时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ops}" var="op">
                                <tr>
                                    <td>${op.cardId}</td>
                                    <td>${op.money}</td>
                                    <td>${op.recharge}</td>
                                    <td>${op.time}</td>
                                </tr>
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
                                <th>会员卡号</th>
                                <th>课程号</th>
                                <th>金额</th>
                                <th>退课结算总额</th>
                                <th>时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${mhs}" var="op">
                                <tr>
                                    <td>${op.cardId}</td>
                                    <td>${op.classId}</td>
                                    <td>${op.money}</td>
                                    <td>${op.memberhandle}</td>
                                    <td>${op.time}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="messages">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>机构号</th>
                                <th>课程号</th>
                                <th>金额</th>
                                <th>机构结算总额</th>
                                <th>时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ohs}" var="op">
                                <tr>
                                    <td>${op.orgId}</td>
                                    <td>${op.classId}</td>
                                    <td>${op.money}</td>
                                    <td>${op.orghandle}</td>
                                    <td>${op.time}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>



        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>