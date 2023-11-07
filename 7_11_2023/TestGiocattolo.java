import java.util.*;

public class TestGiocattolo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Cliente> clienti = new ArrayList<Cliente>();
        int menuLogin = 1000;

        while(menuLogin!=0){
            System.out.println("Inserisci 0 per uscire: ");
            System.out.println("Inserisci 1 per Effettuare il login: ");
            System.out.println("Inserisci 2 per Effettuare la registrazione: ");
            menuLogin=s.nextInt();
            switch(menuLogin){
                case 2:
                    System.out.println("Inserisci il nome: ");
                    String nome = s.nextLine();
                    System.out.println("Inserisci il cognome: ");
                    String cognome = s.nextLine();
                    System.out.println("Inserisci l'email: ");
                    String email = s.nextLine();
                    Cliente c = new Cliente(nome,cognome,email);
                    clienti.add(c);
                    break;
            }
        }
        Giocattolo g = new Giocattolo("Ciao",100,12);
        System.out.println(g.getId());
        Giocattolo g1 = new Giocattolo("Ciao",100,12);
        System.out.println(g1.getId());

    }
}
