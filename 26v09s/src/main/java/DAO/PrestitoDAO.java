package DAO;
import entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em){
        this.em=em;
    }
    public void save (Prestito newprestito){
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(newprestito);
        transaction.commit();
        System.out.println("Prestito registrato correttamente");
    }

}
