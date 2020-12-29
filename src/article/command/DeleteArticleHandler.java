package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.DeleteArticleService;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;
import user.service.User;

public class DeleteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "deleteArticleForm";
	
	ReadArticleService readSvc = new ReadArticleService();
	DeleteArticleService deleteSvc = new DeleteArticleService();
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
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		String password = req.getParameter("password");
		
		User user = (User) req.getSession().getAttribute("user");
		ArticleData articleData = readSvc.getArticle(no, false);
		
		
		if (!user.getId().equals(articleData.getArticle().getWriter().getId())) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		try {
		deleteSvc.delArticle(no, user, password);
		res.sendRedirect(req.getContextPath() + "/article/list.do");
		return null;	
	} catch (PermissionDeniedException e) {
		errors.put("invalidePassword", true);
		return FORM_VIEW;
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
		
	}
	
}
	
	
	
	
	
	
	
	
	