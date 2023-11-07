public class Cliente {
    private static Integer codiceProgressivo = 1;
    private String id;
    private String nome;
    private String cognome;
    private String email;

    public Cliente(String n, String c, String e){
        id = "CLIE_"+codiceProgressivo;
        nome = n;
        cognome = c;
        email = e;
        codiceProgressivo++;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Id: "+id+"\nNome: "+nome+"\nCognome: "+cognome+"\nEmail: "+email;
    }
}
