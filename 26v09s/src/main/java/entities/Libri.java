package entities;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name="Libri")
public class Libri {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "id")
    UUID id;
    @Column(name="titolo",nullable = false,length = 30)
    String titolo;
    @Column(name = "anno_pubblicazione",nullable = false)
    LocalDate annoPubblicazione;
    @Column(name = "numero_pagine")
    int numeroPagine;
    @Column(name = "autore",nullable = false,length = 30)
    String autore;
    @Column(name="genere",nullable = false,length = 30)
    String genere;
  @OneToMany(mappedBy = "libro")
  private List<Prestito>prestiti;

    public Libri(){

}

    public Libri(UUID id, String titolo, LocalDate annoPubblicazone, int numeroPagine, String autore, String genere) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazone;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.genere = genere;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }
}

