package user.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import mvc.command.CommandHandler;
import user.service.FindIdService;
import user.service.FindInfo;

public class FindIdHandler implements CommandHandler {
	private static final String FORM_VIEW = "findId";
	FindIdService findIdSvc = new FindIdService();

	
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
		
		find.setName(req.getParameter("name"));
		find.setEmail(req.getParameter("email"));		
		req.setAttribute("find", find);
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if (find.getEmail() == null || find.getEmail().isEmpty()) {
			errors.put("email", true);
		}
		
		if (find.getName() == null || find.getName().isEmpty()) {
			errors.put("name", true);
		}
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
		Member findId = findIdSvc.find(find.getName(), find.getEmail());
		req.setAttribute("findId", findId);
		return "findIdSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
