package model.catalogo;


import model.storage.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogoExtractor implements ResultSetExtractor<Catalogo> {

    @Override
    public Catalogo extractData(ResultSet resultSet) throws SQLException {
        Catalogo catalogo = new Catalogo();

        catalogo.setId(resultSet.getInt("id"));
        catalogo.setNome(resultSet.getString("nome"));
        catalogo.setStagione(resultSet.getString("stagione"));

        return catalogo;
    }
}
