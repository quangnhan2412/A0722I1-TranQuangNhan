package com.example.tryhardmd4.repository;

import com.example.tryhardmd4.entity.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TinTucRepository extends JpaRepository<TinTuc, Integer> {
    void deleteAllByIdIn(Integer[] idx);
//    Page<TinTuc>findAllByNameContainingOrSalaryOrAddressContaining(String name, Double salary, String address, Pageable pageable);
    List<TinTuc>findAllByDanhMucDanhMucNameOrTieuDeContaining(String danhMuc,String tieuDe);
    List<TinTuc>findAllByDanhMucDanhMucNameAndTieuDeContaining(String danhMuc1,String tieuDe1);

}
