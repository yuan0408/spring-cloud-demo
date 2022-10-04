package com.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    int bid;
    String title;
    String desc;
}
