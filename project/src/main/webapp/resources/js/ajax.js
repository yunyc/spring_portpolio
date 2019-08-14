$(function() {
	// CSRF 토큰 값 설정
	var token = $("input[name='_csrf']").val();
    var header = "X-CSRF-TOKEN";
    
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    
    // 질문 5개 더보기 버튼
	$("#questLoad").click(function() {
		var count = 1;
		
		$.ajax({
			url: "<c:url value='/quest' />",
			type: "post",
			success: function(data) {
				$.each(data.questList, function(i, item) {
					
					if (5 * count <= i < 5 * (count + 1)) {
						$("#questList").append("<div class='quest'><a href='#'>" +
								"<div class='title'><p>" + item.questTitle + "</p></div>" +
								"<div class='content'><p>" + item.questContent + "</p></div>" +
								"<div class='response'> <div class='response_list'><p>답변 0개" +
								"</p></div><div class='response_list'><p>추천" + 
								item.questGood + "개</p></div></div></a></div>");
						++count;
					}
				});
			},
			error: function(data, errorThrown) {
				alert(errorThrown);
				
			},
			beforeSend: function(xhr) {
				xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
			}
			
		});
	});	
	
    // 좋아요, 싫어요, 채택 버튼
	$(".good_bad").find("button").click(function() {
		var id = $(this).attr("id");
		
		if (id == "good") {
			++questVO.questGood;
			
		} else if (id == "bad") {
			++questVO.questBad;
			
		} else if (id == "select") {
			questVO.questState = "답변 완료";
			alert("채택되었습니다.");
			$("#select").text("채택됨");
			$("#select").css("background", "#000");
		}
		
		var best = {
			"questId": questVO.questId,
			"questGood": questVO.questGood,
			"questBad": questVO.questBad,
			"questState": questVO.questState
		};
		
		$.ajax({
			url: "/point/quest",
			type: "put",
			contentType: "application/json",
			data: JSON.stringify(best),
			success: function(data) {
				$("#good").find("span").text(best.questGood);
				$("#bad").find("span").text(best.questBad);
			},
			error: function(errorThrown) {
				alert(errorThrown.statusText);
			},
			
		});
		
		
		
	});
	
	
});
