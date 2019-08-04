package com.example.project.product.service.VO;

public class ProductVO {
	
	private int productId;
	private String productName;
	private String productTitle;
	private String productDescription;
	private String productType;
	private String productGood;
	private String productBad;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public String getProductGood() {
		return productGood;
	}
	public void setProductGood(String productGood) {
		this.productGood = productGood;
	}
	public String getProductBad() {
		return productBad;
	}
	public void setProductBad(String productBad) {
		this.productBad = productBad;
	}
	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productName=" + productName + ", productTitle=" + productTitle
				+ ", productDescription=" + productDescription + ", productType=" + productType + ", productGood="
				+ productGood + ", productBad=" + productBad + "]";
	}
	
	
}
