package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.util.PageInquiryUtil;

public interface PageInquiryMapper {

	List<QuestionAndAnswer> findQAList(PageInquiryUtil pageUtil);

	int getGoodsQACount(PageInquiryUtil pageUtil);

	
}
