package com.sitegenerator.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sitegenerator.enums.ProductCategory;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "PRODUCT_ID", unique = true, length = 255)
	private String prId;

	@Column(name = "PRODUCT_NAME", length = 255)
	private String prName;

	@Column(name = "PRODUCT_PRICE")
	private String prPrice;

	@Column(name = "PRODUCT_URL", length = 255)
	private String prUrl;

	@Column(name = "PRODUCT_IMG")
	private String prImgUrl;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ProductAttributes attributes;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProductReviews> productReview;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RelatedProduct> relatedProductsList;

	@Column(name = "PRODUCT_CATEGORY")
	@Enumerated(EnumType.STRING)
	private ProductCategory category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrId() {
		return prId;
	}

	public void setPrId(String prId) {
		this.prId = prId;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getPrPrice() {
		return prPrice;
	}

	public void setPrPrice(String prPrice) {
		this.prPrice = prPrice;
	}

	public String getPrUrl() {
		return prUrl;
	}

	public void setPrUrl(String prUrl) {
		this.prUrl = prUrl;
	}

	public String getPrImgUrl() {
		return prImgUrl;
	}

	public void setPrImgUrl(String prImgUrl) {
		this.prImgUrl = prImgUrl;
	}

	public ProductAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(ProductAttributes attributes) {
		this.attributes = attributes;
	}

	public List<ProductReviews> getProductReview() {
		return productReview;
	}

	public void setProductReview(List<ProductReviews> productReview) {
		this.productReview = productReview;
	}

	public List<RelatedProduct> getRelatedProductsList() {
		return relatedProductsList;
	}

	public void setRelatedProductsList(List<RelatedProduct> relatedProductsList) {
		this.relatedProductsList = relatedProductsList;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}
}
