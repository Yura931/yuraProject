package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;
import user.service.User;

public class DeleteMemberService {
MemberDao memberDao = new MemberDao();

	public void deleteMember(User user, String password) {
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			Member member = memberDao.selectById(con, user.getId());
			
			if (member == null) {
				throw new MemberNotFoundException();
			}
			
			memberDao.delete(con, user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		
	}
	
}
