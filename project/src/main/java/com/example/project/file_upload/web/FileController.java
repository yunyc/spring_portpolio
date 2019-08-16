package com.example.project.file_upload.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.file_upload.FileVO;

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

@Controller
public class FileController {
	
	/**
	 * Ajax로 CKEditor 파일 전송 정보를 받음
	 * @param upload - 전송 받은 파일 정보 MultipartFile
	 * @param req - 요청 정보 HttpServletRequest
	 * @param fileVO - 파일 처리 관련 FileVO
	 * @return map
	 * @exception Exception
	 */
	@ResponseBody
	@PostMapping(value = "/file")
	public HashMap<String, Object> file(@RequestParam MultipartFile upload,
			HttpServletRequest req, FileVO fileVO) throws IOException {
		
        HashMap<String, Object> map = new HashMap<String, Object>();
 
        fileVO.setUpload(upload);
        fileVO.setFileUpload(req);
   
        map.put("fileName", fileVO.getFileName());
        map.put("uploaded", 1);
        map.put("url", fileVO.getFileUrl());
        
        return map;
	}
}
