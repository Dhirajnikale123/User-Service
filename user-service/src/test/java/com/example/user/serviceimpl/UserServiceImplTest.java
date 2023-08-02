package com.example.user.serviceimpl;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user.customException.BusinessException;
import com.example.user.dto.FinancialInstitutionDto;
import com.example.user.service.UserService;

@SpringBootTest(classes = {UserServiceimpl.class, UserService.class})
public class UserServiceImplTest {
	
	@Autowired
	UserServiceimpl userServiceimpl;
	
	@Mock
	UserService userService;
	
	
	@Test
	public void createFileTest() throws IOException
	{
		FinancialInstitutionDto fiDto = new FinancialInstitutionDto();
		BufferedWriter output = null;
		File file = new File("example.pdf");
		output = new BufferedWriter(new FileWriter(file));
		output.write(fiDto.toString());
		output.close();
		String result = userServiceimpl.createFile(fiDto);
		assertEquals(result,"New File Created Successfully");
		
	}
	
	@Test
	public void createFileExaceptionTest() throws IOException
	{
		FinancialInstitutionDto fiDto = new FinancialInstitutionDto();
		String result = userServiceimpl.createFile(fiDto);
		assertThatExceptionOfType(BusinessException.class);
		
	}
	
	@Test
	public void deleteFileTest() throws IOException
	{
		String toGetFileFrom = "C:/Users/nikdh/OneDrive/Desktop/New folder/";
		String fileName = "example.pdf";
		File f = new File(toGetFileFrom+fileName);
		String result = userServiceimpl.deleteFile(fileName);
		assertEquals(result,"Deleted Successfully");

	}

}
