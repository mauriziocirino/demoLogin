package model.articolo;

public class Articolo {
    private String dimensione, descrizione, foto;
    private int id, numAcquisti, codiceTessuto, idCatalogo;
    private double price;
    public Articolo() {}
    public Articolo(int id,double price, String dimensione, String descrizione, String foto, int numAcquisti, int codiceTessuto, int idCatalogo) {
        this.id = id;
        this.price = price;
        this.dimensione = dimensione;
        this.descrizione = descrizione;
        this.foto = foto;
        this.numAcquisti = numAcquisti;
        this.codiceTessuto = codiceTessuto;
        this.idCatalogo = idCatalogo;
    }
    public Articolo(int id, double price, String dimensione, String descrizione, String foto, int numAcquisti, int codiceTessuto) {
        this.id = id;
        this.price=price;
        this.dimensione = dimensione;
        this.descrizione = descrizione;
        this.foto = foto;
        this.numAcquisti = numAcquisti;
        this.codiceTessuto = codiceTessuto;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public int getCodiceTessuto() {
        return codiceTessuto;
    }

    public void setCodiceTessuto(int codiceTessuto) {
        this.codiceTessuto = codiceTessuto;
    }

    public String getDimensione() {
        return dimensione;
    }

    public void setDimensione(String dimensione) {
        this.dimensione = dimensione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public int getNumAcquisti() {
        return numAcquisti;
    }

    public void setNumAcquisti(int numAcquisti) {
        this.numAcquisti = numAcquisti;
    }
}
