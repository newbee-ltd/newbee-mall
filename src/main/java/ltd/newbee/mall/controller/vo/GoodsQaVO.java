package ltd.newbee.mall.controller.vo;

public class GoodsQaVO {
	private long goodsId;
	
	private long qaId;
	
	private long count;
	
	private long countQa;
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "GoodsQaVO [goodsId=" + goodsId + ", qaId=" + qaId + ", count=" + count + ", countQa=" + countQa
				+ ", userId=" + userId + ", question=" + question + ", questionDate=" + questionDate + ", answer="
				+ answer + ", answerDate=" + answerDate + "]";
	}

	public long getCountQa() {
		return countQa;
	}

	public void setCountQa(long countQa) {
		this.countQa = countQa;
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
