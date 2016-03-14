//js for /admin/main.jsp

//ajax get new sOrders num
$.get("/dellERP/sOrder/getCount.do?status=new order", function(count)
										{
											$("#newOrderCount").text(count);
										}
				                        });