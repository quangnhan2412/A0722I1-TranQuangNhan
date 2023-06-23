package com.example.validateformregister.service;

import com.example.validateformregister.model.User;
import com.example.validateformregister.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private IUserRepository iUserRepository;

    @Autowired
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void create(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void update(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return iUserRepository.findById(id).orElse(null);
    }

    @Override
    public Page<User> findAllWithPaging(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public Slice<User> findAllWithSlice(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }
}
