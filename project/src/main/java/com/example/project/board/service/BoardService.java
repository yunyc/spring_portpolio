package com.example.project.board.service;

import java.util.List;

import com.example.project.board.service.VO.ReplyVO;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.board.service.VO.PagingVO;
import com.example.project.board.service.VO.ReplyVO;

public interface BoardService {
	
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	void insertBoardList(BoardVO boardVO) throws Exception;
	
	void updateBoardList(BoardVO boardVO) throws Exception;
	
	void deleteBoardList(BoardVO boardVO) throws Exception;
	
	// 댓글
	List<ReplyVO> selectReplyList(ReplyVO replyVO) throws Exception;
	
	void insertReplyList(ReplyVO replyVO) throws Exception;
	
	void updateReplyList(ReplyVO replyVO) throws Exception;
	
	void deleteReplyList(ReplyVO replyVO) throws Exception;
	
	// 카운트
	PagingVO countBoardList() throws Exception;

}
