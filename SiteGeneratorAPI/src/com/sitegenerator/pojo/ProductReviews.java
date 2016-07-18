package com.sitegenerator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_reviews")
public class ProductReviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "PRODUCT_ID", unique = false)
	private String prId;

	@Column(name = "REVIEW_RATING")
	private double rating;

	@Column(name = "REVIEW_TITLE")
	private String title;

	@Column(name = "REVIEW_AUTHOR")
	private String author;

	@Column(name = "REVIEW_DATE")
	private String date;

	@Column(name = "REVIEW_TEXT", length = 10000)
	private String reviewText;

	public ProductReviews() {

	}

	public ProductReviews(double rating, String title, String author, String date, String reviewText) {

		this.rating = rating;
		this.title = title;
		this.author = author;
		this.date = date;
		this.reviewText = reviewText;
	}

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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
}
