package com.ziad.SpringSecEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ziad.SpringSecEx.moudle.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>  {

	Users findByUsername(String keyword);
}
