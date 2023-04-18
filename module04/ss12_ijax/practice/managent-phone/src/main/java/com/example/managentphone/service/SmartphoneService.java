package com.example.managentphone.service;

import com.example.managentphone.model.Smartphone;

import com.example.managentphone.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }
    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }

    @Override
    public Smartphone update(Long id, Smartphone smartphone) {
        Smartphone fromDb=smartphoneRepository.findById(id).orElse(null);
        if(fromDb == null){
            return null;
        }
        fromDb.setId(smartphone.getId());
        fromDb.setModel(smartphone.getModel());
        fromDb.setPrice(smartphone.getPrice());
        fromDb.setProducer(smartphone.getProducer());
        return smartphoneRepository.save(fromDb);
    }


}
