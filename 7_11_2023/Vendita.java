public class Vendita{
    private static Integer codiceProgressivo = 1;
    private String id;
    private Giocattolo g;
    private Cliente c;
    
    public Vendita (Giocattolo g, Cliente c){
        id=c.getId()+"_VEND_"+g.getId()+"_COD_"+codiceProgressivo;
        this.g = g;
        this.c = c;
        codiceProgressivo++;
    }

    public String toString(){
        return id;
    }
}
