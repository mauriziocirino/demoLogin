package model.storage;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<B> {
    B extractData(ResultSet resultSet) throws SQLException;
}
