package com.example.demolib1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
	@Autowired
	UserServices s=new UserServices();
	@PostMapping("/signup")
	public ModelAndView signup(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("pwd") String pass)
	{	ModelAndView mav = new ModelAndView();
		User u=new User();
		u.setEmail(email);
		u.setPassword(pass);
		int t=s.signup(u);
		if(t==0) {
		mav.addObject("message", "Sign Up success");
		mav.setViewName("index.jsp");
		return mav;
		}
		else if(t==1) {
			mav.addObject("message", "error!");
			mav.setViewName("signup.jsp");
			return mav;
		}
		else {
			mav.addObject("message", "email already in use");
			mav.setViewName("signup.jsp");
			return mav;
		}
	}

}
