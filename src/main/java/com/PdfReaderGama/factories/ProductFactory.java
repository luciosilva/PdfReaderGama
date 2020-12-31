package com.PdfReaderGama.factories;

import com.PdfReaderGama.models.Product;

public class ProductFactory {

	public static Product getProduct(String line) {

		Product product = new Product();
		
		product.setCod(line.substring(0,line.indexOf(" ")).trim());				
		line = line.substring(line.indexOf(" "),line.length());
		
		product.setStock(line.substring(line.lastIndexOf(" "),line.length()).trim());
		line = line.substring(0,line.lastIndexOf(" "));

		product.setPdv(line.substring(line.lastIndexOf(" "),line.length()).trim());
		line = line.substring(0,line.lastIndexOf(" "));

		product.setKind(line.substring(line.lastIndexOf(" "),line.length()).trim());
		line = line.substring(0,line.lastIndexOf(" "));
		
		product.setName(line.trim());
		
		return product;		
	}
	
}
