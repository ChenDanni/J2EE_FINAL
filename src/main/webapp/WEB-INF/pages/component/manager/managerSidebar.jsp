<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li id="apply-handle"><a href="/manage_apply_handle">申请处理</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="member-account"><a href="/memberHandle">退课结算</a></li>
        <li id="org-account"><a href="/orgHandle">机构结算</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="org-analysis"><a href="/org_recruits">机构招生情况</a></li>
        <li id="member-study"><a href="/learnAnalysis">学员学习</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="platform-account"><a href="/manager_balance">账户收支明细</a></li>
        <li id="account-analysis"><a href="/manager_account_analysis">平台财务统计</a></li>
    </ul>
    <input id="sidebar-current" type="hidden" value="${param.current}">
</div>

