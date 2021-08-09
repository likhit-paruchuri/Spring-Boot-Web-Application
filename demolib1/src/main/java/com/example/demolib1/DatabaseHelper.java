package com.example.demolib1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseHelper extends JpaRepository<User,Integer> {
	List<User> findByEmail(String name);
	User save(User a);

}
