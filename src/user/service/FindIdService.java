package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;


public class FindIdService {
	MemberDao memberDao = new MemberDao();
	
	public Member find (String name, String email) {
		Connection con = null;
		Member member = new Member();
		try {
			con = ConnectionProvider.getConnection();
			
		member = memberDao.selectFindId(con, name, email);
		
		member.setName(name);
		member.setEmail(email);
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
		}
		return member;
	}

}
