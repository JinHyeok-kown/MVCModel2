package kr.co.psw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.psw.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public ArrayList<BoardVO> boardList(int btype, int page) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select * from (select p.*, row_number() over(order by bid desc) as rnum from p_board p where p.btype = ?) where rnum between ? and ? ";
		try {
			conn = DBConnector.getConn();
			//dkjdl;dj
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, (page - 1) * 15 + 1);
			ps.setInt(3, page * 15);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBtype(rs.getInt("btype"));
				vo.setBid(rs.getInt("bid"));
				vo.setBtitle(rs.getString("btitle"));
				vo.setBregdate(rs.getString("bregdate"));
				result.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(rs, ps, conn);
		}
		return result;
	}

	public int pageCnt(int btype) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select ceil(count(bid)/15) as cnt from p_board where btype = ? ";
		try {
			conn = DBConnector.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(rs, ps, conn);
		}
		return result;
	}

	public int insertBoard(int btype, String btitle, String bcontent) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = " insert into p_board (pk, btype, bid, btitle, bcontent) values ((SELECT nvl(MAX(pk), 0) + 1 FROM p_board), ?, (SELECT nvl(MAX(bid), 0) + 1 FROM p_board where btype= ?), ?, ?) ";
		try {
			conn = DBConnector.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, btype);
			ps.setString(3, btitle);
			ps.setString(4, bcontent);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(null, ps, conn);
		}
		return result;
	}

	public BoardVO boardDetail(int btype, int bid) {
		BoardVO result = new BoardVO();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select bid, btitle, bcontent, bregdate from p_board where btype=? and bid = ? ";
		try {
			conn = DBConnector.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, bid);
			rs = ps.executeQuery();

			while (rs.next()) {
				result.setBid(rs.getInt("bid"));
				result.setBtitle(rs.getString("btitle"));
				result.setBcontent(rs.getString("bcontent"));
				result.setBregdate(rs.getString("bregdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(rs, ps, conn);
		}
		return result;
	}

	public void boardDelete(int btype, int bid) {
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = " delete from p_board where btype = ? and bid = ? ";
		try {
			conn = DBConnector.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, bid);
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(null, ps, conn);
		}
	}

	public int boardUpdate(int btype, int bid, String btitle, String bcontent) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = " update p_board set btitle = ?, bcontent = ?, bregdate = sysdate where btype = ? and bid = ? ";
		try {
			conn = DBConnector.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, btype);
			ps.setInt(4, bid);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(null, ps, conn);
		}
		return result;
	}

}
