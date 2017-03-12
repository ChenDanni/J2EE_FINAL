<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Training College</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${(!empty sessionScope.get('cardId')) || (!empty sessionScope.get('orgId'))}">
                    <li><a href="#">${sessionScope.get('name')}</a></li>
                </c:if>
                <c:if test="${(empty sessionScope.get('cardId'))&&(empty sessionScope.get('orgId'))}">
                    <li><a href="/memberLogin">登陆</a></li>
                    <li><a href="/register">注册</a></li>
                </c:if>
                <li><a href="#">关于</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="搜索感兴趣的内容">
            </form>
        </div>
    </div>
</nav>
