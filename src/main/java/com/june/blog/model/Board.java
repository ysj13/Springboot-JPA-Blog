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
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob    // 대용량 데이터
    private String content;

    @ColumnDefault("0")
    private int count;

    @ManyToOne  // Many = Board, User = One
    @JoinColumn(name = "userid")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;







}
