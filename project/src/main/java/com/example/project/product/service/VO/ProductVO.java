package com.example.project.product.service.VO;

public class ProductVO {
	
	private int productId;
	private String productTitle;
	private String productDescription;
	private String productType;
	private int productGood = 0;
	private int productBad = 0;
	private String productThumnail;
	private String productDate;
	
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public String getProductThumnail() {
		return productThumnail;
	}
	public void setProductThumnail(String productThumnail) {
		this.productThumnail = productThumnail;
	}
	private String keyword;
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getProductGood() {
		return productGood;
	}
	public void setProductGood(int productGood) {
		this.productGood = productGood;
	}
	public int getProductBad() {
		return productBad;
	}
	public void setProductBad(int productBad) {
		this.productBad = productBad;
	}
	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productTitle=" + productTitle
				+ ", productDescription=" + productDescription + ", productType=" + productType + ", productGood="
				+ productGood + ", productBad=" + productBad + ", keyword=" + keyword + "]";
	}
	
	
	
}
