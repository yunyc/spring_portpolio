package com.example.project.product.service.VO;

import javax.validation.constraints.Size;

/**
 * @Class Name : ProductVO.java
 * @Description : ProductVO Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019.09.02               버그 수정
 *
 * @author yunyc
 * @since 2019. 07.01
 * @version 1.0
 * @see
 *
 */

public class ProductVO {
	/** 상품 글 번호 */
	private int productId;
	
	/** 상품 글 제목 */
	@Size(min = 1, max = 80)
	private String productTitle;
	
	/** 상품 글 내용 */
	private String productDescription;
	
	/** 상품 글 종류 */
	private String productType;
	
	/** 상품 글 좋아요 개수 */
	private int productGood = 0;
	
	/** 상품 글 싫어요 개수 */
	private int productBad = 0;
	
	/** 상품 글 썸네일 */
	private String productThumnail;
	
	/** 상품 글 작성 날짜 */
	private String productDate;
	
	/** 상품 구매 포인트 */
	private int productPoint;
	
	public int getProductPoint() {
		return productPoint;
	}
	public void setProductPoint(int productPoint) {
		this.productPoint = productPoint;
	}
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
