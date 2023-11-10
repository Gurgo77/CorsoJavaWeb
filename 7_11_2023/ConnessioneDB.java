import java.sql.*;

public class ConnessioneDB {
    Connection conn = null;
    private static boolean azioni = false;

    public ConnessioneDB (String url, String username, String password) {
         try {
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connessione stabilita.");
                azioni = true;
            }
            else {
                System.out.println("Impossibile connettersi!");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void aggiungiGiocattolo(String nome, int prezzo, int etaConsigliata){
        return;
    }
    public void modificaGiocattolo(String nome, int prezzo, int etaConsigliata){
        return;
    }
    public void aggiungiCliente(String nome, String cognome, String indirizzo, String telefono){
        return;
    }
    public void modificaCliente(String nome, String cognome, String indirizzo, String telefono){
        return;
    }
    public void aggiungiVendita(String nome, String cognome, String giocattolo){
        return;
    }
    public void modificaVendita(String nome, String cognome, String giocattolo){
        return;
    }
    public void rimuoviGiocattolo(String nome){
        return;
    }
    public void rimuoviCliente(String nome, String cognome){
        return;
    }
    public void rimuoviVendita(String nome, String cognome, String giocattolo){
        return;
    }
}