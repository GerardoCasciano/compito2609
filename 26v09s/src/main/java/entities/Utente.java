package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "utenti")
public class Utente {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
            @Column(name = "id")
    UUID id;
    @Column(name = "nome",nullable = false,length = 30)
    String nome;
    @Column(name = "cognome",nullable = false,length = 30)
    String cognome;
    @Column(name = "anno_nascita",nullable = false)
    LocalDate annoNascita;
    @Column(name = "numero_tessera",nullable = false)
    int numeroTessera;
    @OneToMany(mappedBy = "utente")
    private List<Prestito>prestiti;

    public Utente() {
    }

    public Utente(UUID id, String nome, String cognome, LocalDate annoNascita, int numeroTessera) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.annoNascita = annoNascita;
        this.numeroTessera = numeroTessera;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setAnnoNascita(LocalDate annoNascita) {
        this.annoNascita = annoNascita;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getAnnoNascita() {
        return annoNascita;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }
}
