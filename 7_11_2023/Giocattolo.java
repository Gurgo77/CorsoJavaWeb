public class Giocattolo{
    private static Integer codiceProgressivo = 1;
    private int id;
    private String nome;
    private int prezzo;
    private int etaConsigliata;

    public Giocattolo(String n, int p, int e){
        id = codiceProgressivo;
        nome = n;
        prezzo = p;
        etaConsigliata = e;
        codiceProgressivo++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getEtaConsigliata() {
        return etaConsigliata;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setEtaConsigliata(int etaConsigliata) {
        this.etaConsigliata = etaConsigliata;
    }

    public String toString(){
        return "Id: "+id+"\nNome: "+nome+"\nPrezzo"+prezzo+"\nEtà consigliata: "+etaConsigliata;
    }
}