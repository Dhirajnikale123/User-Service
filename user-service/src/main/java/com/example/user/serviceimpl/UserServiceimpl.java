package com.example.user.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.user.api.ExternalApi;
import com.example.user.customException.BusinessException;
import com.example.user.dto.MockApiDto;
import com.example.user.entity.FinancialInstitution;
import com.example.user.repo.FinancialInstitutionRepo;
import com.example.user.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	FinancialInstitutionRepo fiRepo;

	@Autowired
	ExternalApi externalApi;

	public String deleteFile(Integer id) {
		try {
			fiRepo.deleteById(id);
			return "Deleted Successfully";
		} catch (Exception e) {
			throw new BusinessException("400", e.getMessage());
		}
	}

	@Override
	public String uploadFile(MultipartFile multipartFile) {
		try {
			byte[] contentInByte = multipartFile.getBytes();
			PDDocument pdDoc = PDDocument.load(contentInByte);
			PDFTextStripper pdfRead = new PDFTextStripper();
			String content = pdfRead.getText(pdDoc);
			System.out.println(content);
			pdDoc.close();
			String[] splitter = content.split(",");
			String[] values = null;
			List<String> list = new ArrayList<String>();
			for (String s : splitter) {
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

	@Override
	public List<FinancialInstitution> getAllFiles() {
		List<FinancialInstitution> listOfFi = new ArrayList<FinancialInstitution>();
		try {
			listOfFi = fiRepo.findAll();
		} catch (Exception e) {
			throw new BusinessException("400", "Bad Request");
		}
		return listOfFi;
	}

	@Override
	public List<MockApiDto> getMockApiData(Integer postId) {
		List<MockApiDto> list = new ArrayList<MockApiDto>();
		try {
			list = externalApi.getMockDataList(postId);
		} catch (Exception e) {
			throw new BusinessException("400", "Bad Request");
		}
		return list;
	}

}
