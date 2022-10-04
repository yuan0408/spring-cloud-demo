package com.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    int uid;
    String name;
    String sex;
}
