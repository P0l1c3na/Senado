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
import model.Itens;
import model.ItensPK;

/**
 *
 * @author muril
 */
public class ItensJpaController implements Serializable {

    public ItensJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itens itens) throws PreexistingEntityException, Exception {
        if (itens.getItensPK() == null) {
            itens.setItensPK(new ItensPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itens);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItens(itens.getItensPK()) != null) {
                throw new PreexistingEntityException("Itens " + itens + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itens itens) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itens = em.merge(itens);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ItensPK id = itens.getItensPK();
                if (findItens(id) == null) {
                    throw new NonexistentEntityException("The itens with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ItensPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itens itens;
            try {
                itens = em.getReference(Itens.class, id);
                itens.getItensPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itens with id " + id + " no longer exists.", enfe);
            }
            em.remove(itens);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itens> findItensEntities() {
        return findItensEntities(true, -1, -1);
    }

    public List<Itens> findItensEntities(int maxResults, int firstResult) {
        return findItensEntities(false, maxResults, firstResult);
    }

    private List<Itens> findItensEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itens.class));
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

    public Itens findItens(ItensPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itens.class, id);
        } finally {
            em.close();
        }
    }

    public int getItensCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itens> rt = cq.from(Itens.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
