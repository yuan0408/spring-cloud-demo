package com.example.service.Impl;

import com.example.entity.Book;
import com.example.entity.Borrow;
import com.example.entity.User;
import com.example.entity.UserBorrowDetail;
import com.example.mapper.BorrowMapper;
import com.example.service.BorrowService;
import com.example.service.client.BookClient;
import com.example.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        User user = userClient.getUserById(uid);
        List<Book> bookList = borrow
                .stream()
                .map(b-> bookClient.getBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user,bookList);
    }
}
