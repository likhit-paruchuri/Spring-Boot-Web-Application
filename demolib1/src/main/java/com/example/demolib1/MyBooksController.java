package com.example.demolib1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyBooksController {
	@Autowired
	BookServises b=new BookServises();
	@RequestMapping("/mybooks")
	public ModelAndView mybooks(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();
		HttpSession sess=request.getSession();
		String email=(String)sess.getAttribute("user");
		if(email==null||email=="") {
			mav.addObject("message", "login");
			mav.setViewName("index.jsp");
			return mav;
		}
		String[][] messages = b.getbookswithemail(email);
		mav.addObject("messageList", messages);
		mav.setViewName("mybooks.jsp");
		return mav;
	}
	@RequestMapping("/removemybooks")
	public ModelAndView removebooks(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		HttpSession sess=request.getSession();
		String book=request.getParameter("book");
		String email=(String)sess.getAttribute("user");
		if(email==null||email=="") {
			mav.addObject("message", "login");
			mav.setViewName("index.jsp");
			return mav;
		}
		int t=b.removebookwithemail(email,book);
		String[][] messages = b.getbookswithemail(email);
		if(t==0) {
			mav.addObject("message", "error");
		}
		else {
			mav.addObject("message", "book removed");
		}
		mav.addObject("messageList", messages);
		mav.setViewName("mybooks.jsp");
		return mav;
	}

}
