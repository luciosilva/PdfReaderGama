package com.PdfReaderGama;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.PdfReaderGama.dao.Dao;
import com.PdfReaderGama.factories.ProductFactory;
import com.PdfReaderGama.models.Product;

public class PdfReaderGama {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		File file = new File("C://Users//lucio//Downloads//EstoqueAtual.pdf");
		
		Dao dao = new Dao();
		
		dao.truncate();
		try(PDDocument document = PDDocument.load(file))
		{
			if(!document.isEncrypted())
			{
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);

				PDFTextStripper tStripper = new PDFTextStripper();
				
				String pdfFileInText = tStripper.getText(document);
				
				String lines[] = pdfFileInText.split("\\r?\\n");
				
				lines = Arrays.copyOfRange(lines, 1, lines.length);

				if(lines.length > 0)
				{
					for(String line : lines)
					{	
						Product product = ProductFactory.getProduct(line);
						dao.insert(product);
					}
				}
			}
		}
		

	}

}
