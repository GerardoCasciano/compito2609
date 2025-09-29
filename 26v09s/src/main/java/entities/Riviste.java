package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "riviste")
public class Riviste {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "id")
    UUID id;
    @Column(name = "titolo",nullable = false,length = 30)
    String titolo;
    @Column(name = "anno_pubblicazione",nullable = false)
    LocalDate annoPubblicazione;

    @Column(name = "numero_pagine",nullable = false)
    int numeroPagine;
    @Column(name = "autore",length = 30)
    String autore;
    @Column(name = "genere",length = 30)
    String genere;
    @Enumerated(EnumType.STRING)
            @Column(name = "perieodicità",nullable = false)
         Perieodicità perieodo;
    @OneToMany(mappedBy = "rivista")
    private List<Prestito>prestiti;

    public Riviste() {
    }

    public Riviste(UUID id, String titolo, LocalDate annoPubblicazone, int numeroPagine, String autore, String genre, Perieodicità perieodo) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazone;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.genere = genre;
        this.perieodo = perieodo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazone(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenre(String genre) {
        this.genere = genre;
    }

    public void setPerieodo(Perieodicità perieodo) {
        this.perieodo = perieodo;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getAnnoPubblicazone() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenre() {
        return genere;
    }

    public Perieodicità getPerieodo() {
        return perieodo;
    }
}
