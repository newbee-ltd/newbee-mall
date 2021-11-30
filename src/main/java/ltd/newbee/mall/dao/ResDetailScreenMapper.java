package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.entity.ResDetailCourse;
import ltd.newbee.mall.entity.ResDetailFeature;
import ltd.newbee.mall.entity.ResDetailPhoto;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.entity.ResDetailSeat;

public interface ResDetailScreenMapper {

	List<ResDetailScreen> getResDetail(long restaurantId);
	long getFollowTotal(long followResId);

	List<ResDetailPhoto> getMainphoto(long restaurantId,long photoCode);
	List<ResDetailPhoto> getCommitphoto(long restaurantId);
	List<ResDetailCourse> getCourse(long restaurantId);
	List<ResDetailScreen> getBacicInfo(long restaurantId);
	List<ResDetailSeat> getSeatInfo(long restaurantId);
	List<ResDetailFeature> getFeaturInfo(long restaurantId);

	
	
}
