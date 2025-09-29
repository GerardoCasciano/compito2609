package DAO;
import entities.Riviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RivisteDAO {
    private final EntityManager em;

    public RivisteDAO(EntityManager em){
        this.em=em;
    }
    public void save (Riviste newriviste){
        EntityTransaction transaction=em.getTransaction();
        try {
            transaction.begin();
            em.persist(newriviste);
            transaction.commit();
            System.out.println("La  rivista" + newriviste.getTitolo() + "è stato salvato correttamente");
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            System.out.println("Errore salvataggio Rivista");
            e.printStackTrace();
        }
    }

}
