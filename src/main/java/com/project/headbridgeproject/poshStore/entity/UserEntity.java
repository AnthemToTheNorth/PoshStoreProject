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
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Column(name = "firstName", nullable = false)
    public String firstName ;
    @Column(name = "lastName", nullable = false)
    public String lastName ;
    @Column(name = "email", nullable = false)
    public String email ;
    @Column(name = "phoneNumber", nullable = false)
    public String phoneNumber ;
    @Column(name = "password", nullable = false)
    public String password ;

    /*@Column(name = "createdWhen", nullable = false)
    private LocalDate createdWhen;
    @Column(name = "createdBy", nullable = false)
    private String createBy;
    + updateWhen
    + updateBy
    */


    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public List<UserRoleEntity> roleId;

    @OneToMany(mappedBy = "user")
    public List<UsersReviewEntity> reviews;

    @OneToMany(mappedBy = "order")
    public List<OrderEntity> order;


    //one2many?
    /*@ManyToMany
    @JoinTable(
            name = "users_reviews_goods",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    public List<UsersReviewEntity> reviews;*/
}


