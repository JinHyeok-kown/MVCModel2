package kr.co.psw.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.psw.BoardVO;
import kr.co.psw.controller.ForwardAction;
import kr.co.psw.service.BoardDAO;

public class InsertPageAction extends Action {
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction forward = new ForwardAction();
		forward.setPath("template.jsp");

		int btype = Integer.parseInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));

		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.boardDetail(btype, bid);

		request.setAttribute("btype", btype);
		request.setAttribute("bid", bid);
		request.setAttribute("vo", vo);
		request.setAttribute("template", "insertPage");

		return forward;
	}
}