package user.service;

public class User {
	private String id;
	private String password;
	private String grade;
	
	public User(String id, String password, String grade) {
		this.id = id;
		this.password = password;
		this.grade = grade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
