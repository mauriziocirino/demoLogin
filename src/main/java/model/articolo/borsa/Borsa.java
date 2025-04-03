package model.articolo.borsa;


import model.articolo.Articolo;

public class Borsa extends Articolo {
    private int idModello;
    private boolean imbottitura;


    public Borsa(){
        super();
    }
    public Borsa(int id, double price, String dimensione, String descrizione, String foto, int numAcquisti, int sconto, int codiceTessuto, int idModello, int idCatalogo){
        super(id, price, dimensione, descrizione, foto, numAcquisti, sconto, codiceTessuto, idCatalogo);
        this.idModello = idModello;
    }
    public Borsa(int id, double price, String dimensione, String descrizione, String foto,int numAcquisti, int sconto, int idModello, int codiceTessuto, boolean imbottitura, int idCatalogo){
        super(id, price,  dimensione, descrizione, foto, numAcquisti, sconto, codiceTessuto, idCatalogo);
        this.idModello = idModello;
        this.imbottitura = imbottitura;
    }

    public int getIdModello() {
        return idModello;
    }

    public void setIdModello(int idModello) {
        this.idModello = idModello;
    }
    @Override
    public String toString(){
        return "Borsa: "+super.getId()+'\'' +
                ", idModello="+ idModello +'\''+
                ", descrizione="+super.getDescrizione()+'\'' +
                ", foto='"+ super.getFoto()+'\'' +
                ", imbottitura="+ imbottitura + '\'' +
                ", numAcquisti="+ super.getNumAcquisti() + '\'' +
                ", sconto="+ super.getSconto() + '\'' +
                ", idCatalogo="+ super.getIdCatalogo() + '\'' +
                ", codiceTessuto="+ super.getCodiceTessuto();
    }
}
