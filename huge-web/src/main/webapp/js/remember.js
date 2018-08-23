/*$(function() {
	// username 回填到input框
	document.returnUsername();
});

var document = {
	returnUsername : function() {
		alert("进入了回填")
		var _ticket = $.cookie("HUGE_TICKET");
		debugger;
		if ($("#ck").attr("checked") == true) {
			alert("input进来了")
			$("input[name='username']").val(_ticket);
		}
	}
}
*/

$(function(){
	var _ticket = $.cookie("HUGE_TICKET");
	if(! _ticket){
		return ;
	}
	alert($("#ck").attr("checked"))
	if ($("#ck").attr("checked") == "checked") {
		$("input[name='username']").val(_ticket);
	}
});