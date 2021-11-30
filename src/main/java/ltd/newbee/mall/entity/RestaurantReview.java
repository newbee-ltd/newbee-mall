package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestaurantReview {
	
	private long restaurantId;
	private String restaurantName;
	private long reviewId;
	private String reviewUserId;
	private String reviewUserName;
	private String reviewUserAge;
	private String reviewUserGender;
	private String reviewUserCity;
	private String reviewTitle;
	private String reviewDetail;
	private String reviewImg;
	private double scoreTotal;
	private double scoreTaste;
	private double scoreService;
	private double scoreAtmosphere;
	private double scoreCost;
	private double scoreDrink;
	private String budget;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date visitDate;
	private String nightOrDaytime;
	private String replyDetail;
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewUserId() {
		return reviewUserId;
	}
	public void setReviewUserId(String reviewUserId) {
		this.reviewUserId = reviewUserId;
	}
	public String getReviewUserName() {
		return reviewUserName;
	}
	public void setReviewUserName(String reviewUserName) {
		this.reviewUserName = reviewUserName;
	}
	public String getReviewUserAge() {
		return reviewUserAge;
	}
	public void setReviewUserAge(String reviewUserAge) {
		this.reviewUserAge = reviewUserAge;
	}
	public String getReviewUserGender() {
		return reviewUserGender;
	}
	public void setReviewUserGender(String reviewUserGender) {
		this.reviewUserGender = reviewUserGender;
	}
	public String getReviewUserCity() {
		return reviewUserCity;
	}
	public void setReviewUserCity(String reviewUserCity) {
		this.reviewUserCity = reviewUserCity;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewDetail() {
		return reviewDetail;
	}
	public void setReviewDetail(String reviewDetail) {
		this.reviewDetail = reviewDetail;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public double getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(double scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public double getScoreTaste() {
		return scoreTaste;
	}
	public void setScoreTaste(double scoreTaste) {
		this.scoreTaste = scoreTaste;
	}
	public double getScoreService() {
		return scoreService;
	}
	public void setScoreService(double scoreService) {
		this.scoreService = scoreService;
	}
	public double getScoreAtmosphere() {
		return scoreAtmosphere;
	}
	public void setScoreAtmosphere(double scoreAtmosphere) {
		this.scoreAtmosphere = scoreAtmosphere;
	}
	public double getScoreCost() {
		return scoreCost;
	}
	public void setScoreCost(double scoreCost) {
		this.scoreCost = scoreCost;
	}
	public double getScoreDrink() {
		return scoreDrink;
	}
	public void setScoreDrink(double scoreDrink) {
		this.scoreDrink = scoreDrink;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getNightOrDaytime() {
		return nightOrDaytime;
	}
	public void setNightOrDaytime(String nightOrDaytime) {
		this.nightOrDaytime = nightOrDaytime;
	}
	public String getReplyDetail() {
		return replyDetail;
	}
	public void setReplyDetail(String replyDetail) {
		this.replyDetail = replyDetail;
	}
	
}
