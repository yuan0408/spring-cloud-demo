package com.example.service.Impl;

import com.example.entity.Book;
import com.example.entity.Borrow;
import com.example.entity.User;
import com.example.entity.UserBorrowDetail;
import com.example.mapper.BorrowMapper;
import com.example.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        RestTemplate template = new RestTemplate();
        User user = template.getForObject("http://localhost:8101/user/" + uid, User.class);
        List<Book> bookList = borrow
                .stream()
                .map(b-> template.getForObject("http://localhost:8301/book/"+b.getBid(),Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user,bookList);
    }
}
