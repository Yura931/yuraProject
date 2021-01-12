package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.model.Writer;
import article.service.WriteRequest;
import article.service.WriteService;
import mvc.command.CommandHandler;
import user.service.User;

public class WriteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "writeForm";
	private WriteService writeSvc = new WriteService();
	
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
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newArticleNo = writeSvc.write(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);
		
		
		res.sendRedirect(req.getContextPath() + "/article/list.do");
		return null;	
	}
	
	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest (new Writer(user.getId(),
				user.getName()),
				req.getParameter("title"),
				req.getParameter("content"));
	}
}













