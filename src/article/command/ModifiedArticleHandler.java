package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ModifiedArticleService;
import article.service.ModifiedData;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;
import user.service.User;

public class ModifiedArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "modifyForm";
	ReadArticleService readSvc = new ReadArticleService();
	ModifiedArticleService modifySvc = new ModifiedArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			return null;
		}
		
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		try {
			
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		ArticleData articleData = readSvc.getArticle(no, false);	
		User user = (User) req.getSession().getAttribute("user");
		
		if (!canModify(user, articleData)) {
			return null;
		}
		
		ModifiedData modifyData = new ModifiedData(user.getId(),
										no, 
										articleData.getArticle().getTitle(),
										articleData.getArticle().getContent());
		req.setAttribute("modifyData", modifyData);
		
		return FORM_VIEW;
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private boolean canModify(User user, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return user.getId().equals(writerId);
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		User user = (User) req.getSession().getAttribute("user");
		
		ModifiedData modifyData = new ModifiedData(user.getId(),
													no,
													req.getParameter("title"),
													req.getParameter("content")
													);
		try {
		modifySvc.modify(modifyData);
		return "modifySuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
