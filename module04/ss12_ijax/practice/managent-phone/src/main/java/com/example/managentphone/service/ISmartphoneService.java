package com.example.managentphone.service;

import com.example.managentphone.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();
    Optional<Smartphone> findById(Long id);
    Smartphone save(Smartphone smartphone);
    void remove(Long id);
    Smartphone update(Long id,Smartphone smartphone);

}
