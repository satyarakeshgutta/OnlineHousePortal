package io.egen.repository;

import io.egen.entity.Listings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ListingsRepoImpl implements ListingsRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Listings listings) {
            em.persist(listings);
    }

    @Override
    public List<Listings> getAllListings() {
        TypedQuery<Listings> query = em.createNamedQuery("Listings.findAll", Listings.class);
        List<Listings> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public List<Listings> getListingsById(String pId) {
        TypedQuery<Listings> query = em.createNamedQuery("Listings.findById", Listings.class);
        query.setParameter("person_id", pId);
        List<Listings> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }

    public Listings findbyVin(String Vin) {
        TypedQuery<Listings> query = em.createNamedQuery("Listings.findById", Listings.class);
        query.setParameter("person_id", Vin);
        List<Listings> resultList = query.getResultList();
        int l=resultList.size();
        if (resultList != null && l>=1) {
            return resultList.get(l-1);
        } else {
            return null;
        }
    }
}
