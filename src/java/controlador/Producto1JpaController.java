package controlador;

import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Producto1;

public class Producto1JpaController implements Serializable {

    public Producto1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Producto1JpaController() {
        this.emf = Persistence.createEntityManagerFactory("RegistroProductoPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();

    }

    public void create(Producto1 producto1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(producto1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducto1(producto1.getId()) != null) {
                throw new PreexistingEntityException("Producto1 " + producto1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto1 producto1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            producto1 = em.merge(producto1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto1.getId();
                if (findProducto1(id) == null) {
                    throw new NonexistentEntityException("The producto1 with id " + id + " no longer exists.");
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
            Producto1 producto1;
            try {
                producto1 = em.getReference(Producto1.class, id);
                producto1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(producto1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto1> findProducto1Entities() {
        return findProducto1Entities(true, -1, -1);
    }

    public List<Producto1> findProducto1Entities(int maxResults, int firstResult) {
        return findProducto1Entities(false, maxResults, firstResult);
    }

    private List<Producto1> findProducto1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto1.class));
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

    public Producto1 findProducto1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto1.class, id);
        } finally {
            em.close();
        }
    }

    public int getProducto1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto1> rt = cq.from(Producto1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
