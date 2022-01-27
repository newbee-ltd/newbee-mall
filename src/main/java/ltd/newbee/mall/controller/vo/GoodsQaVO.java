package ltd.newbee.mall.controller.vo;

public class GoodsQaVO {
	private long goodsId;
	
	private long qaId;
	
	private long count;
	
	@Override
	public String toString() {
		return "GoodsQa [goodsId=" + goodsId + ", qaId=" + qaId + ", count=" + count + ", question=" + question
				+ ", questionDate=" + questionDate + ", answer=" + answer + ", answerDate=" + answerDate + "]";
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	private String question;
	
	private String questionDate;
	
	private String answer;
	
	private String answerDate;

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public long getQaId() {
		return qaId;
	}

	public void setQaId(long qaId) {
		this.qaId = qaId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	
	
	

}
