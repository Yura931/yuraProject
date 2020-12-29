package reply.model;

import java.sql.Timestamp;
import java.util.Date;

public class Reply {
	private int replyId;
	private String memberId;
	private int articleNo;
	private String body;
	private Date regDate;
	
	public Reply(int replyId, String memberId, String body, Timestamp regDate) {
		this.replyId = replyId;
		this.memberId = memberId;
		this.body = body;
		this.regDate = regDate;
		
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
}
