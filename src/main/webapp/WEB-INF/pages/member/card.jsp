<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/7
  Time: 下午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="会员卡管理"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/sidebar.jsp" var="sidebar">
    <c:param name="current" value="card-manage"/>
</c:import>
<c:import url="../component/orgCard.jsp" var="orgCard"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="../../assets/images/black.jpeg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>会员名 <a href="/cardSetting">修改信息</a></h4>
                </div>
                <div class="col-xs-6 col-sm-3">

                    <span class="text-muted">等级: Lv.4 <a href="#">关闭会员</a></span>
                    <p>账户余额: 10000 <a href="/recharge">充值</a></p>

                </div>
            </div>

            <h5 class="page-header">消费记录</h5>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>操作</th>
                        <th>金额</th>
                        <th>余额</th>
                        <th>日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>预定课程一</td>
                        <td>1000</td>
                        <td>10000</td>
                        <td>2017-03-01</td>
                    </tr>
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