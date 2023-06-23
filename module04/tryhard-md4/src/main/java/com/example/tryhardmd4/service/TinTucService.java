package com.example.tryhardmd4.service;


import com.example.tryhardmd4.entity.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TinTucService {
    Optional<TinTuc> findById(Integer id);
    void save(TinTuc employee);
    Page<TinTuc> findAll(Pageable pageable);
    void remove(Integer id);
    void deleteByAllId(Integer[] ids);
//    Page<TinTuc> searchAll(String key, Pageable pageable);
    List<TinTuc>searchAll(String key);
    List<TinTuc>searchKet(String key,String key2);

}
