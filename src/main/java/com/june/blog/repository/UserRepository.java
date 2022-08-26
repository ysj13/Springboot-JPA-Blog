package com.june.blog.repository;

import com.june.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO 역할과 비슷
// 자동으로 bean 등록된다
@Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
