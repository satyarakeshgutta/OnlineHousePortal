package io.egen.service;

import io.egen.entity.Person;

import java.util.List;

public interface PersonService {


    void createOrUpdate(List<Person> person);
    List<Person> findAll();
    Person findOne(String pId);
    void delete(String pId);

    //void update_vehicle_db(List<Vehicle> vehicle);
    //void create_vehicle_db(List<Vehicle> vehicle);

    /*
    List<Vehicle> findAll();
    Vehicle findOne(String id);
   Vehicle update(String id, Vehicle vehicle);
    void delete(String id);
    */
}
