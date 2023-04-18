package service;


import org.example.model.ContactAddress;
import org.example.model.Symptom;
import org.example.model.UserInf;

public interface IMedicalDeclarationService {
    UserInf findUserInf();
    ContactAddress findContactAddress();
    Symptom findSymptom();
    void save(UserInf  userInf,ContactAddress contactAddress,Symptom symptom);
}
