<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${cssres }/common/base.css" />
	<link rel="stylesheet" href="${cssres }/login/login.css" />
	<title>人事管理系统</title>
</head>
<body>
	<div id="container">
		<form id="login_form" action="${ctx }/pymanager/login/validation.html" target="${ctx }/pymanager/index.html">
			<div id="bd">
				<div class="login1">
					<div class="login-top"><h1 class="logo"></h1></div>
					<div class="login-input">
						<p class="user ue-clear">
							<label>用户名</label>
							<input type="text" name="username"/>
						</p>
						<p class="password ue-clear">
							<label>密&nbsp;&nbsp;&nbsp;码</label>
							<input type="password" name="pwd"/>
						</p>
						<p class="yzm ue-clear">
							<label>验证码</label>
							<input type="text" name="val_code"/>
							<img src="${ctx }/pymanager/login/getValidCode.html?_=${r_key}" style="position:absolute;right:176px;" id="yzm_code"/>
						</p>
					</div>
					<div class="login-btn ue-clear">
						<a href="javascript:void(0);" class="btn" id="login_btn">登录</a>
						<div class="remember ue-clear">
							<input type="checkbox" id="remember" />
							<em></em>
							<label for="remember">记住密码</label>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
    <div id="ft">CopyRight&nbsp;2016&nbsp;&nbsp;版权所有&nbsp;&nbsp;广东水利电力职业技术学院毕业设计&nbsp;&nbsp;作者：叶明珠</div>
</body>
<script type="text/javascript" src="${jsres }/jquery/jquery.js"></script>
<script type="text/javascript" src="${jsres }/common/common.js"></script>
<jsp:include page="../tools/tip.jsp" ></jsp:include>
<script type="text/javascript">
var height = $(window).height();
$("#container").height(height);
$("#bd").css("padding-top",height/2 - $("#bd").height()/2);

$(window).resize(function(){
	var height = $(window).height();
	$("#bd").css("padding-top",$(window).height()/2 - $("#bd").height()/2);
	$("#container").height(height);
	
});

$('#remember').focus(function(){
   $(this).blur();
});

$('#remember').click(function(e) {
	checkRemember($(this));
});

function checkRemember($this){
	if(!-[1,]){
		 if($this.prop("checked")){
			$this.parent().addClass('checked');
		}else{
			$this.parent().removeClass('checked');
		}
	}
}
$(function(){
	$("#login_btn").click(function(){
		var $fm = $("#login_form");
		var act = $fm.attr("action");
		if(typeof act != "undefined" && act != ""){
			$.ajax({
				url:act,
				type:"post",
				data:$fm.serialize(),
				dataType:"json",
				success:function(data){
					if(data.retCode){
						var target = $fm.attr("target");
						if(typeof target != "undefined" && target != ''){
							window.location.href = target;
						}
					}else{
						$tip(data.retMsg,"请重新输入",{value:"确定",click:function(){$("#yzm_code").click();}});
					}
				},
				error:function(data){
					if(typeof data != "undefined" && typeof data.retCode != "undefined"){
						$tip(data.retMsg,"",{value:"确定"});
					}else{
						$tip("账号或者密码错误","请重新输入",{value:"确定",click:function(){$("#yzm_code").click();}});
					}
				}
			});
		}else{
			$tip("账号或者密码错误","请重新输入",{value:"确定",click:function(){$("#yzm_code").click();}});
		}
	});
	$("#yzm_code").click(function(){
		var ts = $(this);
		ts.attr("src",ts.attr("src").split("=")[0] + "=" + Math.random());
	});
});
</script>
</html>

