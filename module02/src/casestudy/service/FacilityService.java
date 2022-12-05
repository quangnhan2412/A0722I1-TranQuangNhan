package casestudy.service;

import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;

import java.io.IOException;

public interface FacilityService extends Service {

    void addNewFacility() throws IOException;

    void displayList() throws IOException;

    void addNewVilla() throws IOException;

    Villa validateInfoVilla();

    void addNewRoom() throws IOException;

    Room validateInfoRoom();

    void addNewHouse() throws IOException;

    House validateInfoHouse();

    void displayListUsed();
}
