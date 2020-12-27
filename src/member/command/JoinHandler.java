package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicatedIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "joinForm";
	JoinService joinSvc = new JoinService();
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
		JoinRequest joinReq = new JoinRequest();
		
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		joinReq.setEmail(req.getParameter("email"));
		joinReq.setBirth(req.getParameter("birth"));
		
		req.setAttribute("joinReq", joinReq);
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			joinSvc.join(joinReq);
			return "joinSuccess";
		} catch (DuplicatedIdException e) {
			e.printStackTrace();
			errors.put("duplicated", true);
			return FORM_VIEW;
		}
	}
}



















