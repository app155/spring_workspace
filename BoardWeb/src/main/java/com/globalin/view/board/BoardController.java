package com.globalin.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 작성 처리");

		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		System.out.println("번호: " + vo.getSeq());
		System.out.println("제목: " + vo.getTitle());
		System.out.println("작성자: " + vo.getWriter());
		System.out.println("내용: " + vo.getContent());
		System.out.println("등록일: " + vo.getRegDate());
		System.out.println("조회수: " + vo.getCnt());

		boardDAO.updateBoard(vo);

		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	// 글 상세
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세보기 처리");
		
		model.addAttribute("board", boardDAO.getBoard(vo)); // 모델 정보 저장
		
		return "getBoard.jsp"; // view 이름 리턴
	}
	
	// 글 목록
	/*	@RequestParam
	 * 		value : 화면으로부터 전달된 파라미터명
	 * 		defaultValue : 화면으로부터 전달된 파라미터 정보가 없을 경우 설정된 기본값
	 * 		required : 파라미터 생략 불가능 여부
	 */
	/*
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition, 
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록보기 처리");
		System.out.println("검색조건: " + condition);
		System.out.println("검색단어: " + keyword);
		//model.addAttribute("boardList", boardDAO.getBoardList(vo)); // 모델 정보 저장
		
		return "getBoardList.jsp";
	}
	*/
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록보기 처리");
		
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); // 모델 정보 저장
		
		return "getBoardList.jsp";
	}
	
}
