package com.example.project.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.board.service.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	void insertBoardList(BoardVO boardVO) throws Exception;
	
	void updateBoardList(BoardVO boardVO) throws Exception;
	
	void deleteBoardList(BoardVO boardVO) throws Exception;

}
