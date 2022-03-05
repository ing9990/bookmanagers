package com.fastcampus.jpa.bookmanager.controller;

import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final BookRepository bookRepository;



    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
