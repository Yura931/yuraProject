package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Member;
import member.service.DeleteMemberService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;
import user.service.User;

public class DeleteMemberHandler implements CommandHandler {
	private static final String FORM_VIEW = "deleteMemberForm";
	DeleteMemberService deleteMemberSvc = new DeleteMemberService();

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String password = req.getParameter("password");
		
		Map<String, Boolean> errors = new HashMap<>();
		Member member = new Member();
		
		if (password == null || password.isEmpty()) {
			errors.put("password", true);
			return FORM_VIEW;
		}
		
		if (!member.matchPassword(password)) {
			errors.put("notMatchPw", true);
		}
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		try {
		deleteMemberSvc.deleteMember(user, password);
		session.invalidate();
		
		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return null;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		} catch (InvalidPasswordException e) {			
		errors.put("invalidPassword", true);
		return FORM_VIEW;
		}
	}

}























