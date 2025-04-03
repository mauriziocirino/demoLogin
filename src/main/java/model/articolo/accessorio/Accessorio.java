package model.articolo.accessorio;

import model.articolo.Articolo;

public class Accessorio extends Articolo {
    private boolean indossabile;

    public Accessorio() {super();}

    public Accessorio(int id, double price,String dimensione, String descrizione, String foto, int numAcquisti, int sconto, int codiceTessuto, boolean indossabile) {
        super(id, price, dimensione, descrizione, foto, numAcquisti, sconto, codiceTessuto);
        this.indossabile = indossabile;
    }

    public Accessorio(int id, double price, String dimensione, String descrizione, String foto, int numAcquisti, int sconto, int codiceTessuto, int idCatalogo, boolean indossabile) {
        super(id, price,  dimensione, descrizione, foto, numAcquisti, sconto, codiceTessuto, idCatalogo);
        this.indossabile = indossabile;
    }

    public boolean isIndossabile() {
        return indossabile;
    }

    public void setIndossabile(boolean indossabile) {
        this.indossabile = indossabile;
    }
    @Override
    public String toString(){
        return "Borsa: "+super.getId()+'\'' +
                ", descrizione="+super.getDescrizione()+'\'' +
                ", foto='"+ super.getFoto()+'\'' +
                ", indossabile="+ indossabile + '\'' +
                ", numAcquisti="+ super.getNumAcquisti() + '\'' +
                ", sconto="+ super.getSconto() + '\'' +
                ", idCatalogo="+ super.getIdCatalogo() + '\'' +
                ", codiceTessuto="+ super.getCodiceTessuto();
    }
}
