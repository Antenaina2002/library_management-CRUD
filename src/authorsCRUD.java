import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class authorsCRUD {

    private Connection connection;
    private Statement statement;

    public authorsCRUD() {
        this.connection = dbConnection.get_connection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<authorsModel> selectAllAuthors() {
        String sql = "SELECT * FROM authors;";
        List<authorsModel> resultList = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                resultList.add(new authorsModel(
                        result.getInt("id"),
                        result.getString("author_name"),
                        result.getString("sex").charAt(0)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public authorsModel selectOneAuthor(int id) {
        String sql = "SELECT * FROM authors WHERE id = ?;";
        authorsModel resultAuthor;
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            ResultSet result = prepared.executeQuery();
            result.next();
            resultAuthor = new authorsModel(
                    result.getInt("id"),
                    result.getString("author_name"),
                    result.getString("sex").charAt(0)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultAuthor;
    }

    public void insertAuthor(authorsModel author) {
        String sql = "INSERT INTO authors (author_name, sex) VALUES (?, ?);";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, author.getAuthorName());
            prepared.setString(2, String.valueOf(author.getAuthorSex()));
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAuthor(authorsModel author) {
        String sql = "UPDATE authors SET author_name = ?, sex = ? WHERE id = ?;";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, author.getAuthorName());
            prepared.setString(2, String.valueOf(author.getAuthorSex()));
            prepared.setInt(3, author.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAuthor(int id) {
        String sql = "DELETE FROM authors WHERE id = ?;";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
