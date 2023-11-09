import java.sql.Connection;
import java.sql.DriverManager;

public class ConnessioneDB {
    Connection conn = null;

    public ConnessioneDB (String url, String username, String password) {
         try {
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connessione stabilita.");
            }
            else {
                System.out.println("Impossibile connettersi!");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}