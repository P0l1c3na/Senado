/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.jpa;

import control.jpa.exceptions.NonexistentEntityException;
import control.jpa.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Aditivos;
import model.AditivosPK;

/**
 *
 * @author muril
 */
public class AditivosJpaController implements Serializable {

    public AditivosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aditivos aditivos) throws PreexistingEntityException, Exception {
        if (aditivos.getAditivosPK() == null) {
            aditivos.setAditivosPK(new AditivosPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aditivos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAditivos(aditivos.getAditivosPK()) != null) {
                throw new PreexistingEntityException("Aditivos " + aditivos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aditivos aditivos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aditivos = em.merge(aditivos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                AditivosPK id = aditivos.getAditivosPK();
                if (findAditivos(id) == null) {
                    throw new NonexistentEntityException("The aditivos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(AditivosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aditivos aditivos;
            try {
                aditivos = em.getReference(Aditivos.class, id);
                aditivos.getAditivosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aditivos with id " + id + " no longer exists.", enfe);
            }
            em.remove(aditivos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aditivos> findAditivosEntities() {
        return findAditivosEntities(true, -1, -1);
    }

    public List<Aditivos> findAditivosEntities(int maxResults, int firstResult) {
        return findAditivosEntities(false, maxResults, firstResult);
    }

    private List<Aditivos> findAditivosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aditivos.class));
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

    public Aditivos findAditivos(AditivosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aditivos.class, id);
        } finally {
            em.close();
        }
    }

    public int getAditivosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aditivos> rt = cq.from(Aditivos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
