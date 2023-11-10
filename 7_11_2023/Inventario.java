import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Giocattolo> giocattoli;
    private static boolean generato = false;
    private String DB_DRIVER = "com.mysql.jdbc.Driver";
    private String url = "";
    private String username = "il_tuo_utente";
    private String password = "la_tua_password";
        
    public Inventario(String admin){
        if(admin.equals("CLIE_2")){
             giocattoli = new ArrayList<Giocattolo>();
             generato = true;
             System.out.println("Inventario generato correttamente!!!");
        }else{
            System.out.println("Non hai i permessi per utilizzare questa classe!!!");
            return;
        }
    }

    public void aggiungiGiocattolo(Giocattolo g, String admin){
        if(generato){
            if(admin.equals("CLIE_2")){
            giocattoli.add(g);
            System.out.println("Giocattolo aggiunto correttamente!!!");
            try{
                Connection conn = DriverManager.getConnection(url, username, password);
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Non hai i permessi per utilizzare questa classe!!!");
            return;
            }
        }else{
            System.out.println("L'inventario non esiste ancora!!!");
        }
    }

    public void rimuoviGiocattolo(int i, String admin){
        if(generato){
            if(admin.equals("CLIE_2")){
                giocattoli.remove(i);
                System.out.println("Giocattolo rimosso correttamente!!!");
            }else{
                System.out.println("Non hai i permessi per utilizzare questa classe!!!");
                return;
            }
        }else{
            System.out.println("L'inventario non esiste ancora!!!");
        }
        
        
    }

    public void listaGiocattoli(){
        if(generato){
            for(int i=0;i<giocattoli.size();i++){
            System.out.println(giocattoli.get(i)); 
            System.out.println();
            }
        }else{
            System.out.println("L'inventario non esiste ancora!!!");
        }
    }

    public Giocattolo getGiocattolo(int pos){
        if(generato){
            return giocattoli.get(pos);
        }else{
            System.out.println("L'inventario non esiste ancora!!!");
            return null;
        }
    }

    public int posizioneGiocattolo(String n, int p, int e){
        if(generato){
            for(int i=0;i<giocattoli.size();i++){
                if(giocattoli.get(i).getNome().equals(n) && giocattoli.get(i).getPrezzo()==p && giocattoli.get(i).getEtaConsigliata()==e){
                    return i;
                }
            }
            return -1;
        }else{
            System.out.println("L'inventario non esiste ancora!!!");
            return -1;
        }
    }

    public boolean presente(String n, int p, int e){
        if(generato){
            for(int i=0;i<giocattoli.size();i++){
                if(giocattoli.get(i).getNome().equals(n) && giocattoli.get(i).getPrezzo()==p && giocattoli.get(i).getEtaConsigliata()==e){
                    return true;
                }
            }
            return false;
        }else{
            System.out.println("L'inventario non esiste ancora!!!");
            return false;
        }
    }
}
