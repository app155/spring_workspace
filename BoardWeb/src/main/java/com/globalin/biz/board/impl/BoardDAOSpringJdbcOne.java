package com.globalin.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardVO;

@Repository
public class BoardDAOSpringJdbcOne extends JdbcDaoSupport {
	// SQL 명령어
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_DELETE = "delete from board where seq = ?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	// DB에서 검색
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	// CRUD
	public void insertBoard(BoardVO vo) {
		System.out.println("=> Spring JDBC one: insertBoard()");
		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("=> Spring JDBC one: updateBoard()");
		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("=> Spring JDBC one: deleteBoard()");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("=> Spring JDBC one: getBoard()");
		Object[] args = { vo.getSeq() };
		
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("=> Spring JDBC one: getBoardList()");
		
		Object[] args = { vo.getSearchKeyword() };
		
		if (vo.getSearchCondition().equals("TITLE")) {
			return getJdbcTemplate().query(BOARD_LIST_T, args, new BoardRowMapper());
		}
		else if (vo.getSearchCondition().equals("CONTENT")) {
			return getJdbcTemplate().query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		
		return null;
		// return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
}
