package ltd.newbee.mall.entity;

public class InsertGoodsQa {


	private long goodsId;
	
	private long qaId;
	
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

	@Override
	public String toString() {
		return "InsertGoodsQa [goodsId=" + goodsId + ", qaId=" + qaId + ", question=" + question + ", questionDate="
				+ questionDate + ", answer=" + answer + ", answerDate=" + answerDate + "]";
	}
	
	
	
	
	

	

}
