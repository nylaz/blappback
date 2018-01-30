package service;

import entity.PersistenceEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "DBManager")
public class DBManager {

    @PersistenceContext(name = "dbmanager")
    EntityManager em;

    public void persistService(PersistenceEntity entity){
        em.persist(entity);
        em.flush();
    }

    public List<PersistenceEntity> getEntities() {
        TypedQuery<PersistenceEntity> query = em.createQuery("SELECT e FROM PersistenceEntity e", PersistenceEntity.class);
        if(!query.getResultList().isEmpty()) {
            List<PersistenceEntity> entities = query.getResultList();
            return entities;
        } else {
            List<PersistenceEntity> entities = new ArrayList<>();
            return entities;
        }
    }

    public void deleteEntities() {
        TypedQuery<PersistenceEntity> query = em.createQuery("DELETE FROM PersistenceEntity", PersistenceEntity.class);
        query.executeUpdate();
    }
}
