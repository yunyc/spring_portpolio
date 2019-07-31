// GET용 메서드
function fn_getSubmit() {
	$(".button").parent("form").attr("method", "get");
	$(".button").parent("form").submit();
}

// POST, PATCH, DELETE용 메서드
function fn_submit(method) {
	$("[name=_method]").val(method);
	$(".button").parent("form").submit();
}

$(document).ready(function() {
	$("button").click(function() {
		alert(1);
		$("[name=_method]").val("post");
		$("#dd").submit();
	});
});
