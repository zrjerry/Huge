$(function(){

	alert($("input:radio:checked").val())
	ear()
})
var startDate
	$("#pag a").click(function(){
		alert($(this).html());
		startDate=$(this).html()
	})
$("#suc").click(function(){
	var time=$("input:radio:checked").val()
	alert(122121)
	if(time==("morning")){
		var startTime="00:00";
		var endTime="12:00";
	}
	if(time=="noon"){
		var startTime="12:00";
		var endTime="14:00";
	}
	if(time=="afternoon"){
		var startTime="14:00";
		var endTime="18:00";
	}
	if(time=="evening"){
		var startTime="18:00";
		var endTime="6:00";
	}
	alert(startTime)
	alert(startDate)
	window.location.href = "http://www.huge.com/user/searchBus?startDate=" + startDate + "&startTime=" + startTime+ "&endTime="+endTime; 
	return false;
})
	

