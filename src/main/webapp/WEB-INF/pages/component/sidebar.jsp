<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li id="hot-courses"><a href="/memberHome">热门课程</a></li>
        <li id="new-courses"><a href="#">最新上线</a></li>
        <li id="all-courses"><a href="/allCourses">所有课程</a></li>
        <li id="all-orgs"><a href="/allOrgs">所有机构</a></li>
    </ul>
    <c:if test="${!empty sessionScope.get('cardId')}">
        <ul class="nav nav-sidebar">
            <li id="courses-stu"><a href="/learning">正在学习的课程</a></li>
            <li id="courses-book"><a href="/booking">预定中的课程</a></li>
            <li id="courses-fin"><a href="/finishing">已完成的课程</a></li>
            <li id="courses-quit"><a href="/quitting">退课申请</a></li>
        </ul>
        <ul class="nav nav-sidebar">
            <li id="card-manage"><a href="/card">会员卡管理</a></li>
            <li id="per-statistics"><a href="/cardStatistic">个人统计信息</a></li>
        </ul>
    </c:if>

    <input id="sidebar-current" type="hidden" value="${param.current}">
</div>

