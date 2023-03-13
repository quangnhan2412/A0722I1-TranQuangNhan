package org.example.service;


import org.example.model.Email;

import java.util.List;

public interface IMailElectronicService {
    List<Email> showAll();

    public Email findById(int id) ;
    void update(Email email);
}
