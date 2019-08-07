package com.example.project.file_upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	
	private String fileName;
	private String fileUrl;
	private MultipartFile upload;
	private OutputStream out;
	private String realPath;
	private String uploadPath;
	
	public void setFileUpload(HttpServletRequest req) throws IOException {
		
		fileName = upload.hashCode() + upload.getOriginalFilename();
		fileUrl = req.getContextPath() + "/resources/upload/" + fileName;
		realPath = req.getSession().getServletContext().getRealPath("/resources/upload");
    	uploadPath = realPath + '/' + fileName;
		
    	byte[] bytes = upload.getBytes();
        
    	out = new FileOutputStream(new File(uploadPath));
        out.write(bytes);
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
