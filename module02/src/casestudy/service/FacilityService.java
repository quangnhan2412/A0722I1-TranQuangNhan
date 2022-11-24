package casestudy.service;

import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;

public interface FacilityService extends Service {

    void addNewFacility();

    void displayList();

    void addNewVilla();

    Villa validateInfoVilla();

    void addNewRoom();

    Room validateInfoRoom();

    void addNewHouse();

    House validateInfoHouse();

    void displayListUsed();
}
