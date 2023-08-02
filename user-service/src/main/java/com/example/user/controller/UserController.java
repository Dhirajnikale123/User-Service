package com.example.user.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.user.dto.FinancialInstitutionDto;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	public String createFile(@RequestBody FinancialInstitutionDto fiDto){
		String result = userService.createFile(fiDto);
		return result;
	}

	@DeleteMapping("/delete")
	public String deleteFile(@RequestParam String filename){
		String result = userService.deleteFile(filename);
		return result;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<File>> getAllFiles(@RequestParam String path){
		List<File> result = userService.getAllFiles(path);
		return new ResponseEntity<List<File>>(result, HttpStatus.OK);
	}
	
	 @PostMapping(value="/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<String> uploadFile(
	            @RequestParam("file") MultipartFile multipartFile){
	         
		 	String result = userService.uploadFile(multipartFile);
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        long size = multipartFile.getSize();

	        
	        return new ResponseEntity<>(fileName, HttpStatus.OK);
	    }
	
	

}
