package io.egen.service;

import io.egen.entity.Person;
import io.egen.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    @Transactional
    public void createOrUpdate(List<Person> person) {
        List<Person> updatePersonList = new ArrayList<>();
        List<Person> createPersonList = new ArrayList<>();
        int l = person.size();

        for (Person p : person) {
            String pId = p.getpId();
            Person existing = personRepo.findbyPid(pId);
            if (existing != null) {
                updatePersonList.add(p);
            }
            else createPersonList.add(p);
        }

        if (createPersonList.size() > 0 && createPersonList.size() < l) {
            personRepo.create(createPersonList);
            personRepo.update(updatePersonList);
        }
        if (createPersonList.size() == 0) {
            personRepo.update(updatePersonList);
        }
        if (createPersonList.size() == l) {
            personRepo.create(createPersonList);
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> personsFound = personRepo.findAll();
        return personsFound;
    }

    @Override
    public Person findOne(String pId) {
        Person v = personRepo.findbyPid(pId);
        return v;
    }

    @Override
    public void delete(String pId) {

    }

}
