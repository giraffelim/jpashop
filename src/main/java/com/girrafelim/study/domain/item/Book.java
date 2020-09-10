package com.girrafelim.study.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 구분값
@Getter
@Setter
public class Book extends Item {

    private String author;

    private String isbn;

//    @Builder
//    public Book(String name, int price, int stockQuantity, String author, String isbn) {
//        super.setName(name);
//        super.setPrice(price);
//        this.setStockQuantity(stockQuantity);
//        this.author = author;
//        this.isbn = isbn;
//    }
//
//
//    public Book() {
//
//    }

}
