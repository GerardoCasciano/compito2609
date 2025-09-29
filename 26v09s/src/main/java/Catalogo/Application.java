package Catalogo;

import DAO.LibriDAO;

import DAO.PrestitoDAO;
import DAO.RivisteDAO;
import DAO.UtenteDAO;
import entities.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("26v09s");

    public static void main(String[] args) {

            EntityManager em = emf.createEntityManager();
        try {
            UtenteDAO utenteDAO = new UtenteDAO(em);
            LibriDAO libriDAO = new LibriDAO(em);
            RivisteDAO rivisteDAO = new RivisteDAO(em);
            PrestitoDAO prestitoDAO = new PrestitoDAO(em);


            Utente u1 = new Utente();
            u1.setNome("Giovanni");
            u1.setCognome("Rossi");
            u1.setAnnoNascita(LocalDate.of(1995, 5, 10));
            u1.setNumeroTessera(12321);

            utenteDAO.save(u1);

            Libri l1 = new Libri();
            l1.setTitolo("Lord of the Rings");
            l1.setAnnoPubblicazione(LocalDate.of(1954, 7, 29));
            l1.setNumeroPagine(1178);
            l1.setGenere("Fantasy");
            l1.setAutore("J.R.R Tolkien");

            libriDAO.save(l1);

            Riviste r1 = new Riviste();
            r1.setTitolo("TImes");
            r1.setAnnoPubblicazone(LocalDate.of(2025, 2, 3));
            r1.setNumeroPagine(30);
            r1.setAutore("John smith");
            r1.setGenre("news");
            r1.setPerieodo(Perieodicità.MENSILE);

            rivisteDAO.save(r1);

            Prestito p1 = new Prestito();
            p1.setUtente(u1);
            p1.setLibro(l1);
            p1.setPrestato(true);
            p1.setDataInizioPrestito(LocalDate.now());
            p1.setDataRestituzione(LocalDate.now().plusDays(30));

            prestitoDAO.save(p1);

            Prestito p2 = new Prestito();
            p2.setUtente(u1);
            p2.setRivista(r1);
            p2.setDataRestituzione(LocalDate.now().plusDays(30));

            prestitoDAO.save(p2);
        } catch (Exception e) {
            System.out.println("Errore di esecuzione" + e.getMessage());
        }


        em.close();
        emf.close();

    }
}
