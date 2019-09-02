package com.example.project.user.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.project.user.service.UserVO;

/**
 * @Class Name : UserMapper.java
 * @Description : UserMapper interface
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

@Mapper
public interface UserMapper {
	
	/**
	 * 사용자 조회
	 * @param map - 사용자 옵션 HashMap
	 * @return "List<UserVO>"
	 * @exception Exception
	 */
	List<UserVO> selectUserList(HashMap<String, Object> map);
	
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

}
