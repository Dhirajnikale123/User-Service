package com.example.user.serviceimpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.customException.BusinessException;
import com.example.user.dto.FinancialInstitutionDto;
import com.example.user.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	String DIR_TO_UPLOAD = "C:/Users/nikdh/OneDrive/Desktop/New folder/";
	String DIR_TO_PICK_FILE = "C:/Users/nikdh/OneDrive/Desktop/PickFileFrom/TestFile.pdf";

	public String uploadFile(String filePath) {

		try {
			Path pdfPath = Paths.get(DIR_TO_PICK_FILE);
			byte[] bytes = Files.readAllBytes(pdfPath);
			DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			Path path = Paths.get(
					DIR_TO_UPLOAD + timeStampPattern.format(java.time.LocalDateTime.now()) + pdfPath.getFileName());
			Files.write(path, bytes);
		} catch (Exception e) {
			throw new BusinessException("500", "Failed to Upload file");
		}

		return "File uploaded";
	}

	public String deleteFile(String fileName) {
		File f = new File(DIR_TO_UPLOAD + fileName);
		if (f.delete()) {
			return "Deleted Successfully";
		} else {
			throw new BusinessException("400", "Failed to delete file");
		}
	}

	public List<File> getAllFiles(String path) {

		List<File> listOfFiles = new ArrayList<File>();
		File file = new File(DIR_TO_UPLOAD);
		File[] fileList = file.listFiles();
		if (fileList.length > 0) {
			for (File f : fileList) {
				listOfFiles.add(f);
			}
		}
		return listOfFiles;
	}

	public String createFile(FinancialInstitutionDto fiDto) {
		BufferedWriter output = null;
		try {
			File file = new File(DIR_TO_UPLOAD + "example.pdf");
			output = new BufferedWriter(new FileWriter(file));
			output.write(fiDto.toString());
			output.close();
		}
		catch (Exception e) {
			throw new BusinessException("400", e.getMessage());
		}
		return "New File Created Successfully";

	}

}
