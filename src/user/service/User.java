package user.service;

import java.util.Date;

public class User {
	private String id;
	private String name;
	private String password;
	private String grade;
	private String email;
	private String birth;
	private Date regdate;
	
	public User(String id, String name, String password, String grade) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.grade = grade;
	}
	public User(String id, String name, String password, String grade, String birth, String email, Date regdate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.grade = grade;
		this.setBirth(birth);
		this.setEmail(email);
		this.setRegdate(regdate);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
