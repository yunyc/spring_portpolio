package com.example.project.file_upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


/**
 * @Class Name : FileVO.java
 * @Description : FileVO Class
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

public class FileVO {
	
	/** 파일 이름 */
	private String fileName;
	
	/** 파일 URL */
	private String fileUrl;
	
	/** 전송 받은 파일 정보 */
	private MultipartFile upload;
	
	/** 파일 outputStream  */
	private OutputStream out;
	
	/** 절대 경로 */
	private String realPath;
	
	/** 파일 업로드 경로 */
	private String uploadPath;
	
	/**
	 * 파일 업로드 경로 설정
	 * @param req - 요청 정보 HttpServletRequest
	 * @return void
	 * @exception Exception
	 */
	public void setFileUpload(HttpServletRequest req) throws IOException {
		
		fileName = upload.hashCode() + upload.getOriginalFilename();
		fileUrl = req.getContextPath() + "/resources/upload/" + fileName;
		realPath = req.getSession().getServletContext().getRealPath("/resources/upload");
    	uploadPath = realPath + File.separator + fileName;
		
    	byte[] bytes = upload.getBytes();
        
    	out = new FileOutputStream(new File(uploadPath));
        out.write(bytes);
	}
	

	public String getUploadPath() {
		return uploadPath;
	}


	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	
	
	

}
