package com.example.demolib1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignOutController {
	@RequestMapping("/signout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession sess=request.getSession();
		sess.setAttribute("user","");
		mav.addObject("message", "Sign Out Successfully");
		mav.setViewName("index.jsp");
		return mav;
	}

}
