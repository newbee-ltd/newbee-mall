/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.vo;

import java.io.Serializable;

/**
 * 商品详情页VO
 */
public class RestaurantFeaturesInfoVO implements Serializable {
	
	private long restaurantId;
	private String restaurantName;
	private String goToEat;
	private String sceneName1;
	private String sceneName2;
	private String sceneName3;
	private String location;
	private String service;
	private String withChildren;
	private String homePage;
	private String accountTwitter;
	private String accountIns;
	private String openDate;
	private String telephone;
	private String remark;
	private long firstContributorId;
	private String firstContributorName;
	
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
	public String getGoToEat() {
		return goToEat;
	}
	public void setGoToEat(String goToEat) {
		this.goToEat = goToEat;
	}
	public String getSceneName1() {
		return sceneName1;
	}
	public void setSceneName1(String sceneName1) {
		this.sceneName1 = sceneName1;
	}
	public String getSceneName2() {
		return sceneName2;
	}
	public void setSceneName2(String sceneName2) {
		this.sceneName2 = sceneName2;
	}
	public String getSceneName3() {
		return sceneName3;
	}
	public void setSceneName3(String sceneName3) {
		this.sceneName3 = sceneName3;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getWithChildren() {
		return withChildren;
	}
	public void setWithChildren(String withChildren) {
		this.withChildren = withChildren;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getAccountTwitter() {
		return accountTwitter;
	}
	public void setAccountTwitter(String accountTwitter) {
		this.accountTwitter = accountTwitter;
	}
	public String getAccountIns() {
		return accountIns;
	}
	public void setAccountIns(String accountIns) {
		this.accountIns = accountIns;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getFirstContributorId() {
		return firstContributorId;
	}
	public void setFirstContributorId(long firstContributorId) {
		this.firstContributorId = firstContributorId;
	}
	public String getFirstContributorName() {
		return firstContributorName;
	}
	public void setFirstContributorName(String firstContributorName) {
		this.firstContributorName = firstContributorName;
	}
}
