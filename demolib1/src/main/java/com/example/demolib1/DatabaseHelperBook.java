package com.example.demolib1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DatabaseHelperBook extends JpaRepository<Book,Integer>{
	List<Book> findByEmail(String name);
	@Query("select new com.example.demolib1.BookCount(bookname,count(bookid)) from Book where email IS NULL group by bookname order by bookname")
	List<BookCount> getbooks();
	@Query("select new com.example.demolib1.Book(bookid,email,bookname) from Book where email = ?1 and bookname = ?2")
	List<Book> checkemailbook(String email, String bookname);
	@Query("select new com.example.demolib1.Book(bookid,email,bookname) from Book where email IS NULL and bookname = ?1")
	List<Book> getemailbook(String bookname);
	Book save(Book b);
	@Transactional
	@Modifying
	@Query("update Book set email = ?2 where bookid = ?1")
	int setemailbook(int id,String eamil);
	@Transactional
	@Modifying
	@Query("update Book set email=NULL where email = ?1 and bookname = ?2")
	int deletebyemailbook(String email, String book);
}
