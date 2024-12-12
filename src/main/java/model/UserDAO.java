package model;

import java.sql.*;

public class UserDAO {
    public int doCheckUser(String username) {
        try (Connection con = connectDB.getConnection()) {
            PreparedStatement statement = con.prepareStatement("select * from users where username=?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return 1;
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doSave(User u){
        try (Connection con = connectDB.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO user (`username`, `password`) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, u.getUser());
            ps.setString(2, u.getPass());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
