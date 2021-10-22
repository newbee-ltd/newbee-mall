package ltd.newbee.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.GoodsPageMapper;
import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.service.GoodsPageService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

@Service
public class GoodsPageServiceImpl implements GoodsPageService {
	
	@Autowired
	private GoodsPageMapper goodsPageMapper;
	
	// QA分页
	@Override
    public PageResult getQuestionAndAnswer(PageQueryUtil pageUtil) {
		List<QuestionAndAnswer> questionAndAnswer = goodsPageMapper.findQuestionAndAnswerList(pageUtil);
		int total = goodsPageMapper.getTotalQuestionAndAnswer(pageUtil);
		PageResult pageResult = new PageResult(questionAndAnswer, total, pageUtil.getLimit(), pageUtil.getPage());
		return pageResult;
	}
	
	// 質問を投稿
	@Override
	public long insertQuestion(QuestionAndAnswer question) {
		long maxQuestionId = goodsPageMapper.getMaxQuestionId();
		question.setQuestionId(maxQuestionId + 1);
		return goodsPageMapper.insertQuestion(question);
	}
	
	// 参考になった
	@Override
	public boolean insertHelpNum(QuestionAndAnswer qaHelpNum) {
		return goodsPageMapper.insertHelpNum(qaHelpNum);
	}
		
	@Override
	public boolean updateQuestionNum(QuestionAndAnswer qaHelpNum) {
		return goodsPageMapper.updateQuestionNum(qaHelpNum);
	}
		
	public long getHelpNum(long qaHelpNum) {
		return goodsPageMapper.getHelpNum(qaHelpNum);
	}

}
