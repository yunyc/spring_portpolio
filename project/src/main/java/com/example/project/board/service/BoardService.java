package com.example.project.board.service;

import java.util.HashMap;
import java.util.List;

import com.example.project.board.service.VO.BoardReplyVO;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.board.service.VO.PagingVO;

public interface BoardService {
	
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	void insertBoardList(BoardVO boardVO) throws Exception;
	
	void updateBoardList(BoardVO boardVO) throws Exception;
	
	void deleteBoardList(BoardVO boardVO) throws Exception;
	
	// 답변
	List<BoardReplyVO> selectReplyList(BoardReplyVO replyVO) throws Exception;
	
	void insertReplyList(BoardReplyVO replyVO) throws Exception;
	
	void updateReplyList(BoardReplyVO replyVO) throws Exception;
	
	void deleteReplyList(BoardReplyVO replyVO) throws Exception;
	
	// 카운트
	PagingVO countBoardList() throws Exception;

}
