package com.globalin.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록보기 처리");
		
		// 1. 사용자 정보 추출(검색)
		
		// 2. DB연동
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 세션에 로그인 정보를 저장하고 목록화면으로 이동
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // 모델 정보 저장
		mav.setViewName("getBoardList.jsp"); // 뷰 정보 저장
		
		return mav;
	}

}
