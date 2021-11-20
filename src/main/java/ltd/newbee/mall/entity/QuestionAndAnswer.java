package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QuestionAndAnswer {

	private long goodsId; 
	private long questionsId;
	private String question;
	private String answer;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date submitDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date answersDate;
	
	private long helpNum;
	
	
	public long getHelpNum() {
		return helpNum;
	}
	public void setHelpNum(long helpNum) {
		this.helpNum = helpNum;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public long getQuestionsId() {
		return questionsId;
	}
	public void setQuestionsId(long questionsId) {
		this.questionsId = questionsId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public Date getAnswersDate() {
		return answersDate;
	}
	public void setAnswersDate(Date answersDate) {
		this.answersDate = answersDate;
	}
	
	

}
