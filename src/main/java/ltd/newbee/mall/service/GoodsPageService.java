package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

public interface GoodsPageService {
	
	// QA分页
	PageResult getQuestionAndAnswer(PageQueryUtil pageUtil);
	
	// 質問を投稿
	long insertQuestion(QuestionAndAnswer question);
	
	// 参考になった
	boolean insertHelpNum(QuestionAndAnswer qaHelpNum);
	boolean updateQuestionNum(QuestionAndAnswer qaHelpNum);
	long getHelpNum(long qaHelpNum);
	
}
