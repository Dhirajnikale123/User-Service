package com.example.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.user.entity.FinancialInstitution;
import com.example.user.service.UserService;
import com.example.user.utility.UserPDFreport;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
		String result = userService.uploadFile(multipartFile);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteFile(@PathVariable("id") Integer id) {
		String result = userService.deleteFile(id);
		return result;
	}

	@GetMapping("/getAll")
	public void getAllFiles(HttpServletResponse response) {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachement; filename= BankDetails.pdf";
		response.setHeader(headerKey, headerValue);
		List<FinancialInstitution> listOfFi = new ArrayList<FinancialInstitution>();
		listOfFi = userService.getAllFiles();
		UserPDFreport exporter = new UserPDFreport(listOfFi);
		exporter.export(response);
	}

}
