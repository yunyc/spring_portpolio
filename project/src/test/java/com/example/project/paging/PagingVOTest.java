package com.example.project.paging;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PagingVOTest {
	
	private static int boardCount;
	private static int indexSize;
	private static int pageSize;
	private static int startIndex;
	private static int endIndex;
	private static int startPage = 1;
	private static int totalPage;
	private static int endPage = 1;
	private static int currentPage = 1;
	
	@BeforeAll
	static void init() {
		boardCount = 1;
		currentPage = 1;
		indexSize = 10;
		pageSize = 10;
	}
	
	@Test
	void testSetBoardCountInt() {
		
		if (boardCount % indexSize == 0) {
			totalPage = boardCount / indexSize;
		} else {
			totalPage = boardCount / indexSize + 1;
		}
		
		startPage = ((currentPage - 1) / pageSize) * pageSize + 1;
		endPage  = ((currentPage - 1) / pageSize) * pageSize + pageSize;
		
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		
		
	}
	
	@Test
	void testSetIndex() {
		startIndex = ((currentPage - 1) * indexSize);
		endIndex = (currentPage * indexSize) - 1;
		
		
	}
	
	@AfterAll
	static void assertInit() {
		
		assertAll(
				() -> assertEquals(12, totalPage),
				
				() -> assertEquals(1, startPage),
				() -> assertEquals(3, endPage),
				
				() -> assertEquals(0, startIndex),
				() -> assertEquals(5, endIndex)
				);
	}
	
}
