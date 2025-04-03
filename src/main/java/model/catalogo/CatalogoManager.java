package model.catalogo;


import model.articolo.ArticoloExtractor;
import model.storage.Manager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogoManager extends Manager implements CatalogoDao<SQLException> {

    public CatalogoManager(DataSource source) {
        super(source);
    }

    @Override
    public List<Catalogo> fetchCategories() throws SQLException {
        try(Connection con = source.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT * FROM catalogo")){
                ResultSet rs = ps.executeQuery();
                CatalogoExtractor extractor = new CatalogoExtractor();
                List<Catalogo> cataloghi = new ArrayList<Catalogo>();
                while(rs.next()){
                    cataloghi.add(extractor.extractData(rs));
                }
                return cataloghi;
            }
        }
    }

    @Override
    public boolean createCatalogo(Catalogo catalogo) throws SQLException {
        try(Connection con = source.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("INSERT INTO catalogo VALUES (?, ?)")){
                ps.setString(1, catalogo.getNome());
                ps.setString(2, catalogo.getStagione());
                int rows = ps.executeUpdate();
                return rows==1;
            }
        }
    }

    @Override
    public boolean updateCatalogo(Catalogo catalogo) throws SQLException {
        try (Connection con = source.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("UPDATE Categoria SET nome = ?, stagione = ? WHERE id = ?")){
                ps.setString(1, catalogo.getNome());
                ps.setString(2, catalogo.getStagione());
                ps.setInt(3, catalogo.getId());
                int rows = ps.executeUpdate();
                return rows==1;
            }
        }
    }

    @Override
    public boolean deleteCatalogo(Catalogo catalogo) throws SQLException {
        try(Connection con = source.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM catalogo WHERE id = ?")){
                ps.setInt(1, catalogo.getId());
                int rows = ps.executeUpdate();
                return rows==1;
            }
        }
    }

    @Override
    public Optional<Catalogo> fetchCatalogoWithArticolo(int idCatalogo) throws SQLException {
        try(Connection con = source.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT * FROM Catalogo c JOIN Articolo a ON a.idCatalogo=c.id WHERE id = ?")){
                ps.setInt(1, idCatalogo);
                ResultSet rs = ps.executeQuery();
                CatalogoExtractor extractor = new CatalogoExtractor();
                Catalogo catalogo = null;
                while(rs.next()){
                    catalogo = extractor.extractData(rs);
                    catalogo.setId(rs.getInt("id"));
                    catalogo.setNome(rs.getString("nome"));
                    catalogo.setStagione(rs.getString("stagione"));
                    ArticoloExtractor articoloExtractor = new ArticoloExtractor();
                    catalogo.getListaArticoli().add(articoloExtractor.extractData(rs));
                    while (rs.next()) {
                        catalogo.getListaArticoli().add(articoloExtractor.extractData(rs));
                    }
                }
                return Optional.ofNullable(catalogo);
            }
        }
    }
}
