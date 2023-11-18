import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class booksCRUD {

    private Connection connection;
    private Statement statement;

    public booksCRUD() {
        this.connection = dbConnection.get_connection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<booksModel> selectAllBooks() {
        String sql = "SELECT * FROM books;";
        List<booksModel> resultList = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                resultList.add(new booksModel(
                        result.getInt("id"),
                        result.getString("book_name"),
                        result.getInt("page_numbers"),
                        result.getString("topic"),
                        result.getDate("release_date"),
                        result.getBoolean("is_available"),
                        result.getString("author")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
    public booksModel selectOneBook(int id) {
        String sql = "SELECT * FROM books WHERE id = ?;";
        booksModel resultBook;
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            ResultSet result = prepared.executeQuery();
            result.next();
            resultBook = new booksModel(
                    result.getInt("id"),
                    result.getString("book_name"),
                    result.getInt("page_numbers"),
                    result.getString("topic"),
                    result.getDate("release_date"),
                    result.getBoolean("is_available"),
                    result.getString("author")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultBook;
    }
}
