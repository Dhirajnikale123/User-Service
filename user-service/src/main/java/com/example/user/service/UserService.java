package com.example.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.user.dto.MockApiDto;
import com.example.user.entity.FinancialInstitution;

@Service
public interface UserService {

	String deleteFile(Integer id);

	List<FinancialInstitution> getAllFiles();

	String uploadFile(MultipartFile multipartFile);

	List<MockApiDto> getMockApiData(Integer postId);

}
