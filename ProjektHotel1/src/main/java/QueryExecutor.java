import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor extends Singleroom {
    public static ResultSet executeSelect(String selectQuery){
        try {
            Connection connection=DbConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQuery(String query){
        try{
            Connection connection=DbConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void selectSingleroom(){
        try{
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM  singleroom");
            while (result.next()){
                System.out.println(result.getString("name")+" "+result.getString("contact")+" "+result.getString("gender"));
            }

        }catch(SQLException e){


        }



    }
    public static void selectfood(){
        try{
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM  food");
            while (result.next()){
                System.out.println(result.getString("food_name"));
            }

        }catch(SQLException e){



        }
    }
}