<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li id="apply-handle"><a href="/manage_apply_handle">申请处理</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="member-account"><a href="/org_class_apply">会员结算</a></li>
        <li id="org-account"><a href="/org_applying">机构结算</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="recruit"><a href="/org_learn_record">机构招生情况</a></li>
        <li id="member-study"><a href="/org_learn_record">学员学习</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li id="platform-account"><a href="/org_account">平台财务</a></li>
    </ul>
    <input id="sidebar-current" type="hidden" value="${param.current}">
</div>

