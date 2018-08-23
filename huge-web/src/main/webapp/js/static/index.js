$(function(){
	
})
$("#pri").click(function(){
	var startCity=$("#start").val();
	var endCity=$("#end").val();
	var startDate=$("#data").val();
	alert(12222)
		window.location.href = "http://www.huge.com//user/searchBus?startCity=" + startCity + "&endCity=" + endCity+ "&startDate=" +startDate; 
		return false;
	})