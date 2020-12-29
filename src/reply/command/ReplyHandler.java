package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import reply.service.ReplyListService;
import reply.service.ReplyPage;
import reply.service.ReplyService;
import user.service.User;

public class ReplyHandler implements CommandHandler {
	private ReplyService replySvc = new ReplyService();
	private ReplyListService listSvc = new ReplyListService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int articleNo = Integer.parseInt(noVal);
		String pageNoVal = req.getParameter("pageNo");
		
		int pageNo = 1;
		
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		String userId = user.getId();
		String body = req.getParameter("body");
		replySvc.add(userId, articleNo, body);
		
		ReplyPage replyList = listSvc.getReplyList(articleNo, pageNo);
		
		req.setAttribute("replyList", replyList);
		
		res.sendRedirect(req.getContextPath() + "/article/read.do?no=" + articleNo);
		return null;
	}
}
