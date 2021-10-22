package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.util.PageQueryUtil;

public interface GoodsPageMapper {
    
	// QA分页
	List<QuestionAndAnswer> findQuestionAndAnswerList(PageQueryUtil pageUtil);
	
	int getTotalQuestionAndAnswer(PageQueryUtil pageUtil);
	
	// 質問を投稿
	long insertQuestion(QuestionAndAnswer question);
	long getMaxQuestionId();
	
	// 参考になった
	boolean insertHelpNum(QuestionAndAnswer qaHelpNum);
	boolean updateQuestionNum(QuestionAndAnswer qaHelpNum);
	long getHelpNum(long qaHelpNum);
	
}