package com.sitegenerator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "related_products")
public class RelatedProduct {

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
}
