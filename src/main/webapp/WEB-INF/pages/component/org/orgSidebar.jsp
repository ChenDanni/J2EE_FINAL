<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li id="all-courses"><a href="/org_courses">所有课程</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="class-apply"><a href="/org_class_apply">开班申请</a></li>
        <li id="applying"><a href="/org_applying">申请信息</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="learn-record"><a href="/org_learn_record">学习登记</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="org-account"><a href="/org_account">机构账户</a></li>
        <li id="org-statistics"><a href="/org_statistics">机构统计信息</a></li>
    </ul>
    <input id="sidebar-current" type="hidden" value="${param.current}">
</div>

