$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	alert("已经登录")
	account.checkLogin();
	
	
});
var userId;
var account = {
		
		checkLogin : function(){
			var _ticket = $.cookie("HUGE_TICKET");
			alert("11111111111")
			if(! _ticket){
				return ;
			}
			$.ajax({
				url : "http://sso.huge.com/user/query/" + _ticket,
				async: false ,
				dataType : "jsonp",
				type : "POST",
				
				success : function(data){
					if(data.status == 200){
						var _data = JSON.parse(data.data);	// jackson
						alert("2222222222222")
						
						$("#account_userRealname").html(_data.realname);
						$("#account_userName").html(_data.username);
						$("#account_gender").html(_data.gender);
						$("#account_identityId").html(_data.identityId);
						userId=_data.id;
						alert(userId);
						alert(busId)
						
					}
					
				},
			error : function(){
				alert('index error.');
			}
			});
			
			
			

		}


}
function clickbtn(obj){
	var busId=$(obj).parent("td").parent("tr").children("td").eq(0).text();
	$.ajax({
		url:"http://localhost:8094/order/create",
		data:{
			"userId":userId,
			"status":1,
			"busId":busId
		},
		dataType:"jsonp",
		type:"POST",
		success:function(result){
			if(result.data!=null){
				 alert("恭喜你！购票成功")
				 window.location.href = "http://localhost:8091/user/account"
			}
		}
	});
}


