package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;


public class LoginService {
private MemberDao memberDao = new MemberDao();
	public User login(String id, String password) {
		try (Connection con = ConnectionProvider.getConnection()) {
			Member m = memberDao.selectById(con, id);
			
			if(m == null) {
				throw new LoginFailException();
			}
			
			if(!m.matchPassword(password)) {
				throw new LoginFailException();
			}
			
			return new User(m.getId(), m.getName(), m.getPassword(), m.getGrade(), m.getBirth(), m.getEmail(), m.getRegdate());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
