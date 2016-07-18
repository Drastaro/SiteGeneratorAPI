package com.sitegenerator.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "product_attributes")
public class ProductAttributes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "PRODUCT_ID", unique = true)
	private String prId;

	@Column(name = "PRODUCT_COLOR", length = 200)
	private String prColor;

	@Column(name = "PRODUCT_BRAND", length = 50)
	private String prBrand;

	@Column(name = "PRODUCT_MODEL", length = 50)
	private String prModel;

	@Column(name = "PRODUCT_MANUFACTURER", length = 100)
	private String prManufacturer;

	@Column(name = "PRODUCT_LABEL", length = 100)
	private String prLabel;

	@Column(name = "PRODUCT_PUBLICATION_DATE", length = 50)
	private String prPublicationDate;

	@Column(name = "PRODUCT_GROUP", length = 100)
	private String prGroup;

	@Column(name = "PRODUCT_TYPE_NAME", length = 100)
	private String prTypeName;

	@Column(name = "PRODUCT_PUBLISHER", length = 100)
	private String prPublisher;

	@Column(name = "PRODUCT_WARRANITY", length = 100)
	private String prWarranity;

	@Column(name = "PRODUCT_PACKAGE_QUANTITY", length = 10)
	private String prPackageQuantity;

	@Column(name = "PRODUCT_SALES_RANK", length = 10)
	private String prSalesRank;

	@Column(name = "PRODUCT_REVIEWS_RATE_AVARAGE", length = 10)
	private String productReviewsRateAvarage;

	@Column(name = "PRODUCT_REVIEWS_COUNT", length = 10)
	private String productReviewsCount;

	@Column(name = "PRODUCT_DIMENSION", length = 1000)
	private String productDimensions;

	@Column(name = "PRODUCT_WEIGHT", length = 50)
	private String productWeight;

	@Column(name = "PRODUCT_BINDING", length = 50)
	private String prBinding;

	@Column(name = "PRODUCT_EDITION", length = 50)
	private String prEdition;

	@Column(name = "PRODUCT_HARDWARE_PLATFORM", length = 50)
	private String prHardwarePlatform;

	@Column(name = "PRODUCT_GENRE", length = 50)
	private String prGenre;

	@Column(name = "PRODUCT_FEATURES", length = 10000)
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<String> prFeatures;

	@Column(name = "PRODUCT_IMAGESET")
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<String> prImageSetUrl;

	@Column(name = "PRODUCT_EDITORIAL_REVIEW", length = 10000)
	private String prEditorialReview;

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

	public String getPrColor() {
		return prColor;
	}

	public void setPrColor(String prColor) {
		this.prColor = prColor;
	}

	public String getPrBrand() {
		return prBrand;
	}

	public void setPrBrand(String prBrand) {
		this.prBrand = prBrand;
	}

	public String getPrModel() {
		return prModel;
	}

	public void setPrModel(String prModel) {
		this.prModel = prModel;
	}

	public String getPrManufacturer() {
		return prManufacturer;
	}

	public void setPrManufacturer(String prManufacturer) {
		this.prManufacturer = prManufacturer;
	}

	public String getPrLabel() {
		return prLabel;
	}

	public void setPrLabel(String prLabel) {
		this.prLabel = prLabel;
	}

	public String getPrPublicationDate() {
		return prPublicationDate;
	}

	public void setPrPublicationDate(String prPublicationDate) {
		this.prPublicationDate = prPublicationDate;
	}

	public String getPrGroup() {
		return prGroup;
	}

	public void setPrGroup(String prGroup) {
		this.prGroup = prGroup;
	}

	public String getPrTypeName() {
		return prTypeName;
	}

	public void setPrTypeName(String prTypeName) {
		this.prTypeName = prTypeName;
	}

	public String getPrPublisher() {
		return prPublisher;
	}

	public void setPrPublisher(String prPublisher) {
		this.prPublisher = prPublisher;
	}

	public String getPrWarranity() {
		return prWarranity;
	}

	public void setPrWarranity(String prWarranity) {
		this.prWarranity = prWarranity;
	}

	public String getPrPackageQuantity() {
		return prPackageQuantity;
	}

	public void setPrPackageQuantity(String prPackageQuantity) {
		this.prPackageQuantity = prPackageQuantity;
	}

	public String getPrSalesRank() {
		return prSalesRank;
	}

	public void setPrSalesRank(String prSalesRank) {
		this.prSalesRank = prSalesRank;
	}

	public String getProductReviewsRateAvarage() {
		return productReviewsRateAvarage;
	}

	public void setProductReviewsRateAvarage(String productReviewsRateAvarage) {
		this.productReviewsRateAvarage = productReviewsRateAvarage;
	}

	public String getProductReviewsCount() {
		return productReviewsCount;
	}

	public void setProductReviewsCount(String productReviewsCount) {
		this.productReviewsCount = productReviewsCount;
	}

	public String getProductDimensions() {
		return productDimensions;
	}

	public void setProductDimensions(String productDimensions) {
		this.productDimensions = productDimensions;
	}

	public String getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}

	public String getPrBinding() {
		return prBinding;
	}

	public void setPrBinding(String prBinding) {
		this.prBinding = prBinding;
	}

	public String getPrEdition() {
		return prEdition;
	}

	public void setPrEdition(String prEdition) {
		this.prEdition = prEdition;
	}

	public String getPrHardwarePlatform() {
		return prHardwarePlatform;
	}

	public void setPrHardwarePlatform(String prHardwarePlatform) {
		this.prHardwarePlatform = prHardwarePlatform;
	}

	public String getPrGenre() {
		return prGenre;
	}

	public void setPrGenre(String prGenre) {
		this.prGenre = prGenre;
	}

	public List<String> getPrFeatures() {
		return prFeatures;
	}

	public void setPrFeatures(List<String> prFeatures) {
		this.prFeatures = prFeatures;
	}

	public List<String> getPrImageSetUrl() {
		return prImageSetUrl;
	}

	public void setPrImageSetUrl(List<String> prImageSetUrl) {
		this.prImageSetUrl = prImageSetUrl;
	}

	public String getPrEditorialReview() {
		return prEditorialReview;
	}

	public void setPrEditorialReview(String prEditorialReview) {
		this.prEditorialReview = prEditorialReview;
	}
}
