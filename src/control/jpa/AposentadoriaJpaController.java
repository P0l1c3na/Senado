/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.jpa;

import control.jpa.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Aposentadoria;

/**
 *
 * @author muril
 */
public class AposentadoriaJpaController implements Serializable {

    public AposentadoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aposentadoria aposentadoria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aposentadoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aposentadoria aposentadoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aposentadoria = em.merge(aposentadoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = aposentadoria.getId();
                if (findAposentadoria(id) == null) {
                    throw new NonexistentEntityException("The aposentadoria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aposentadoria aposentadoria;
            try {
                aposentadoria = em.getReference(Aposentadoria.class, id);
                aposentadoria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aposentadoria with id " + id + " no longer exists.", enfe);
            }
            em.remove(aposentadoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aposentadoria> findAposentadoriaEntities() {
        return findAposentadoriaEntities(true, -1, -1);
    }

    public List<Aposentadoria> findAposentadoriaEntities(int maxResults, int firstResult) {
        return findAposentadoriaEntities(false, maxResults, firstResult);
    }

    private List<Aposentadoria> findAposentadoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aposentadoria.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Aposentadoria findAposentadoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aposentadoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getAposentadoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aposentadoria> rt = cq.from(Aposentadoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
