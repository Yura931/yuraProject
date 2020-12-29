package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import reply.dao.ReplyDao;

public class ReplyService {
	private ReplyDao dao = new ReplyDao();
	
	public void add(String userId, int article_no, String body) {
		Connection con;
		con = ConnectionProvider.getConnection();
		try {
			dao.insert(con, userId, article_no, body);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
