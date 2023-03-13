package org.example.service;

import org.example.model.Email;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MailElectronicService implements IMailElectronicService {
    private static Map<Integer, Email> emailMap;


    static {
        emailMap = new HashMap<>();
        emailMap.put(1, new Email(1, "English", 5, true, "King ,Asgard"));
        emailMap.put(2, new Email(2, "VietNam", 25, false, "King ,Asgard2"));
        emailMap.put(3, new Email(3, "Japanese", 50, true, "King ,Asgard3"));
        emailMap.put(4, new Email(4, "English", 100, false, "King ,Asgard4"));
        emailMap.put(5, new Email(5, "Chinese", 15, true, "King ,Asgard5"));

    }

    @Override
    public List<Email> showAll() {
        return new ArrayList<>(emailMap.values());
    }

    @Override
    public Email findById(int id) {
        return emailMap.get(id);
    }


    @Override
    public void update(Email email) {
        if (emailMap.containsKey(email.getIdMail())) {
            emailMap.put(email.getIdMail(), email);
        }
    }
}
