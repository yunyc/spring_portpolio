package com.example.project.board.service;

import java.util.HashMap;
import java.util.List;

import com.example.project.board.service.VO.ReplyVO;
import com.example.project.board.service.VO.BoardVO;
import com.example.project.paging.PagingVO;
import com.example.project.board.service.VO.ReplyVO;

/**
 * @Class Name : BoardService.java
 * @Description : BoardService interface
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

public interface BoardService {
	
	/**
	 * 문의사항 정보 조회
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @return 문의사항 정보 조회 결과
	 * @exception Exception
	 */
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	/**
	 * 문의사항 정보 생성
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @return void
	 * @exception Exception
	 */
	void insertBoardList(BoardVO boardVO) throws Exception;
	
	/**
	 * 문의사항 정보 수정
	 * @param boardVO - 문의사항 정보가 담긴 BoardVO
	 * @return void
	 * @exception Exception
	 */
	void updateBoardList(BoardVO boardVO) throws Exception;
	
	/**
	 * 문의사항 정보 삭제
	 * @param map - 문의사항 정보가 담긴 BoardVO
	 * @return void
	 * @exception Exception
	 */
	void deleteBoardList(BoardVO boardVO) throws Exception;
	
	/**
	 * 답변 정보 조회
	 * @param replyVO - 답변 정보가 담긴 ReplyVO
	 * @return 답변 정보 조회 결과
	 * @exception Exception
	 */
	List<ReplyVO> selectReplyList(ReplyVO replyVO) throws Exception;
	
	/**
	 * 답변 정보 생성
	 * @param map - 답변 정보가 담긴 HashMap
	 * @return void
	 * @exception Exception
	 */
	void insertReplyList(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 답변 정보 수정
	 * @param map - 답변 정보가 담긴 HashMap
	 * @return void
	 * @exception Exception
	 */
	void updateReplyList(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 답변 정보 삭제
	 * @param replyVO - 답변 정보가 담긴 ReplyVO
	 * @return void
	 * @exception Exception
	 */
	void deleteReplyList(ReplyVO replyVO) throws Exception;
	
	/**
	 * 문의사항 개수 조회
	 * @return 문의사항 개수 조회 결과
	 * @exception Exception
	 */
	HashMap<String, Object> countBoardList() throws Exception;

}
