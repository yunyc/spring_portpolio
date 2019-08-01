
$(function() {
	// POST, PATCH, DELETE용 버튼
	$(".post, .patch, .delete").click(function() {
		var method = $(this).attr("class");
		
		$("[name=_method]").val(method);
		$(this).parent("form").submit();
	});
	
});
