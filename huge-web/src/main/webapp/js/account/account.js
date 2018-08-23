var userId;
var account = {
		
		checkLogin : function(){
			var _ticket = $.cookie("HUGE_TICKET");
			alert("11111111111")
			alert(_ticket)
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
						$("#v-pills-order-tab").click(function(){
							$.ajax({
								url:"http://localhost:8094/order/findAllOrder/",
								data:{
									"userId":userId,
								},
								dataType : "jsonp",
								type : "POST",
								success : function(list){
									var sum=list.data;
									alert(sum)
									for(var i=0;i<sum.length;i++){
										 $("#v-pills-order").children().remove()
										var $panel=
										    '<div class="card mb-3" id="sele">'+
									        '<h5 class="card-header">订单号:'+sum[i].orderId+'</h5>'+
									        '<div class="card-body">'+
									         '<h5 class="card-title">'+sum[i].startStation+'-'+sum[i].endStation+'</h5>'+ 
									          '<p class="card-text">'+sum[i].startCity+'-'+sum[i].endCity+'</p>'+
									          '<p class="card-text">'+sum[i].startDate+'</p>'+
									          '<p class="card-text">'+sum[i].startTime+'</p>'+
									          '<a href="#" class="btn btn-primary disabled">退票</a>'+
									        '</div>';
										 $("#v-pills-order").append($panel)
									}
								}
							});
						})	
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
	account.checkLogin();
	
});