import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class visitorsCRUD {

    private Connection connection;
    private Statement statement;

    public visitorsCRUD() {
        this.connection = dbConnection.get_connection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<visitorsModel> selectAllVisitors(){
        String sql = "SELECT * FROM visitors;";
        List<visitorsModel> resultList = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                resultList.add(new visitorsModel(
                        result.getInt("id"),
                        result.getString("visitor_name"),
                        result.getString("reference")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
    public visitorsModel selectOneVisitor(int id){
        String sql = "SELECT * FROM visitors WHERE id = ?;";
        visitorsModel resultVisitor;
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            ResultSet result = prepared.executeQuery();
            result.next();
            resultVisitor = new visitorsModel(
                    result.getInt("id"),
                    result.getString("visitor_name"),
                    result.getString("reference")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultVisitor;
    }
}
