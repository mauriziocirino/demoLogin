package model.articolo;


import model.storage.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticoloExtractor implements ResultSetExtractor<Articolo> {

    @Override
    public Articolo extractData(ResultSet resultSet) throws SQLException {
        Articolo articolo = new Articolo();
        articolo.setId(resultSet.getInt("id"));
        articolo.setSconto(resultSet.getInt("sconto"));
        articolo.setPrice(resultSet.getInt("price"));
        articolo.setIdCatalogo(resultSet.getInt("idCatalogo"));
        articolo.setFoto(resultSet.getString("foto"));
        articolo.setDescrizione(resultSet.getString("descrizione"));
        articolo.setDimensione(resultSet.getString("dimensione"));
        articolo.setNumAcquisti(resultSet.getInt("numAcquisti"));
        articolo.setCodiceTessuto(resultSet.getInt("codiceTessuto"));
        return articolo;
    }

}
