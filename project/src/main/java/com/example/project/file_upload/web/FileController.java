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

@Controller
public class FileController {
	
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