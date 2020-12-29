package article.service;

public class ModifiedData {
	private String userId;
	private int article_no;
	private String title;
	private String content;
	
	public ModifiedData (String userId, int article_no, String title, String content) {
		this.userId = userId;
		this.article_no = article_no;
		this.title = title;
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getArticle_no() {
		return article_no;
	}

	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
