var HUGE = {
	checkLogin : function(){
		alert(111)
		var _ticket = $.cookie("HUGE_TICKET");
		if(! _ticket){
			return ;
		}
		//当dataType类型为jsonp时，jQuery就会自动在请求链接上增加一个callback的参数
		$.ajax({
			url : "http://sso.huge.com/user/query/" + _ticket,
			dataType : "jsonp",
			type : "POST",
			success : function(data){
				if(data.status == 200){
					alert(222)
					var _data = JSON.parse(data.data);	//jackson
					var html = _data.username + ",欢迎您的到来！<a href='/service/user/doLogout/'>[退出]</a> <a href='/user/account/'>[个人中心]</a>";
					$("#login").html(html);
					/*$(document).ready(function(){
						$("input[type=checkbox]").click(function(){
								var text = _data.username;
								alert("input进来了")
								$("input[name='username']").html(text);
						})
					})*/
				}
			},
			error : function(){
				alert('index error.');
			}
		});
	}
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	HUGE.checkLogin();
});
