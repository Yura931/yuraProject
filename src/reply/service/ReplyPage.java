package reply.service;

import java.util.List;

import reply.model.Reply;

public class ReplyPage {
	private int total;
	private int currentPage;
	private List<Reply> reply;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ReplyPage(int total, int currentPage,
			int size, List<Reply> reply) {
		this.total = total;
		this.currentPage = currentPage;
		this.reply = reply;
		
		if (total != 0) {
			this.totalPages = total / size;
			if (total % size > 0) {
				this.totalPages++;
			}
			
			this.startPage = (currentPage - 1) / 5 * 5 + 1;
			this.endPage = Math.min(startPage + 4, totalPages);
		}
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Reply> getReply() {
		return reply;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

}
