$(function() {
	// CSRF 토큰 값 설정
	var token = $("input[name='_csrf']").val();
    var header = "X-CSRF-TOKEN";
    window.count = 1;
    
    
    
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
	
	// POST, PATCH, DELETE용 버튼
	$(".post, .patch, .delete").click(function() {
		var method = $(this).attr("class");
		
		$("[name=_method]").val(method);
		$(this).parent("form").submit();
	});
	
	// 게시글 댓글
	
	$("#slide").click(function() {
    	$("#regist").slideToggle();
    });
	
	$("#post").add("#patch").click(function() {
		var id = $(this).attr("id");
		var boardId = $("#boardId").val();
		var replyId = $("#replyId").val();
		var new_content = $("#submit").val()
		var index = $(this).parent().index();
		var content = "";
		var userId = $("#userId").val();

		if (id == "patch") {
			content = $("#update_text").val();
		} else {
			content = $("#submit").val();
		}
		
		var obj = {
			"replyId": replyId,
			"replyContent": content,
			"boardId": boardId,
			"userId": userId
		};
		
		$.ajax({
			url: "/board/" + boardId + "/reply/" + replyId ,
			type: id,
			data: JSON.stringify(obj),
			contentType: "application/json",
			success: function(data) {
				
				if (id == "patch"){
					alert("수정되었습니다.");
					$(".reply:eq(index)").text(content);
					location.reload();
				
				} else if (id == "post") {
					$("#reply").append("<div class='reply' style='min-height: 200px;'>" + 
							"<p></p>" +
							"<p></p>" +
							"<button id='slide'>댓글 수정/삭제</button>");
					
					$("#reply").find("p:eq(0)").text(data.replyList);
					$("#reply").find("p:eq(1)").text(data.replyList);

				}
				
			},
			error: function(errorThrown) {
				alert(errorThrown.textStatus);
			}
			
		});
	});
	
    // 질문 5개 더보기 버튼
	$("#questLoad").click(function() {
		
		$.ajax({
			url: "/quest",
			type: "post",
			success: function(data) {
				$.each(data.questList, function(i, item) {
					
					if (i >= 5 * count && i < 5 * (count + 1)) {
						$("#questList").append("<div class='quest'><a href='#'>" +
								"<div class='title'><p>" + item.questTitle + "</p></div>" +
								"<div class='content'><p>" + item.questContent + "</p></div>" +
								"<div class='response'> <div class='response_list'><p>답변 0개" +
								"</p></div><div class='response_list'><p>추천" + 
								item.questGood + "개</p></div></div></a></div>");
					}
				});
				++count;
			},
			error: function(data, errorThrown) {
				alert(errorThrown);
				
			}
			
		});
	});	
	
    // 좋아요, 싫어요, 채택 버튼
	$("#good").add("#bad").add("#select").click(function() {
		var tagId = $(this).attr("id");
		
		if (tagId == "good") {
			++config.good;
			
		} else if (tagId == "bad") {
			++config.bad;
			
		} else if (tagId == "select") {
			config.state = "답변 완료";
			alert("채택되었습니다.");
			$("#select").text("채택됨");
			$("#select").css("background", "#000");
		}
		
		$.ajax({
			url: "/point/state",
			type: "patch",
			contentType: "application/json",
			data: JSON.stringify(config),
			success: function(data) {
				$("#good").find("span").text(config.good);
				$("#bad").find("span").text(config.bad);
			},
			error: function(errorThrown) {
				alert(errorThrown.statusText);
			},
			
		});

	});
	
});
