<%--
  Created by IntelliJ IDEA.
  User: cdn
  Date: 17/3/8
  Time: 下午4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../component/_head.jsp" var="head">
    <c:param name="title" value="机构课程"/>
</c:import>
<c:import url="../component/nav.jsp" var="nav"></c:import>
<c:import url="../component/org/orgSidebar.jsp" var="sidebar">
    <c:param name="current" value="all-courses"/>
</c:import>
<c:import url="../component/courseCardDetail.jsp" var="courseCardDetail"></c:import>
<c:import url="../component/siftButtons.jsp" var="shiftButtons"></c:import>
${head}

<body>

${nav}
<div class="container-fluid">
    <div class="row">
        ${sidebar}

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            ${shiftButtons}
            <div class="row">
                ${courseCardDetail}
                ${courseCardDetail}
            </div>
        </div>

    </div>
</div>


<c:import url="../component/_script.jsp" var="script"></c:import>
${script}
</body>
</html>
