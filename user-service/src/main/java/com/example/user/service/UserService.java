package com.example.user.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.dto.FinancialInstitutionDto;

@Service
public interface UserService {
	
	String uploadFile(String filePath);

	String deleteFile(String filename);

	List<File> getAllFiles(String path);

	String createFile(FinancialInstitutionDto fiDto);

}
