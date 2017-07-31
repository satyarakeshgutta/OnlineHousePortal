package io.egen.repository;

import io.egen.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


import io.egen.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepoImpl implements PersonRepo{

    @PersistenceContext
    private EntityManager em1;

    @Override
    public void create(List<Person> person) {
        for (Person p : person) {
            em1.persist(p);
        }
    }

    @Override
    public void update(List<Person> person) {
        for (Person p : person) {
            em1.merge(p);
        }
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = em1.createNamedQuery("Person.findAll", Person.class);
        List<Person> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public Person findbyPid(String Pid) {
        TypedQuery<Person> query = em1.createNamedQuery("Person.findById", Person.class);
        query.setParameter("person_id", Pid);
        List<Person> resultList = query.getResultList();

        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Person> findbyRent(double rent) {
        TypedQuery<Person> query = em1.createNamedQuery("Person.findByRent", Person.class);
        query.setParameter("person_rent", rent);
        List<Person> resultList = query.getResultList();

        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }
}
