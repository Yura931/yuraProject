package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private MemberDao memberDao = new MemberDao();
	public void join (JoinRequest joinReq) {
		Connection con = null;
		try {
		con = ConnectionProvider.getConnection();
		
		Member m = memberDao.selectById(con, joinReq.getId());
		
		if (m != null) {
			throw new DuplicatedIdException();
		}
		
		Member member = new Member();
		member.setId(joinReq.getId());
		member.setName(joinReq.getName());
		member.setPassword(joinReq.getPassword());
		member.setEmail(joinReq.getEmail());
		member.setBirth(joinReq.getBirth());
		memberDao.insert(con, member);
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
		
	}
}
