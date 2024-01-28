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
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "firstName", nullable = false)
    private String firstName ;
    @Column(name = "lastName", nullable = false)
    private String lastName ;
    @Column(name = "email", nullable = false)
    private String email ;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber ;
    @Column(name = "password", nullable = false)
    private String password ;

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

    @OneToMany(mappedBy = "order_id")
    public List<OrderEntity> order;

    @OneToOne(mappedBy = "userId")
    public CartOfOrderEntity cartOfOrderEntity;

}


