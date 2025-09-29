package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="prestiti")
@Inheritance(strategy= InheritanceType.JOINED)
public class Prestito {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

   @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;

   @ManyToOne
    @JoinColumn(name= "libro_id")
    private Libri libro;

   @ManyToOne
           @JoinColumn(name="rivista_id")
           private Riviste rivista;
@Column(name="prestato",nullable = false)
   boolean prestato;
@Column(name = "data_inizio_prestito",nullable = false)
   LocalDate dataInizioPrestito;
@Column(name = "data_restituzione",nullable = false)
   LocalDate dataRestituzione;
@Column(name = "data_restituzione_effettiva")
   LocalDate dataRestituzioneEffettiva;

    public Prestito() {
        this.prestato=true;
    }

    public Prestito(UUID id, Utente utente, Libri libro, boolean prestato, LocalDate dataInizioPrestito, LocalDate dataRestituzione, LocalDate dataRestituzioneEffettiva) {
        this.id = id;
        this.utente = utente;
        this.libro = libro;
        this.prestato = true;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzione = dataRestituzione.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Prestito(UUID id, Utente utente, Riviste rivista, boolean prestato, LocalDate dataInizioPrestito, LocalDate dataRestituzione, LocalDate dataRestituzioneEffettiva) {
        this.id = id;
        this.utente = utente;
        this.libro = libro;
        this.prestato = true;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzione = dataRestituzione.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }


    public Riviste getRivista() {
        return rivista;
    }

    public UUID getId() {
        return id;
    }

    public void setRivista(Riviste rivista) {
        this.rivista = rivista;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setLibro(Libri libro) {
        this.libro = libro;
    }

    public void setPrestato(boolean prestato) {
        this.prestato = prestato;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione.plusDays(30);

    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public Libri getLibro() {
        return libro;
    }

    public boolean isPrestato() {
        return prestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }
}
