package com.example.tryhardmd4.service.impl;

import com.example.tryhardmd4.entity.DanhMuc;
import com.example.tryhardmd4.repository.DanhMucRepository;
import com.example.tryhardmd4.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DanhMucServiceImpl implements DanhMucService {
@Autowired
private DanhMucRepository danhMucRepository ;
    @Override
    public List<DanhMuc> findAll() {
        return danhMucRepository.findAll();
    }
}
