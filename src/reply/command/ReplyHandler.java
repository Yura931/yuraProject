package reply.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import mvc.command.CommandHandler;
import reply.model.Reply;
import reply.service.ReplyListService;
import reply.service.ReplyService;
import user.service.User;

public class ReplyHandler implements CommandHandler {
	private ReplyService addService = new ReplyService();
	private ReplyListService listService = new ReplyListService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		
		int articleNo = Integer.parseInt(req.getParameter("no"));
		String userId = user.getId();
		String body = req.getParameter("body");
		addService.add(userId, articleNo, body);
		List<Reply> replyList = listService.getReplyList(articleNo);
		req.setAttribute("replyList", replyList);
		
		return "replyAddSuccess";
	}

}
