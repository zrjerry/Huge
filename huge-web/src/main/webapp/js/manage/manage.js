function correctbtn(obj){
	var id=$(obj).parent("td").parent("tr").children("td").eq(0).text();
	var startstation=$(obj).parent("td").parent("tr").children("td").eq(1).children("input").val();
	var endstation=$(obj).parent("td").parent("tr").children("td").eq(2).children("input").val();
	var leftTicket=$(obj).parent("td").parent("tr").children("td").eq(3).children("input").val();
	var price=$(obj).parent("td").parent("tr").children("td").eq(4).children("input").val();

	$.ajax({
		"type":"post",
		"url":"/updateTicket",
	    "data":{"id":id,"startstation":startstation,"endstation":endstation,"leftTicket":leftTicket,"price":price},
		"async":true,	
		"success":function(result){
		alert(result.status+""+result.msg) ;   
		}
		
	})
}

function cancelbtn(obj){

	$(obj).parent("td").parent("tr").remove();
}
function correctuserbtn(obj){
	
	alert("修改成功")
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	var flag=0;


$("#user_label").click(function(){
	$("#info_tbody").children().remove();
	$("#table_name").text("用户管理")
	$("#searchbox").attr("placeholder","用户搜索")
	$("#tablehead1").text("用户id")
	$("#tablehead2").text("姓名")
	$("#tablehead3").text("用户名")
	$("#tablehead4").text("性别")
	$("#tablehead5").text("身份证号")
	$("#tablehead6").text("用户操作")
	flag=1
	
	
})


$("#order_label").click(function(){
	$("#info_tbody").children().remove();
	$("#table_name").text("订单管理")
	$("#searchbox").attr("placeholder","订单搜索")
	$("#tablehead1").text("订单号")
	$("#tablehead2").text("车次id")
	$("#tablehead3").text("用户编号")
	$("#tablehead4").text("支付状态")
	$("#tablehead5").text("支付金额")
	$("#tablehead6").text("订单操作")
	flag=2

	
	
})

$("#ticket_label").click(function(){
	$("#info_tbody").children().remove();
	$("#table_name").text("余票管理")
	$("#searchbox").attr("placeholder","余票搜索")
	$("#tablehead1").text("车次编号")
	$("#tablehead2").text("始发站")
	$("#tablehead3").text("终点站")
	$("#tablehead4").text("余票")
	$("#tablehead5").text("价格")
	$("#tablehead6").text("票务操作")	
	flag=3
})
$("#searchbtn").click(function(){
	$("#info_tbody").children().remove();
	if($("#searchbox").val()==""){
		alert("请输入查找信息")
		return false;
	}	
    if(flag==1){
		var realname=$("#searchbox").val();
		alert(realname);
		$.ajax({
			"type":"post",
			"url":"user/find",
		    "data":{"realname":realname},
			"async":true,	
			"success":function(result){
				var userinfolist=eval(result);
		       for(i=0;i<userinfolist.length;i++){
                 var trs="<tr>"
                	 trs=trs+'<td>'+userinfolist[i].id+'</td>'
                	 trs=trs+'<td><input class="form-control" value="'+userinfolist[i].realname+'" type="text"></td>'
                	 trs=trs+'<td><input class="form-control" value="'+userinfolist[i].username+'" type="text"></td>'
                	 trs=trs+'<td><input class="form-control" value="'+userinfolist[i].gender+'" type="text"></td>'
                	 trs=trs+'<td><input class="form-control" value="'+userinfolist[i].identityId+'" type="text"></td>'
                    trs=trs+'<td><button  class="btn btn-mini btn-success" type="button" onclick="correctuserbtn(this)">修改</button></td><td><button  class="btn btn-mini btn-success" type="button" onclick="cancelbtn(this)">删除</button></td>'
                    trs=trs+"</tr>"
                    $("#info_tbody").append(trs)
		       }
               
			}
			
		})
		
	}
	
	if(flag==2){
	
		
	}
	if(flag==3){
		var city=$("#searchbox").val();
		alert(city);
		$.ajax({
			"type":"post",
			"url":"/bus",
		    "data":{"city":city},
			"async":true,	
			"success":function(result){
				var businfolist=eval(result);
				alert(result)
				
		       for(i=0;i<businfolist.length;i++){
                 var trs="<tr>"
                	 trs=trs+'<td>'+businfolist[i].id+'</td>'
                	 trs=trs+'<td><input class="form-control" value="'+businfolist[i].startStation+'" type="text"></td>'
                	 trs=trs+'<td><input class="form-control" value="'+businfolist[i].endStation+'" type="text"></td>'
                	 trs=trs+'<td><input class="form-control" value="'+businfolist[i].leftTicket+'" type="text"></td>'
                	 trs=trs+'<td><input class="form-control" value="'+businfolist[i].price+'" type="text"></td>'
                    trs=trs+'<td><button  class="btn btn-mini btn-success" type="button" onclick="correctbtn(this)">修改</button></td><td><button  class="btn btn-mini btn-success" type="button" onclick="cancelbtn(this)">删除</button></td>'
                    trs=trs+"</tr>"
                    $("#info_tbody").append(trs)
		       }
               
			}
			
		})
		
	}
})

});
