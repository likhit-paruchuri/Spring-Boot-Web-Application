package com.example.demolib1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class UserServices {
	@Autowired
	DatabaseHelper dbHelper;
	private List<User> a;
	public int login(User u) {
		a=dbHelper.findByEmail(u.getEmail());
		if (a!=null && a.size()>0) 
		{
			User t = a.get(0);
		if(u.getEmail().equals(t.getEmail())&&u.getPassword().equals(t.getPassword())) {
			return(0);
	         }
		else {
			return(1);
			}
		}
		else {
			return(1);
			}
	}
	
	public int signup(User u) {
		a=dbHelper.findByEmail(u.getEmail());
		System.out.println(a);
		if (a==null || a.size()==0) {
		User t=dbHelper.save(u);
		if(t==null) {
		return(1);}
		else {
			return(0);
		}}
		else {
			return(2);
		}
	}
	

}
