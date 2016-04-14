var m = $("#msg").text();
if (m != null && m.trim() != "")
	alert(m);

$.get("/dellERP/components/getComponentsByTypeId?uuid=1", function(data)
{
	$('#showComponents').bootstrapTable({
		data : data,
		pagination : true,
		pageNum : 1,
		pageSize : 3

	});

});

function findComponents(id)
{

	$('#showComponents').bootstrapTable('destroy', null);
	$.get("/dellERP/components/getComponentsByTypeId?uuid=" + id,
			function(data)
			{
				$('#showComponents').bootstrapTable({
					data : data,
					pagination : true,
					pageNum : 1,
					pageSize : 3
				});

			});
}

function nameFormatter(value)
{
	return value.replace(/_/g, " ");
}

function imgFormatter(value, row)
{

	return '<img height="40px" weight="40px" src=" ' + row.imgPath + '"/>';
}

function buttonFormatter(value, row)
{
	var name = row.name;
	return '<button type="button" onclick=add(' + row.componentsTypeUuid + ','
			+ row.uuid + ',"' + name + '") class="btn btn-info">ADD</button>';
}

function add(componentsTypeUuid, uuid, name)
{
	name = name.replace(/_/g, " ");
	var cTUuid = "#" + componentsTypeUuid;
	var cTUuid2 = "#" + componentsTypeUuid + "para"
	$(cTUuid).text(name);
	$(cTUuid2).val(uuid);

}

function loginAjax()
{
	var username = $("#username").val();
	var pwd = $("#password").val();
	$.get("/dellERP/customer/customerLogin.do?userName=" + username + "&pwd="
			+ pwd, function(data)
	{
		var message = data.msg;
		if (message != null && message != "")
			alert(message);
		$("#customerUsername").text(data.customer.userName+",");
		

	});

}
