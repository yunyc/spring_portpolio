$(function() {
	// CSRF 토큰 값 설정
	var token = $("input[name='_csrf']").val();
    var header = "X-CSRF-TOKEN";
    window.count = 1;
    
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    
    // 이메일 정보 전송
    $("#email").click(function() {
    	var obj = {"userEmail": $("input[name=userEmail]").val()};
    	
    	$.ajax({
    		type: "post",
    		url: "/find",
    		data: JSON.stringify(obj),
    		contentType: "application/json",
    		success: function(data) {
    			
    			if (data === "success") {
    				alert("메일이 전송되었습니다");
    			} else {
    				alert("이메일이 존재하지 않습니다");
    			}
    		},
    		error: function(errorThrown) {
    			alert(errorThrown.textStatus);
    		}
    	});
    });
    
    // 상품 구매하기
    $("#purchase").click(function() {
    	
    	// 로그인이 되어있을 때
    	if (config.userId !== "") {
    		
    		// 포인트가 부족 할 때
    		if(config.point > config.userPoint) {
    			alert("포인트가 부족합니다")
    			
    		// 포인트가 부족하지 않을 때
    		} else {
    			config.point *= -1;
    			
    			$.ajax({
            		url: "/product/purchase",
            		type: "post",
            		data: JSON.stringify(config),
            		contentType: "application/json",
            		success: function(data) {
            			alert("주문이 완료되었습니다.")
            		},
            		error: function(errorThrown) {
            			alert(errorThrown.textStatus);
            		}
            	});
    		}
    		
    	// 로그인이 되어있지 않을 때
    	} else {
    		alert("로그인 하세요");
    	}
    	
    	
    });
    // 새 창 띄우기
    $("#find").click(function() {
    
		window.open("/find", "정보 찾기",
			"width=400, height=300ar=no, resizable=yes" ); 
	});
	
	// POST, PATCH, DELETE용 버튼
	$(".post, .patch, .delete").click(function() {
		var method = $(this).attr("class");
		
		$("[name=_method]").val(method);
		$(this).parent("form").submit();
	});
	
	// 게시글 댓글 생성, 수정, 삭제
	$(".slide").click(function() {
		var idx = $(".slide").index(this);
    	$(".regist").eq(idx).slideToggle();
    });
	
	$("#post, #patch, #delete").click(function() {
		var id = $(this).attr("id");
		var idx = $(this).index(this);
		var obj = {
			"replyId": $(".replyId").eq(idx).val(),
			"replyContent": $(this).parent().find(".update_text").val(),
			"boardId": $("#boardId").val(),
			"userId": $("#userIdId").val()
		};
		
		$.ajax({
			url: "/board/" + obj.boardId + "/reply/" + obj.replyId ,
			type: id,
			data: JSON.stringify(obj),
			contentType: "application/json",
			success: function(data) {
				
				// 댓글 수정 일 떄
				if (id === "patch") {
					alert("수정되었습니다.");
					$(".reply").eq(idx).text(content);
					location.reload();
				
				// 댓글 생성
				} else if (id === "post") {
					$("#reply").append(`<div class='reply' style='min-height: 150px;'>  
											<p id='userId'>${data.replyList.replyTitle}</p>
											<p id='date'>${data.replyList.replyDate}</p>
											<p id='content'>${data.replyList.replyContent}</p>
											<button id='slide'>댓글 수정/삭제</button>
										</div>`);
				// 댓글 삭제 
				} else {
					alert("삭제되었습니다.");
					location.reload();
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
				$.each(data.questList, function(idx, item) {
					
					if (idx >= 5 * count && idx < 5 * (count + 1)) {
						$("#questList").append(`<div class='quest'>
													<a href='/quest/${item.questId}> 
														<div class='title'>
															<label> ${item.questTitle} </label>  
															<span style='float:right;'> ${item.questState}  </span>
														</div>
														<div class='content'>
															<p> ${item.questContent} </p>
														</div>
														<div class='response'> 
															<div class='response_list'>
																<p>답변 0개</p>
															</div>
															<div class='response_list'>
																<p>추천 ${item.questGood} 개</p>
															</div>
														</div>
													</a>
												</div>`);
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
