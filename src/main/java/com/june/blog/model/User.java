package com.june.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySql 테이블에 생성됨
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100) // 비밀번호를 해시화 해서 저장해야 하기 때문에 자리수를 길게 설정
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role;    // Enum 을 쓰는게 좋음

    @CreationTimestamp
    private Timestamp createDate;



}
