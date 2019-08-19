package com.example.project.user.service;

import java.util.HashMap;
import java.util.List;

/**
 * @Class Name : QuestController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author yunyc
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

public interface UserService {
	
	/**
	 * 사용자 조회
	 * @param map - 사용자 옵션 HashMap
	 * @return "List<UserVO>"
	 * @exception Exception
	 */
	List<UserVO> selectUserList(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 사용자 등록
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @return "void"
	 * @exception Exception
	 */
	void insertUserList(UserVO userVO) throws Exception;
	
	/**
	 * 사용자 권한 추가
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @return "void"
	 * @exception Exception
	 */
	void insertAuthority(UserVO userVO) throws Exception;
	
	/**
	 * 사용자 권한 수정
	 * @param userVO - 사용자 정보가 담긴 UserVO
	 * @return "void"
	 * @exception Exception
	 */
	void updateAuthority(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 사용자 인증키 메일 보내기
	 * @param email - 사용자 이메일
	 * @param userId - 사용자 ID
	 * @param key - 인증키
	 * @return "void"
	 * @exception Exception
	 */
	void sendAuthKey(String email, String userId, int key);
	
	/**
	 * 사용자 정보 메일로 보내기
	 * @param email - 사용자 이메일
	 * @param userId - 사용자 ID
	 * @param userPassword - 사용자 비밀번호
	 * @return "void"
	 * @exception Exception
	 */
	void sendUserInfo(String email, String userId, String userPassword);

}
