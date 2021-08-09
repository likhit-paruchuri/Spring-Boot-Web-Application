package com.example.demolib1;

import org.springframework.stereotype.Component;

@Component
public class BookCount {
	    private String bookname;
	    private Long total;
	    
	    public BookCount()
	    {
	    	
	    }
	    public BookCount(String bookname, Long total) {
	        this.bookname = bookname;
	        this.total = total;
	    }

		public String getBookname() {
			return bookname;
		}

		public void setBookname(String bookname) {
			this.bookname = bookname;
		}

		public Long getTotal() {
			return total;
		}

		public void setTotal(Long total) {
			this.total = total;
		}
	    
	
}
