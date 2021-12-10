package ltd.newbee.mall.service;

import java.util.List;

import ltd.newbee.mall.entity.ResDetailCourse;
import ltd.newbee.mall.entity.ResDetailFeature;
import ltd.newbee.mall.entity.ResDetailPhoto;
import ltd.newbee.mall.entity.ResDetailReserve;
import ltd.newbee.mall.entity.ResDetailReview;
import ltd.newbee.mall.entity.ResDetailScore;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.entity.ResDetailSeat;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryUtil;


public interface ResDetailScreenService {

	List<ResDetailScreen> getResDetail(long restaurantId);
	long getFollowTotal(long followResId);
	
	List<ResDetailPhoto> getMainphoto(long restaurantId,long photoCode);
	List<ResDetailPhoto> getCommitphoto(long restaurantId);
	List<ResDetailCourse> getCourse(long restaurantId);
	List<ResDetailScreen> getBacicInfo(long restaurantId);
	List<ResDetailSeat> getSeatInfo(long restaurantId);
	List<ResDetailFeature> getFeaturInfo(long restaurantId);
	List<ResDetailReview> getReviewList(long restaurantId);
	List<ResDetailReview> getVisitNum(long restaurantId);
	List<ResDetailReserve> getReserveInfo(long restaurantId);
	
	//int getMenuPhotoCount(PageInquiryUtil pageUtil);
	PageInquiryResult getMenuPhoto(PageInquiryUtil pageUtil);
	
	List<ResDetailScore> getScoreDistribute(long restaurantId);
	List<ResDetailScore> getItemAvgScore(long restaurantId);
}
