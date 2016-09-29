<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="${cssres }/common/jquery.dialog.css" />
<script type="text/javascript" src="${jsres }/jquery/plugin/core.js"></script>
<script type="text/javascript" src="${jsres }/jquery/plugin/jquery.dialog.js"></script>
<script>
function $dom(tag,obj){
	if(typeof obj != "undefined"){
		return $("<" + tag + "/>",obj);
	}else{
		return $("<" + tag + "/>");
	}
}
function $tip(tip1,tip2,conf,canc){
	var btns = [];
	if(typeof conf != "undefined"){
		var btn1 = $dom("input",{"class":"button long2 ok","type":"button","value":conf.value?conf.value:"确定"});
		btns.push(btn1);
	}
	if(typeof canc != "undefined"){
		var btn2 = $dom("input",{"class":"button long2 normal","type":"button","value":canc.value?canc.value:"取消"});
		btns.push(btn2);
	}
	var _dom =  $dom("div",{"class":"exitDialog"}).html(
					$dom("div",{"class":"dialog-content"}).append(
												 $dom("div",{"class":"ui-dialog-icon"})
										  ).append($dom("div",{"class":"ui-dialog-text"}).append(
													 $dom("p",{"class":"dialog-content"}).html(tip1)
											  ).append(
													 $dom("p",{"class":"tips"}).html(tip2)
											  ).append(
													 (function(){
														 var $btn = $dom("div",{"class":"buttons"});
														 for(var x=0;x<btns.length;x++){
															 $btn.append(btns[x]);
														 }
														return $btn;
													 }())
											 )
										  )
										);
	$(document.body).append(_dom);
	_dom.Dialog({
		title:'提示信息',
		autoOpen: false,
		width:400,
		height:200
	});
	for(var x = 0;x<btns.length;x++){
		btns[x].click(function(){
					_dom.Dialog("close");
					var dom_parent = _dom.parent().parent(); 
					var pp = dom_parent.prev();
					if(pp.css("display") == "none" && pp.css("position") == "fixed" &&
					(pp.css("z-index") == "9999" || pp.css("z-index") == 9999)){
						  pp.remove();
					}
					if(dom_parent.attr("class") == "ui-dialog-panel"){
						dom_parent.remove();
					}
		});
	}
	if(typeof conf != "undefined"){
		if(conf.click){
				btns[0].click(function(){
					conf.click(_dom,btns[0]);
				});
			}
	}
	if(typeof canc != "undefined"){
		if(canc.click){
				btns[1].click(function(){
					canc.click(_dom,btns[1]);
				});
		}
	}
	_dom.Dialog('open');
}
</script>