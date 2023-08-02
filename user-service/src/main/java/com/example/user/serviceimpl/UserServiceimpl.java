package com.example.user.serviceimpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.user.customException.BusinessException;
import com.example.user.dto.FinancialInstitutionDto;
import com.example.user.entity.FinancialInstitution;
import com.example.user.repo.FinancialInstitutionRepo;
import com.example.user.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	String DIR_TO_UPLOAD = "C:/Users/nikdh/OneDrive/Desktop/New folder/";
	String DIR_TO_PICK_FILE = "C:/Users/nikdh/OneDrive/Desktop/PickFileFrom/TestFile.pdf";
	
	@Autowired
	FinancialInstitutionRepo fiRepo;

	public String createFile(FinancialInstitutionDto fiDto) {
//		try {
//			Document document = new Document();
//			PdfWriter.getInstance(document, new FileOutputStream(DIR_TO_UPLOAD + "example.pdf"));
//			document.open();
//			Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
//			Chunk chunk = new Chunk(fiDto.toString(), font);
//
//			document.add(chunk);
//			document.close();
//		} catch (Exception e) {
//			throw new BusinessException("400", e.getMessage());
//		}
		return "New File Created Successfully";
//
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

	@Override
	public String uploadFile(MultipartFile multipartFile) {
		try {
			byte[] contentInByte =multipartFile.getBytes();
			PDDocument pdDoc = PDDocument.load(contentInByte);
			PDFTextStripper pdfRead = new PDFTextStripper();
			String content = pdfRead.getText(pdDoc);
			System.out.println(content);
			pdDoc.close();
			String[] splitter = content.split(",");
			String[] values = null;
			List<String> list = new ArrayList<String>();
			for(String s : splitter)
			{
				String str = s.replaceAll("\\s", "");
				values = str.split(":");
				list.add(values[1]);
			}
			FinancialInstitution fi = new FinancialInstitution();
			fi.setBank(list.get(0));
			fi.setCustomers(Integer.parseInt(list.get(1)));
			fi.setLocation(list.get(2));
			fi.setCountry(list.get(3));
			
			fi = fiRepo.save(fi);
				
		} catch (Exception e) {
			throw new BusinessException("400", e.getMessage());
		}
		return "File Uploaded Successfully";
	}

}
