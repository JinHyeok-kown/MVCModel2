package kr.co.psw.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.psw.BoardVO;
import kr.co.psw.controller.ForwardAction;
import kr.co.psw.service.BoardDAO;

public class BoardListAction extends Action {
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction forward = new ForwardAction();
		forward.setPath("template.jsp");

		String strBtype = request.getParameter("btype");
		String strPage = request.getParameter("page");
		int btype = 1;
		int page = 1;

		if (strBtype != null) {
			btype = Integer.parseInt(strBtype);
		}
		if (strPage != null) {
			page = Integer.parseInt(strPage);
		}

		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardVO> list = dao.boardList(btype, page);
		int cnt = dao.pageCnt(btype);

		request.setAttribute("list", list);
		request.setAttribute("cnt", cnt);
		request.setAttribute("btype", btype);
		request.setAttribute("template", "boardList");

		return forward;
	}
}
