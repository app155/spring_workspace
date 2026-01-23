package com.globalin.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping(value = "/login.do", method = RequestMethod.GET) // Get
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST) // Post
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 인증 처리");
		
		UserVO user = userDAO.getUser(vo);
		
		if (user != null) {
			session.setAttribute("username", user.getName());
			return "getBoardList.do";
		}
		else {
			return "login.jsp";
		}
	}

}
