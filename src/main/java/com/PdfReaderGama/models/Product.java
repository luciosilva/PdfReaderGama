package com.PdfReaderGama.models;

public class Product {

	private String cod;
	private String name;
	private String kind;
	private Double pdv;
	private String stock;

	public Product()
	{
	}

	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Double getPdv() {
		return pdv;
	}
	public void setPdv(String pdv) {		
		this.pdv = Double.valueOf(pdv.replace(",", "."));
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString()
	{
		return "--------------------------------------------------------------------------------------------------\n" + this.cod + "|" + this.name + "|" + this.kind + "|" + this.pdv + "|" + this.stock;
	}
	
}
