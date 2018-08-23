$("#exchange").click(function (){
	var temp = $("#start").val();
	$("#start").val($("#end").val());
	$("#end").val(temp);
});