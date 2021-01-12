package member.service;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	private String email;
	private String birth;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void validate(Map<String, Boolean> errors) {
		checkLogin (errors, id, "id");
		checkLogin (errors, name, "name");
		checkLogin (errors, password, "password");
		checkLogin (errors, confirmPassword, "confirmPassword");
		checkLogin (errors, email, "email");
		checkLogin (errors, birth, "birth");
		
		if (!password.contentEquals(confirmPassword)) {
			errors.put("notMatch", true);
		}
	}
	private void checkLogin(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, true);
		}
		
	}

}

