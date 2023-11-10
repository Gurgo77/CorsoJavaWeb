import java.util.*;

public class TestGiocattolo {
    public static void main(String[] args) {
        ConnessioneDB conn = new ConnessioneDB("jdbc:mysql://localhost:3306/Giocattolaio", "root","BaIoCcHi_77");


        Scanner s = new Scanner(System.in);
        ArrayList<Cliente> clienti = new ArrayList<Cliente>();
        int menuLogin = 1000;

        while(menuLogin!=0){
            System.out.println("Inserisci 0 per uscire: ");
            System.out.println("Inserisci 1 per effettuare il login: ");
            System.out.println("Inserisci 2 per registrarti: ");
            menuLogin=s.nextInt();
            switch(menuLogin){
                case 1:
                    s.nextLine();
                    System.out.println("Inserisci nome: ");
                    String nome = s.nextLine();
                    System.out.println("Inserisci cognome: ");
                    String cognome = s.nextLine();
                    System.out.println("Inserisci email: ");
                    String email1 = s.nextLine();
                    if(presente(nome,cognome,clienti)){
                        int pos = posizione(nome,cognome,clienti);
                        Cliente clienteAttuale = clienti.get(pos);
                        System.out.println("ID del cliente: "+clienteAttuale.getId());
                        int menu = 1000;
                        ArrayList<Vendita> vendite = new ArrayList<Vendita>();
                        Inventario inventario = null;
                        while(menu!=0){
                            System.out.println("Inserisci 0 per uscire: ");
                            System.out.println("Inserisci 1 per generare l'inventario: ");
                            System.out.println("Inserisci 2 per registrare un giocattolo: ");
                            System.out.println("Inserisci 3 per rimuovere un giocattolo: ");
                            System.out.println("Inserisci 4 per visualizzare la lista dei giocattoli: ");
                            System.out.println("Inserisci 5 per registrare una vendita: ");
                            System.out.println("Inserisci 6 per visualizzare la lista delle vendite: ");
                            menu = s.nextInt();
                            switch(menu){
                                case 1:
                                    inventario = new Inventario(clienteAttuale.getId());
                                    break;
                                case 2:
                                    s.nextLine();
                                    System.out.println("Inserisci nome: ");
                                    String nomeGiocattolo = s.nextLine();
                                    System.out.println("Inserisci prezzo: ");
                                    int prezzo = s.nextInt();
                                    System.out.println("Inserisci età consigliata: ");
                                    int etaConsigliata = s.nextInt();
                                    Giocattolo giocattolo = new Giocattolo(nomeGiocattolo,prezzo,etaConsigliata);
                                    inventario.aggiungiGiocattolo(giocattolo,clienteAttuale.getId());
                                    break;
                                case 3:
                                    s.nextLine();
                                    System.out.println("Inserisci nome: ");
                                    String nomeGiocattolo1 = s.nextLine();
                                    System.out.println("Inserisci prezzo: ");
                                    int prezzo1 = s.nextInt();
                                    System.out.println("Inserisci età consigliata: ");
                                    int etaConsigliata1 = s.nextInt();
                                    if(inventario.presente(nomeGiocattolo1, prezzo1, etaConsigliata1)){
                                        int posGioc = inventario.posizioneGiocattolo(nomeGiocattolo1, prezzo1, etaConsigliata1);
                                        inventario.rimuoviGiocattolo(posGioc, clienteAttuale.getId());
                                        System.out.println("Giocattolo rimosso correttamente!!!");
                                    }else{
                                        System.out.println("Giocattolo non presente nell'inventario!!!");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Lista giocattoli: ");
                                    inventario.listaGiocattoli();
                                    break;
                                case 5: 
                                    s.nextLine();
                                    System.out.println("Inserisci nome giocattolo: ");
                                    String nomeGiocattolo2 = s.nextLine();
                                    System.out.println("Inserisci prezzo: ");
                                    int prezzo2 = s.nextInt();
                                    System.out.println("Inserisci età consigliata: ");
                                    int etaConsigliata2 = s.nextInt();
                                    if(inventario.presente(nomeGiocattolo2, prezzo2, etaConsigliata2)){
                                        int posGioc = inventario.posizioneGiocattolo(nomeGiocattolo2, prezzo2, etaConsigliata2);
                                        Vendita vendita = new Vendita(inventario.getGiocattolo(posGioc),clienteAttuale);
                                        vendite.add(vendita);
                                         System.out.println("Vendita registrata correttamente!!!");
                                    }else{
                                        System.out.println("Giocattolo non presente nell'inventario!!!");
                                    }
                                    break;
                                case 6:
                                    System.out.println("Lista vendite: ");
                                    for(int i=0;i<vendite.size();i++){
                                        System.out.println(vendite.get(i));
                                    }
                                    break;

                            }
                        }
                    }else{
                        System.out.println("Utente non trovato!!!");
                    }
                    break;
                case 2:
                    s.nextLine();
                    System.out.println("Inserisci nome: ");
                    String nome1 = s.nextLine();
                    System.out.println("Inserisci cognome: ");
                    String cognome1 = s.nextLine();
                    System.out.println("Inserisci email: ");
                    String email = s.nextLine();
                    if(!presente(nome1,cognome1,clienti)){
                        clienti.add(new Cliente(nome1,cognome1,email));
                    }else{
                        System.out.println("Utente già presente!!!");
                    }
                    break;
            }
        }

    }

    public static boolean presente(String nome, String cognome, ArrayList<Cliente> clienti){
        for(int i=0;i<clienti.size();i++){
            if(clienti.get(i).getNome().equals(nome) && clienti.get(i).getCognome().equals(cognome)){
                return true;
            }
        }
        return false;
    }

    public static int posizione(String nome, String cognome, ArrayList<Cliente> clienti){
        for(int i=0;i<clienti.size();i++){
            if(clienti.get(i).getNome().equals(nome) && clienti.get(i).getCognome().equals(cognome)){
                return i;
            }
        }
        return -1;
    }
}
