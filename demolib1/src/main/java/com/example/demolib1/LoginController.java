package com.example.demolib1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {
	@Autowired
	UserServices s=new UserServices();
	@Autowired
	BookServises b=new BookServises();
	@RequestMapping("/")
	public String home()
	{
	
		return"index.jsp";
		
	}
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("pwd") String pass)
	{	User u=new User();
		u.setEmail(email);
		u.setPassword(pass);
		int t=s.login(u);
		ModelAndView mav = new ModelAndView();
		if(t==0) {
			HttpSession sess=request.getSession();
			sess.setAttribute("user",u.getEmail());
			String[][] messages = b.get();
			mav.setViewName("home.jsp");
			mav.addObject("messageList", messages);
		    }
		else {
			mav.setViewName("index.jsp");
			mav.addObject("message", "email or password error");
			}
		return mav;
	}

}
