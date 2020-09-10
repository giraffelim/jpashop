package com.girrafelim.study.controller;

import com.girrafelim.study.domain.item.Book;
import com.girrafelim.study.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm form) {

        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(book.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

//        Book book = new Book().builder()
//                .name(form.getName())
//                .price(form.getPrice())
//                .stockQuantity(form.getStockQuantity())
//                .author(form.getAuthor())
//                .isbn(form.getIsbn())
//                .build();

        itemService.save(book);
        return "redirect:/items";

    }

}
