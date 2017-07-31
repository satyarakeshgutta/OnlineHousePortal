package io.egen.repository;

import io.egen.entity.Alerts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertsRepoImpl implements AlertsRepo{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(List<Alerts> alerts) {
           if(alerts.size()>0){
            for(Alerts a: alerts){
                em.persist(a);
             }
           }
    }

    @Override
    public List<Alerts> findAlerts(){
        TypedQuery<Alerts> query = em.createNamedQuery("Alerts.findAll", Alerts.class);
        List<Alerts> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public List<Alerts> findAlertsbyId(String pid) {
        TypedQuery<Alerts> query = em.createNamedQuery("Alerts.findById", Alerts.class);
        query.setParameter("person_id", pid);
        List<Alerts> resultList = query.getResultList();
        if (resultList != null ) {
            return resultList;
        } else {
            return null;
        }
    }
}
