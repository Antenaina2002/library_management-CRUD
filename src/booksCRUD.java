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
}
