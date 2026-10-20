package dao;

import entity.Movie;
import java.sql.*;

public class MovieDAO {

    private static final String URL = "jdbc:mariadb://localhost:3306/sakila";
    private static final String USER = "root";
    private static final String PASS = "your-password";

    public static Movie getMovieByName(String title) throws Exception {
        String sql = "SELECT film_id, title, release_year, length FROM film WHERE title = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Movie(
                            rs.getInt("film_id"),
                            rs.getString("title"),
                            rs.getInt("release_year"),
                            rs.getInt("length"));
                }
                throw new Exception("The movie does not exist: " + title);
            }
        }
    }
}
