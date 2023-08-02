package com.example.user.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.customException.BusinessException;
import com.example.user.dto.FinancialInstitutionDto;
import com.example.user.service.UserService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class UserServiceimpl implements UserService {

	String DIR_TO_UPLOAD = "C:/Users/nikdh/OneDrive/Desktop/New folder/";
	String DIR_TO_PICK_FILE = "C:/Users/nikdh/OneDrive/Desktop/PickFileFrom/TestFile.pdf";

	public String createFile(FinancialInstitutionDto fiDto) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(DIR_TO_UPLOAD + "example.pdf"));
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
			Chunk chunk = new Chunk(fiDto.toString(), font);

			document.add(chunk);
			document.close();
		} catch (Exception e) {
			throw new BusinessException("400", e.getMessage());
		}
		return "New File Created Successfully";

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

}
