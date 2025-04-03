package model.articolo;


import model.storage.Manager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticoloManager extends Manager implements ArticoloDao {

    public ArticoloManager(DataSource source) {
        super(source);
    }

    @Override
    public List<Articolo> fetchArticoli(int start, int end) throws SQLException {
        List<Articolo> articoli;
        try (Connection con = source.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("select * from articolo LIMIT ?,?")) {
                ps.setInt(1, start);
                ps.setInt(2, end);
                try (ResultSet rs = ps.executeQuery()) {
                    ArticoloExtractor extractor = new ArticoloExtractor();
                    articoli = new ArrayList<>();
                    while (rs.next()) {
                        articoli.add(extractor.extractData(rs));
                    }
                    return articoli;
                }
            }
        }
    }

    @Override
    public Optional<Articolo> fetchArticolo(int id) throws SQLException {
        try(Connection con = source.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("select * from articolo WHERE id = ?")) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                ArticoloExtractor extractor = new ArticoloExtractor();
                Articolo articolo = null;
                if (rs.next()){
                    articolo = new ArticoloExtractor().extractData(rs);
                }
                return Optional.ofNullable(articolo);
            }
        }
    }

    @Override
    public boolean createArticolo(Articolo articolo) throws SQLException {
        try (Connection con = source.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO Articolo VALUES (id, price, descrizione, dimensione, codiceTessuto, numAcquisti, foto, idCatalogo, sconto) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                ps.setInt(1, articolo.getId());
                ps.setDouble(2, articolo.getPrice());
                ps.setString(3, articolo.getDescrizione());
                ps.setString(4, articolo.getDimensione());
                ps.setInt(5, articolo.getCodiceTessuto());
                ps.setInt(6, articolo.getNumAcquisti());
                ps.setString(7, articolo.getFoto());
                ps.setInt(8, articolo.getIdCatalogo());
                ps.setInt(9, articolo.getSconto());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean updatePriceArticolo(Articolo articolo) throws SQLException {
        try(Connection con = source.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("UPDATE FROM Articolo SET price = ? WHERE id = ?")){
                ps.setDouble(1, articolo.getPrice());
                ps.setInt(2, articolo.getId());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public boolean deleteArticolo(int id) throws SQLException {
        try(Connection con = source.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM Articolo WHERE id = ?")){
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}
