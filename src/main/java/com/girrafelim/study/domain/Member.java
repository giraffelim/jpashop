package com.girrafelim.study.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    // 컬럼명 지정
    @Column(name = "member_id")
    private Long id;

    private String name;

    // 내장 타입을 포함했다는 어노테이션
    @Embedded
    private Address address;

    // order 엔티티에 있는 member 필드로 매핑이 된다 (연관관계의 주인이 아님).
    @OneToMany(mappedBy = "member") // 하나의 회원이 여러 주문을 갖게 됨, 1 : N 관계
    private List<Order> orders = new ArrayList<>();

}
