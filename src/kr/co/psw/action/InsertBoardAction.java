package kr.co.psw.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.psw.controller.ForwardAction;
import kr.co.psw.service.BoardDAO;

public class InsertBoardAction extends Action {
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction forward = new ForwardAction();
		forward.setPath("boardList.bo?btype=" + request.getParameter("btype"));
		forward.setIsRedirect(true);

		BoardDAO dao = BoardDAO.getInstance();
		int btype = Integer.parseInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");

		if (request.getParameter("bid").equals("0")) {
			dao.insertBoard(btype, btitle, bcontent);
		} else {
			dao.boardUpdate(btype, bid, btitle, bcontent);
			forward.setPath("boardDetail.bo?btype=" + btype + "&bid=" + bid);
		}

		return forward;
	}
}
