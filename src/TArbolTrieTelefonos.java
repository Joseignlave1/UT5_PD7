import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        String prefijo = pais + area;
        LinkedList<TAbonado> abonados = new LinkedList<>();
        if(raiz != null) {
            raiz.buscarTelefonos(prefijo, abonados);
        }
        return abonados;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if(raiz == null) {
            raiz = new TNodoTrieTelefonos();
        }
        raiz.insertar(unAbonado);
    }

 
    
}
