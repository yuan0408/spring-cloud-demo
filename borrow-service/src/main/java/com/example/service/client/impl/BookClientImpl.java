package com.example.service.client.impl;

import com.example.entity.Book;
import com.example.service.client.BookClient;
import org.springframework.stereotype.Component;

@Component
public class BookClientImpl implements BookClient {
    @Override
    public Book findBookById(int bid) {
        return Book.builder()
                .desc("补救对象")
                .build();
    }
}
