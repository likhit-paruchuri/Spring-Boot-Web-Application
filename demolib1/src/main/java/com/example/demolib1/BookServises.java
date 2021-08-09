package com.example.demolib1;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServises {
	@Autowired
	DatabaseHelperBook dbHelper;
	String[][] str=null;
	List<BookCount> l;
	List<Book> a;
	
	public String[][] get() {
		l=dbHelper.getbooks();
	    str=new String[l.size()][3];
		for (int i = 0; i < l.size(); i++) {
				str[i][0]=String.valueOf(i+1);
				str[i][1]=l.get(i).getBookname().toString();
				str[i][2]=l.get(i).getTotal().toString();
		}
		return(str);
	}

	public int setemail(String email, String book) {
		a=dbHelper.checkemailbook(email, book);
		if(a==null || a.size()<1) {
			a=dbHelper.getemailbook(book);
			if(a==null || a.size()<1) {
				return(3);
			}
			else {
				int id=a.get(0).getBookid();
				System.out.println(id);
				int t=dbHelper.setemailbook(id,email);
				if(t==0) {return(3);}
				else {return(1);}
			}
		}
		else
		{
			return(2);
		}
	}

	

	public String[][] getbookswithemail(String email) {
		a=dbHelper.findByEmail(email);
		if(a!=null) {
		    str=new String[a.size()][2];
			for (int i = 0; i < a.size(); i++) {
					str[i][0]=String.valueOf(i+1);
					str[i][1]=a.get(i).getBookname();
			}}
			return(str);
	}

	public int removebookwithemail(String email, String book) {
		int t=dbHelper.deletebyemailbook(email,book);
		return(t);
	}
}
