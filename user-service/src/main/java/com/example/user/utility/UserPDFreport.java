package com.example.user.utility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.user.customException.BusinessException;
import com.example.user.entity.FinancialInstitution;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserPDFreport {

	private List<FinancialInstitution> listOfFi;

	public UserPDFreport(List<FinancialInstitution> listOfFi) {
		this.listOfFi = listOfFi;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setPadding(10);
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		cell.setPhrase(new Phrase("Bank Id", font));
		cell.setPhrase(new Phrase("Bank Name", font));
		cell.setPhrase(new Phrase("Customers", font));
		cell.setPhrase(new Phrase("Location", font));
		cell.setPhrase(new Phrase("Country", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for(FinancialInstitution fi : listOfFi)
		{
			table.addCell(String.valueOf(fi.getId()));
			table.addCell(String.valueOf(fi.getBank()));
			table.addCell(String.valueOf(fi.getCustomers()));
			table.addCell(String.valueOf(fi.getLocation()));
			table.addCell(String.valueOf(fi.getCountry()));
		}
	}

	public void export(HttpServletResponse response) {
		Document doc = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(doc, response.getOutputStream());
			doc.open();
			doc.add(new Paragraph("List of Banks"));
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setSpacingBefore(15);
			writeTableHeader(table);
			writeTableData(table);
			doc.add(table);
			doc.close();

		} catch (Exception e) {
			throw new BusinessException("400", e.getMessage());
		}
	}

}
