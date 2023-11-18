import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class loanHistoryCRUD {

    private Connection connection;
    private Statement statement;

    public loanHistoryCRUD() {
        this.connection = dbConnection.get_connection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<loanHistoryModel> selectAllLoanHistory() {
        String sql = "SELECT * FROM loan_history;";
        List<loanHistoryModel> resultList = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                resultList.add(new loanHistoryModel(
                        result.getInt("loan_id"),
                        result.getInt("book_id"),
                        result.getInt("visitor_id"),
                        result.getString("visitor_name"),
                        result.getString("visitor_reference"),
                        result.getDate("borrowed_date"),
                        result.getDate("returned_date"),
                        result.getBoolean("is_available")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}