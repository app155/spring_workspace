package com.globalin.biz.board;

import java.util.List;

import com.globalin.biz.board.impl.BoardDAO;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis");
		vo.setWriter("홍");
		vo.setContent("myBatis 테스트");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("==> " +  board.toString());
		}
	}
}
