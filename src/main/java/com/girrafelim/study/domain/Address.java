package com.girrafelim.study.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;

// Value Class
/* @Embeddable 애노테이션은 설정한 클래스가 다른 엔티티의 일부로 저장될 수 있음을 설정하는 애노테이션입니다. */
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    @Builder
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    protected Address() {

    }

}
