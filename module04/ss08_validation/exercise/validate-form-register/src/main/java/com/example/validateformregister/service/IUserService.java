package com.example.validateformregister.service;

import com.example.validateformregister.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IUserService {
    void create(User user);

    void update(User user);

    void delete(Long id);

    List<User> findAll();

    User findById(Long id);

    Page<User> findAllWithPaging(Pageable pageable);

    public Slice<User> findAllWithSlice(Pageable pageable);
}
