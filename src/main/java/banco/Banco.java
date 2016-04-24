package banco;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Banco {


    private static Banco instancia;
    private EntityManager em;

    private Banco() {
        em = Persistence.createEntityManagerFactory("CarrinhoComprasPU").createEntityManager();
    }

    public synchronized static Banco getInstancia() {
        if (instancia == null) {
            instancia = new Banco();
        }else{
        }
        return instancia;
    }

    public EntityManager getEm() {
        return em;
    }
}
