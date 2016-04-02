//js for /admin/main.jsp

//ajax get new sOrders num
$.get("/dellERP/sOrder/getCount.do?status=0", function(result)
	{
	  $("#newOrderCount").text(result.count);
	});

//ajax get new sOrders num
$.get("/dellERP/components/getInsufficientComponentCount.do?", function(result)
	{
	  $("#insufficientComponentCount").text(result.count);
	});