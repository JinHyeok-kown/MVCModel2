package kr.co.psw.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.psw.controller.ForwardAction;
import kr.co.psw.service.BoardDAO;

public class BoardDeleteAction extends Action {
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction forward = new ForwardAction();
		forward.setPath("boardList.bo?btype=" + request.getParameter("btype"));
		forward.setIsRedirect(true);

		int btype = Integer.parseInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));

		BoardDAO dao = BoardDAO.getInstance();
		dao.boardDelete(btype, bid);
		return forward;
	}
}
