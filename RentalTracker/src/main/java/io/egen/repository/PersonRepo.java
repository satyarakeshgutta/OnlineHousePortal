package io.egen.repository;

import io.egen.entity.Person;
import java.util.List;

public interface PersonRepo {

    void create(List<Person> person);
    void update(List<Person> person);
    List<Person> findAll();
    Person findbyPid (String Pid);
    List<Person> findbyRent(double rent);
}
