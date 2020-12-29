package article.service;

import java.sql.Connection;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;
import user.service.User;

public class DeleteArticleService {
	private MemberDao memberDao = new MemberDao();
	private ArticleDao articleDao = new ArticleDao();
	public  void delArticle (int no, User user, String password) {
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			
			Member member = memberDao.selectById(con, user.getId());
			
			if (!member.getPassword().equals(password)) {
				throw new PermissionDeniedException();
			}
			articleDao.delete(con, no);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
		}
	}
}
