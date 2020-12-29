package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler {
	ReadArticleService ReadSvc = new ReadArticleService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int article_no = Integer.parseInt(noVal);
		
		try {
			ArticleData articleData = ReadSvc.getArticle(article_no, true);
			req.setAttribute("articleData", articleData);
			return "readArticle";
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
