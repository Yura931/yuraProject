package user.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import mvc.command.CommandHandler;
import user.service.FindInfo;
import user.service.FindPasswordService;

public class FindPasswordHandler implements CommandHandler {
	private static final String FORM_VIEW = "findPasswordForm";
	private FindPasswordService findPwdSvc = new FindPasswordService();
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		FindInfo find = new FindInfo();
		find.setId(req.getParameter("id"));
		find.setName(req.getParameter("name"));
		find.setEmail(req.getParameter("email"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if (find.getId() == null || find.getId().isEmpty()) {
			errors.put("id", true);
		}		
		
		try {
		Member findPwd= findPwdSvc.findPwd(find.getId(), find.getName(), find.getEmail());
		req.setAttribute("findPwd", findPwd);
	    return "findPasswordSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
