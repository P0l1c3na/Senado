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
import model.Contratos;

/**
 *
 * @author muril
 */
public class ContratosJpaController implements Serializable {

    public ContratosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contratos contratos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contratos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContratos(contratos.getNumerocontratos()) != null) {
                throw new PreexistingEntityException("Contratos " + contratos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contratos contratos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            contratos = em.merge(contratos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contratos.getNumerocontratos();
                if (findContratos(id) == null) {
                    throw new NonexistentEntityException("The contratos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contratos contratos;
            try {
                contratos = em.getReference(Contratos.class, id);
                contratos.getNumerocontratos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contratos with id " + id + " no longer exists.", enfe);
            }
            em.remove(contratos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contratos> findContratosEntities() {
        return findContratosEntities(true, -1, -1);
    }

    public List<Contratos> findContratosEntities(int maxResults, int firstResult) {
        return findContratosEntities(false, maxResults, firstResult);
    }

    private List<Contratos> findContratosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contratos.class));
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

    public Contratos findContratos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contratos.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contratos> rt = cq.from(Contratos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
