package com.example.demolib1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	BookServises b=new BookServises();
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();
		String[][] messages = b.get();
		mav.addObject("messageList", messages);
	    mav.setViewName("home.jsp");
	    return mav;
	}
	@PostMapping("/addbook")
	public ModelAndView addbook(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();
		HttpSession sess=request.getSession();
		String book=request.getParameter("book");
		String email=(String)sess.getAttribute("user");
		if(email==null||email=="") {
			mav.addObject("message", "login");
			mav.setViewName("index.jsp");
			return mav;
		}
		int t=b.setemail(email,book);
		if(t==1) {
			mav.addObject("message", "book added");
		}
		else if(t==2){
			mav.addObject("message", "book already exists");
		}
		else{
			mav.addObject("message", "error try again");
		}
		String[][] messages = b.get();
		mav.addObject("messageList", messages);
	    mav.setViewName("home.jsp");
	    return mav;
	}

}
