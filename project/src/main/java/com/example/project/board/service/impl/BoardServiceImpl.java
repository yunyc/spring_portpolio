package com.example.project.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.board.service.BoardService;
import com.example.project.board.service.VO.ReplyVO;
import com.example.project.board.service.VO.BoardVO;

/**
 * @Class Name : BoardServiceImpl.java
 * @Description : BoardServiceImpl Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019.09.02               버그 수정
 *
 * @author yunyc
 * @since 2019. 07.01
 * @version 1.0
 * @see
 *
 */

@Service
public class BoardServiceImpl implements BoardService {
	
	@Resource
	private BoardMapper boardMapper;
	
	/**
	 * 문의사항 정보 조회
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @return 문의사항 정보 조회 결과
	 * @exception Exception
	 */
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		return boardMapper.selectBoardList(boardVO);
	}
	
	/**
	 * 문의사항 정보 생성
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void insertBoardList(BoardVO boardVO) throws Exception {
		boardMapper.insertBoardList(boardVO);
		
	}
	
	/**
	 * 문의사항 정보 수정
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void updateBoardList(BoardVO boardVO) throws Exception {
		boardMapper.updateBoardList(boardVO);
		
	}
	
	/**
	 * 문의사항 정보 삭제
	 * @param map - 문의사항 정보가 담긴 BoardVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void deleteBoardList(BoardVO boardVO) throws Exception {
		boardMapper.deleteBoardList(boardVO);
		
	}
	
	/**
	 * 답변 정보 조회
	 * @param replyVO - 답변 정보가 담긴 ReplyVO
	 * @return 답변 정보 조회 결과
	 * @exception Exception
	 */
	@Override
	public List<ReplyVO> selectReplyList(ReplyVO replyVO) throws Exception {
		return boardMapper.selectReplyList(replyVO);
	}
	
	/**
	 * 답변 정보 생성
	 * @param map - 답변 정보가 담긴 HashMap
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void insertReplyList(HashMap<String, Object> map) throws Exception {
		boardMapper.insertReplyList(map);
		
	}
	
	/**
	 * 답변 정보 수정
	 * @param map - 답변 정보가 담긴 HashMap
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void updateReplyList(HashMap<String, Object> map) throws Exception {
		boardMapper.updateReplyList(map);
		
	}

	/**
	 * 답변 정보 삭제
	 * @param replyVO - 답변 정보가 담긴 ReplyVO
	 * @return void
	 * @exception Exception
	 */
	@Override
	public void deleteReplyList(ReplyVO replyVO) throws Exception {
		boardMapper.deleteReplyList(replyVO);
		
	}
	
	/**
	 * 문의사항 개수 조회
	 * @return 문의사항 개수 조회 결과
	 * @exception Exception
	 */
	@Override
	public HashMap<String, Object> countBoardList() throws Exception {
		return boardMapper.countBoardList();
	}


}
