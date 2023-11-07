import java.util.ArrayList;
import java.util.List;

public abstract class RegistroVendite {
     protected List<Vendita> vendite;

    public RegistroVendite() {
        vendite = new ArrayList<>();
    }

    // Metodo astratto per registrare una vendita
    public abstract void registraVendita(Cliente cliente, Giocattolo giocattolo);

}
