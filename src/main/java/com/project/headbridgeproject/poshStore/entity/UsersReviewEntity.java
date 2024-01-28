package com.project.headbridgeproject.poshStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class UsersReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "description", nullable = false)
    public String description;

    @OneToOne //???
    @JoinColumn(name = "goods_id")
    public ProductGoodsEntity goods;
// один обзор на один товар

    //many2one
    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user;

    //public List<UserEntity> users;
    // много пользователей, много обзоров ??
}
