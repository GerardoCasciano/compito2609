package entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Random;

public class CatalogoService {
    private final EntityManager em;
    private final Random random =new Random();
    public CatalogoService(EntityManager em){
        this.em =em;
    }
    public void  aggiungiUtente(Utente u){
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            System.out.println("Utente" + u.getNome() + "agginto correttamente");
        }catch(Exception e){
            if (em.getTransaction().isActive())em.getTransaction().rollback();
        }
    }
    public Utente utentiRandom(){
        TypedQuery<Utente>query=em.createQuery("SELECT u FROM utente u",Utente.class);
        List<Utente> utenti =query.getResultList();
        if(utenti.isEmpty()) return null;
        return utenti.get(random.nextInt(utenti.size()));
    }
    public void visualizzaUtenti(){
        List<Utente> utenti = em.createQuery("SELECT u FROM u",Utente.class.getResultList());
        System.out.println("Utenti nel database");
        utenti.forEach(u-> System.out.println(u.getNome() + ""+ u.getCognome() + "Tessera" + u.getNumeroTessera()));
    }
    public void aggiungiLibro(Libri ){
        try{
            em.getTransaction().begin();
            em.persist(1);
            em.getTransaction().commit();
            System.out.println("Libro" + 1.getTitolo() + "aggiunto correttamente");
        }catch (Expetion e) {
            if(em.getTransaction().isActive())em.getTransaction().rollback();
        }
    }
    public void visualizzaLibri(){
        List<Libri>libri =em.createQuery("SELECT 1FORM libri 1",Libri.class).getResultList();
        System.out.println("Libri nel catlogo");
        libri.forEach(1 -> System.out.println(1.getTitolo() + "di" + 1.getAutore());
    }
public void aggiungiRivista(Riviste r){
        try{
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            System.out.println("Rivista" + r.getTitolo() + "aggiunta correttamente");
        }catch (Exception e){
            if(em.getTransaction().isActive())em.getTransaction().rollback();
            e.printStackTrace();

        }



}

}
