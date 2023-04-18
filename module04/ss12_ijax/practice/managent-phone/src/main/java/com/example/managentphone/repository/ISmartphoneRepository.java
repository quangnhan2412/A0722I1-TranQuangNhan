package com.example.managentphone.repository;

import com.example.managentphone.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ISmartphoneRepository extends CrudRepository<Smartphone,Long> {
}
