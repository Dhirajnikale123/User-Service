package com.example.user.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.user.dto.FinancialInstitutionDto;
import com.example.user.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	UserController userController;

	@MockBean
	UserService userService;

//	@Test
//	public void createFileTest() throws Exception {
//		String uri = "/user/create";
//		FinancialInstitutionDto fiDto = new FinancialInstitutionDto();
//		fiDto.setFiName("TestFi");
//		fiDto.setCountry("TestCountry");
//		fiDto.setCustomers(5);
//		fiDto.setLocation("TestLocation");
//		Mockito.when(userService.createFile(fiDto)).thenReturn("New File Created Successfully");
//		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
//				.content("{\r\n" + "    \"fiName\":\"TestFi\",\r\n" + "    \"customers\":5,\r\n"
//						+ "    \"location\":\"TestLocation\",\r\n" + "    \"country\":\"TestCountry\"\r\n" + "}")
//				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//	}
//
//	@Test
//	public void deleteFileTest() throws Exception {
//		String uri = "/user/delete";
//		String filename = "test.txt";
//		Mockito.when(userService.deleteFile(filename)).thenReturn("Deleted Successfully");
//
//		mockMvc.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
//				.param("filename", "example.txt").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//	}
//
//	@Test
//	public void getFilesTest() throws Exception {
//		String uri = "/user/getAll";
//		String path = "../searchFolder/";
//		List<File> listOfFiles = new ArrayList<File>();
//		Mockito.when(userService.getAllFiles(path)).thenReturn(listOfFiles);
//
//		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
//				.param("path", "../searchFolder/").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//	}

}
