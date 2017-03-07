<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17/3/1
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="_head.jsp" var="head">
    <c:param name="title" value="首页"/>
</c:import>
<c:import url="nav.jsp" var="nav"></c:import>
<c:import url="component/memberSelect.jsp" var="select"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${select}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">课程列表</h1>

            <h5 class="page-header">地区</h5>
            <h5 class="page-header">类型</h5>
            <div class="row">
                <div class="col-sm-12 col-md-12">
                    <div class="thumbnail">
                        <img src="assets/images/black.jpeg" alt="..." style="max-height: 100px">
                        <div class="caption">
                            <h3>Thumbnail label</h3>
                            <p>...</p>
                            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Header</th>
                        <th>Header</th>
                        <th>Header</th>
                        <th>Header</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1,015</td>
                        <td>sodales</td>
                        <td>ligula</td>
                        <td>in</td>
                        <td>libero</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>


<c:import url="_script.jsp" var="script"></c:import>
${script}
</body>
</html>
