package com.example.project.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.BoardVO;

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

}
