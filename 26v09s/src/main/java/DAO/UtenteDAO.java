package DAO;

import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em){
        this.em=em;
    }
    public void save (Utente newutente){
        EntityTransaction transaction=em.getTransaction();
        try {
            transaction.begin();
            em.persist(newutente);
            transaction.commit();
            System.out.println("L'utente" + newutente.getNome()  + "è: stato salvato correttamente");
        }catch (Exception e){
        if(transaction.isActive()){
            transaction.rollback();
        }
        System.out.println("Errore durante il salvataggio dell'utente" + newutente.getNome());

            e.printStackTrace();
        }
    }

}

