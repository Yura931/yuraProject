package user.service;

import java.sql.Connection;


import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class FindPasswordService {
	private MemberDao memberDao = new MemberDao();
	public Member findPwd(String id, String name, String email) {
		Connection con = null;
		Member member = new Member();
		try {
			con = ConnectionProvider.getConnection();
			
			member = memberDao.seletByPwd(con, id, name, email);
			member.setId(id);
			member.setName(name);
			member.setEmail(email);
						
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(con);
		} finally {
			JdbcUtil.close(con);
		}
		
		return member;
	}

}
