
$(function() {
	var usename = $("#inputname").val();
	$(this).click=checkname();
})
var formObj={
	"checkForm":function(){
		var flag=true;
		// 非空验证
		flag=this.checkNull("username", "用户名不能为空")&&flag;
		flag=this.checkNull("password", "密码不能为空")&&flag;
		flag=this.checkNull("password2", "密码不能为空")&&flag;
		flag=this.checkNull("email", "邮箱不能为空")&&flag;
		flag=this.checkNull("identity", "身份不能为空")&&flag;
		return flag;
	},
	"checkEmail":function(name,msg){
		//验证邮箱格式
		var email=$("#idea [name='"+name+"']").val();
		if(!$.trim(email)==""){
			var reg=/^\w+@\w+(\.\w+)+$/;
			if(!reg.test(email)){
				this.setMsg(name, msg);
				return false;
			}
		}
		return true;
	},
	"identity":function(name,msg){
		var identity = $("#inputidentity").val();
		if(!$.trim(identity)==""){
			alert(identity)
			var reg=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
			if(!reg.test(identity)){
					this.setMsg(name, msg);
					return false;
				}
			}
			return true;
	},
	"checkNull":function(name,msg){
		// 获取对应的input框的值
		var value=$("#idea [name='"+name+"']").val();
		// 清空之前的错误提示
		this.setMsg(name, "");
		// 判断是否为空
		if($.trim(value)==""){
		// 如果为空,提示错误信息
			this.setMsg(name, msg);
			return false;
		}
		return true;
	},
	"checkpsd":function(name,msg){
		alert(23333333)
		var psd1 = $("#inputPassword").val();
		var psd2=$("#idea [name='"+name+"']").val();
		if(!$.trim(psd1)==""&&!$.trim(psd2)==""){
			if(psd1!=psd2){
				// 密码不一致，提示错误
				this.setMsg(name, msg);
				return false;
			}
			}
			return true;
	},
	"setMsg":function(name,msg){
		$("#idea [name='"+name+"']").next().html(msg).css("color","red")
	},
	"setMs":function(name,msg){
		$("#idea [name='"+name+"']").next().html(msg).css("color","green")
	}
}
function checkname(){
	$("input[name='email']").blur(function(){
		// 清空之前的错误提示
		formObj.checkNull("email", "邮箱不能为空");
		formObj.checkEmail("email", "邮箱格式不正确");
	})
	$("input[name='password']").blur(function(){
		// 清空之前的错误提示
		formObj.checkNull("password", "密码不能为空");
	});
	$("input[name='realusename']").blur(function(){
		// 清空之前的错误提示
		formObj.checkNull("realusename", "真实姓名不能为空");
	});
	$("input[name='password2']").blur(function(){
		// 清空之前的错误提示
		formObj.checkNull("password2", "验证密码不能为空");
		formObj.checkpsd("password2", "两次密码输入不一致");
	});
	$("input[name='indetity']").blur(function(){
		// 清空之前的错误提示
		formObj.checkNull("indetity", "身份验证不能为空");
		formObj.identity("indetity", "身份验证格式出错");
	});
	$("input[name='usename']").blur(function(){
		var username = $("#inputname").val();
			formObj.checkNull("usename", "用户名不能为空");
			//ajax请求
			if(!$.trim(username)==""){
				$.ajax({
					url : "http://localhost:8092/user/check/"+username+"/1",
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					type : "GET",
					dataType : "jsonp",
					success : function(result) {
						if (result.data==false) {
							// 注册成功，去登录页
							formObj.setMs("usename", "恭喜你,可以注册")
						} else {
							formObj.setMs("usename", "用户名已存在")
						}
					}
				
				})
			}
	});
}

$("#register").click(function() {
	alert(23333)
	var Email = $("#inputEmail").val();
	var password= $("#inputPassword").val();
	var identityId = $("#inputidentity").val();
	var username = $("#inputname").val();
	var realname=$("input[name='realusename']").val();
	var gender=$('input[name="gender"]').val();
	alert(Email);
	$.ajax({
		url : "/user/doRegister",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			"username" : username,
			"password" : password,
			"identityId" : identityId,
			"Email" : Email,
			"realname":realname,
			"gender":gender
		},
		type : "POST",
		dataType : "json",
		success : function(Result) {
			var obj=eval(Result)
			if (obj.status == 200) {
				// 注册成功，去登录页
				window.location.href = "http://localhost:8091/user/login"
			} else {
				alert('注册失败，请重新注册！   ');
			}
		}
	})
	return false;
});
