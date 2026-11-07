package model.storage;


import model.connectDB;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Manager {
    protected final DataSource source;

    public Manager(DataSource source) throws SQLException {
        Connection con = connectDB.getConnection();
        this.source = source;
    }

}
