<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>pythip后台管理系统</title>
<link href="${mres}/css/style.css?r_key=${r_key}" rel="stylesheet" type="text/css" />
<script src="${res }/ligerui/jquery/jquery1.11.1.js?r_key=${r_key}"></script>
<script>
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 
</head>
<body style="background:#edf6fa;">
	<div class="place">
    <span>信息：</span>
    <ul class="placeul">
    <li><a href="javascript:history.back()">返回</a></li>
    <li><a href="javascript:void()">404错误提示</a></li>
    </ul>
    </div>
    
    <div class="error">
    
    <h2>非常遗憾，您访问的页面不存在！</h2>
    <p>看到这个提示，就自认倒霉吧!</p>
    <div class="reindex"><a href="javascript:history.back()" target="_parent">返回</a></div>
    
    </div>


</body>
</html>