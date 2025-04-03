package model.catalogo;

import model.articolo.Articolo;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private String nome, stagione;
    private int id;
    private List<Articolo> listaArticoli = new ArrayList<Articolo>();

    public Catalogo(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Catalogo(String nome, String stagione) {
        this.nome = nome;
        this.stagione = stagione;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStagione() {
        return stagione;
    }

    public void setStagione(String stagione) {
        this.stagione = stagione;
    }

    public int getId() {
        return id;
    }

    public List<Articolo> getListaArticoli() {
        return listaArticoli;
    }
    public void setListaArticoli(List<Articolo> listaArticoli) {
        this.listaArticoli = listaArticoli;
    }
}
