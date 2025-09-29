package DAO;

import entities.Libri;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LibriDAO {
    private final EntityManager em;

    public LibriDAO(EntityManager em){
        this.em=em;
    }
public void save (Libri libro){
    EntityTransaction transaction=em.getTransaction();
    transaction.begin();
    em.persist(libro);
    transaction.commit();
    System.out.println("il libro" + libro.getTitolo() +"è stato salvato correttamente");
}

}
