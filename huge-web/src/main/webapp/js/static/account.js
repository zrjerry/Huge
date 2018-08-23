$("#pills").click(function(){
	alert(111111)
		var $panel= '<div class="card mb-3" id="sele">'+
        '<h5 class="card-header">订单号:45215322545</h5>'+
        '<div class="card-body">'+
         '<h5 class="card-title">浦东长城东站 - 杭州东站</h5>'+ 
          '<p class="card-text">上海 - 杭州</p>'+
          '<p class="card-text">8-3    当日</p>'+
          '<p class="card-text">06:29   08:59</p>'+
          '<a href="#" class="btn btn-primary disabled">退票</a>'+
        '</div>';
	        $("#v-pills-order").children().remove();
	        for(var i=0;i<5;i++){
	        	 $("#v-pills-order").append($panel)
	        }
	       
	$.ajax({
		url:"/cart/list",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		type : "POST",
		dataType : "json",
		success:function(Result){
			
			$(".card mb-3").nextAll().remove();
		}
	})
})