package user.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import user.service.LoginFailException;
import user.service.LoginService;
import user.service.User;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "loginForm";
	private LoginService loginSvc = new LoginService();
	
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
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if (id == null || id.isEmpty()) {
			errors.put("id", true);
		}
		if (password == null || password.isEmpty()) {
			errors.put("password", true);
		}
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
		HttpSession session = req.getSession();
		User user = loginSvc.login(id, password);
		session.setAttribute("user", user);
		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return null;
		} catch (LoginFailException e) {
			errors.put("infoNotMatch", true);
			return FORM_VIEW;
		}	
	}
}
