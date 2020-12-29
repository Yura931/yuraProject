package reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import reply.dao.ReplyDao;
import reply.model.Reply;

public class ReplyListService {
	ReplyDao dao = new ReplyDao();
	private int size = 15;
	
	public ReplyPage getReplyList (int articleNo, int pageNo) {
		try (Connection con = ConnectionProvider.getConnection()) {
		int total = dao.selectCount(con);	
		List<Reply> reply = dao.select(con, articleNo, pageNo, size);
		
		return new ReplyPage(total, pageNo, size, reply);
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
