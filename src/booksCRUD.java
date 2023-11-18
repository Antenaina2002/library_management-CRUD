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
    public void insertBook(booksModel book) {
        String sql = "INSERT INTO books (book_name, page_numbers, topic, release_date, is_available, author) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, book.getBookName());
            prepared.setInt(2, book.getPageNumbers());
            prepared.setString(3, book.getTopic());
            prepared.setDate(4, (Date) book.getReleaseDate());
            prepared.setBoolean(5, book.isAvailable());
            prepared.setString(6, book.getAuthor());
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateBook(booksModel book) {
        String sql = "UPDATE books SET book_name = ?, page_numbers = ?, topic = ?, release_date = ?, is_available = ?, author = ? WHERE id = ?;";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setString(1, book.getBookName());
            prepared.setInt(2, book.getPageNumbers());
            prepared.setString(3, book.getTopic());
            prepared.setDate(4, (Date) book.getReleaseDate());
            prepared.setBoolean(5, book.isAvailable());
            prepared.setString(6, book.getAuthor());
            prepared.setInt(7, book.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?;";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
