package com.example.project.board.web;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class Point {
	
	private static int number = 0;

	void plusPoint(int point) throws Exception {
		this.number = this.number + point;
		int total = this.number + point;
		
		if (this.number != total) {
			throw new Exception("plus실패");
		}
	}
	
	void minusPoint(int point) throws Exception {
		this.number = this.number - point;
		int total = this.number - point;
		
		if (this.number != total) {
			throw new Exception("minus실패");
		}
	}
	
	@Test
	@DisplayName("어떤 테스트")
	void test() {
		
		int point = 1;
		
		assertAll( () -> assertNull(point, "실패"),
		() -> assertNotNull(point, "성공"));
		
		
	}

}
