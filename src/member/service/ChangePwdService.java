package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePwdService {
	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(String id, String curPwd, String newPwd) {
		Connection con = null;
		
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Member member = memberDao.selectById(con, id);
			
			if (member == null) {
				throw new MemberNotFoundException();
			}
			
			if (!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			
			member.changePassword(newPwd);
			memberDao.update(con, member);
			con.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		
		
	}

}
