package com.example.tryhardmd4.service.impl;


import com.example.tryhardmd4.entity.TinTuc;
import com.example.tryhardmd4.repository.TinTucRepository;
import com.example.tryhardmd4.service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TinTucServiceImpl implements TinTucService {
    @Autowired
    private TinTucRepository tinTucRepository;

    @Override
    public Optional<TinTuc> findById(Integer id) {
        return Optional.ofNullable(tinTucRepository.findById(id).orElse(null));
    }

    @Override
    public void save(TinTuc employee) {
        tinTucRepository.save(employee);
    }

    @Override
    public Page<TinTuc> findAll(Pageable pageable) {
        return tinTucRepository.findAll(pageable);
    }

    @Override
    public void remove(Integer id) {
tinTucRepository.deleteById(id);
    }

    @Override
    public void deleteByAllId(Integer[] ids) {
tinTucRepository.deleteAllByIdIn(ids);
    }

    @Override
    public List<TinTuc> searchAll(String key) {
        String tieuDe = key;
        String danhMuc = key;
        return tinTucRepository.findAllByDanhMucDanhMucNameOrTieuDeContaining(tieuDe,danhMuc);
    }

    @Override
    public List<TinTuc> searchKet(String key, String key2) {
        return tinTucRepository.findAllByDanhMucDanhMucNameAndTieuDeContaining(key,key2);
    }


}
