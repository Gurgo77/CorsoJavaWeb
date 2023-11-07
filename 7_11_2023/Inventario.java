import java.util.ArrayList;

public class Inventario {
    private ArrayList<Giocattolo> giocattoli;
    public Inventario(String admin){
        if(admin.equals("CLIE_2")){
             giocattoli = new ArrayList<Giocattolo>();
        }else{
            System.out.println("Non hai i permessi per utilizzare questa classe!!!");
            return;
        }
    }

    public void aggiungiGiocattolo(Giocattolo g){
        giocattoli.add(g);
        System.out.println("Giocattolo aggiunto correttamente!!!");
    }

    public void rimuoviGiocattolo(Giocattolo g){
        for(int i=0;i<giocattoli.size();i++){
            if(giocattoli.get(i).getId().equals(g.getId())){
                giocattoli.remove(g);
            }
        }
    }

    public void listaGiocattoli(){
        for(int i=0;i<giocattoli.size();i++){
            System.out.println(giocattoli.get(i)); 
            System.out.println();
        }
    }
}
