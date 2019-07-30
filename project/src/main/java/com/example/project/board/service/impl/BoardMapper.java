package com.example.project.board.service.impl;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.example.project.board.service.VO.ReplyVO;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.board.service.VO.PagingVO;
import com.example.project.board.service.VO.ReplyVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	void insertBoardList(BoardVO boardVO) throws Exception;
	
	void updateBoardList(BoardVO boardVO) throws Exception;
	
	void deleteBoardList(BoardVO boardVO) throws Exception;
	
	//답변
	List<ReplyVO> selectReplyList(ReplyVO replyVO) throws Exception;
	
	void insertReplyList(ReplyVO replyVO) throws Exception;
	
	void updateReplyList(ReplyVO replyVO) throws Exception;
	
	void deleteReplyList(ReplyVO replyVO) throws Exception;
	
	// 카운트
	HashMap<String, Object> countBoardList() throws Exception;

}
