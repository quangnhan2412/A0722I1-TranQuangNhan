package com.example.tryhardmd4.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "danhmuc_id")

    private Integer id;

    @Column(name = "name_danhmuc")
    private String danhMucName;
    @OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TinTuc> tinTucs;
}
