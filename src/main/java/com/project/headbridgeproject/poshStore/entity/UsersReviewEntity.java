package com.project.headbridgeproject.poshStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_reviews")
public class UsersReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "goods_id")
    private ProductGoodsEntity goods;

    /*@ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity users;*/

    @ManyToMany
    @JoinTable(
            name = "users_reviews_users",
            joinColumns = @JoinColumn(name = "users_review_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> users;
}
