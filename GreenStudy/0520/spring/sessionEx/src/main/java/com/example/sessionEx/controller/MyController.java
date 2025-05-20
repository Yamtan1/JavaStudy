package com.example.sessionEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.sessionEx.SessionExApplication;
import com.example.sessionEx.dao.IUserDAO;
import com.example.sessionEx.dto.UserDTO;
import com.example.sessionEx.session.UserSession;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

    private final SessionExApplication sessionExApplication;
	
	@Autowired
	IUserDAO userdao;
	UserSession userSession = new UserSession();

    MyController(SessionExApplication sessionExApplication) {
        this.sessionExApplication = sessionExApplication;
    }
	
	public void MyController(IUserDAO dao) {
		userdao = dao;
	}

	@RequestMapping("/")
	public String root() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/loginForm")
	public String loginForm(@RequestParam("id") String id, @RequestParam("pw")String pw, HttpSession session, RedirectAttributes rttr, HttpServletResponse response) {
		UserDTO user = userdao.selectUser(id, pw);
		if(user != null) {
			userSession.login(user);
			Cookie cookie = new Cookie("loginId", id);
			cookie.setPath("/");
			response.addCookie(cookie);
			return "redirect:/success";
		}
		else {
			rttr.addFlashAttribute("error", "로그인 정보가 일치하지 않습니다");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/success")
	public String success(RedirectAttributes rttr, Model model, HttpServletRequest request) {
		boolean result = userSession.isLogedin();
		if (!result) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("loginId")) {
						String loginId = cookie.getValue();

						// 쿠키에서 ID 읽어와서 DB 조회
						UserDTO user = userdao.selectUserById(loginId);
						if (user != null) {
							userSession.login(user);
							model.addAttribute("user", user);
							return "success";
						}
					}
				}
			}
			// 쿠키에도 로그인 정보 없으면 로그인 페이지로
			rttr.addFlashAttribute("msg2", "로그인 정보가 없습니다");
			return "redirect:/login";
		}
		// 세션이 있는 경우
		model.addAttribute("user", userSession.getLoginUser());
		return "success";
	}
	@GetMapping("/logout")
	public String logout(RedirectAttributes rttr,  HttpSession session, HttpServletResponse response) {
		//session.invalidate();
		userSession.logout();
		Cookie cookie = new Cookie("loginId", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		rttr.addFlashAttribute("msg", "방금 로그아웃 했습니다.");
		return "redirect:/login";
	}
	
	@GetMapping("/set-cookie")
	public @ResponseBody String setCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("myCookie", "sogood");
		cookie.setPath("/");
		response.addCookie(cookie);
		return "cookie set";
	}
	@GetMapping("/read-cookie")
	public @ResponseBody String readCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("myCookie")) {
					System.out.println(cookie.getName());
					System.out.println(cookie.getValue());
				}
			}
		}
		return "cookie read";
	}
	@GetMapping("/cookieMain")
	public String cookieMain() {
		return "cookieMain";
	}
	@GetMapping("/cookieResult")
	public String cookieResult() {
		return "cookieResult";
	}
	
	@GetMapping("/popupMain")
	public String popupMain() {
		return "popupMain";
	}
	@GetMapping("/popupCookie")
	public @ResponseBody String popupCookie(HttpServletResponse response,
											HttpServletRequest request) {
		String chkVal = request.getParameter("inactiveToday");
		//System.out.println("popupCookie : " + chkVal);
		if(chkVal != null && chkVal.equals("1")) {
			Cookie cookie = new Cookie("PopupClose", "off");
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
		return "쿠키 : 하루 동안 열지 않음";
	}
}
