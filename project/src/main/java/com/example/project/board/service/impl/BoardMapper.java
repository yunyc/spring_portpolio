package com.example.project.board.service.impl;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.example.project.board.service.VO.BoardReplyVO;
import com.example.project.board.service.VO.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	void insertBoardList(BoardVO boardVO) throws Exception;
	
	void updateBoardList(BoardVO boardVO) throws Exception;
	
	void deleteBoardList(BoardVO boardVO) throws Exception;
	
	//답변
	List<BoardReplyVO> selectReplyList(BoardReplyVO replyVO) throws Exception;
	
	void insertReplyList(BoardReplyVO replyVO) throws Exception;
	
	void updateReplyList(BoardReplyVO replyVO) throws Exception;
	
	void deleteReplyList(BoardReplyVO replyVO) throws Exception;

}
