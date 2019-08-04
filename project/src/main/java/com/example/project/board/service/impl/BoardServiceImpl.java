package com.example.project.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.ReplyVO;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.paging.PagingVO;
import com.example.project.board.service.VO.ReplyVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Resource
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		return boardMapper.selectBoardList(boardVO);
	}

	@Override
	@Transactional
	public void insertBoardList(BoardVO boardVO) throws Exception {
		boardMapper.insertBoardList(boardVO);
		
	}

	@Override
	@Transactional
	public void updateBoardList(BoardVO boardVO) throws Exception {
		boardMapper.updateBoardList(boardVO);
		
	}

	@Override
	@Transactional
	public void deleteBoardList(BoardVO boardVO) throws Exception {
		boardMapper.deleteBoardList(boardVO);
		
	}

	@Override
	@Transactional
	public List<ReplyVO> selectReplyList(ReplyVO replyVO) throws Exception {
		return boardMapper.selectReplyList(replyVO);
	}

	@Override
	@Transactional
	public void insertReplyList(ReplyVO replyVO) throws Exception {
		boardMapper.insertReplyList(replyVO);
		
	}

	@Override
	@Transactional
	public void updateReplyList(ReplyVO replyVO) throws Exception {
		boardMapper.updateReplyList(replyVO);
		
	}

	@Override
	@Transactional
	public void deleteReplyList(ReplyVO replyVO) throws Exception {
		boardMapper.deleteReplyList(replyVO);
		
	}

	@Override
	public HashMap<String, Object> countBoardList() throws Exception {
		return boardMapper.countBoardList();
	}


}
