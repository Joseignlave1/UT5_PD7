

import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {
    private final static int CANT_NUM_TELEFONO = 10;
    private TNodoTrieTelefonos[] hijos;
    TAbonado abonado;
    private boolean esAbonado;
    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[CANT_NUM_TELEFONO];
        esAbonado = false;
        abonado = null;
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = this;
        for(int c = 0; c < primerosDigitos.length(); c++) {
            int indice = getIndice(primerosDigitos.charAt(c));
            nodo = nodo.hijos[indice];
            if(nodo == null) {
                return; //No encontramos un abonado que tenga ese prefijo;
            }
        }
        //Llegado a este punto, tenemos los abonados los cuáles los primerosDigitos es un prefijo de su telefono,
        //Ahora tenemos que guardarlos en una estructura
        //SOLO RECOGEMOS LOS  ABONADOS EN ESTE CASO QUE TIENEN ESTAS CARACTERÍSTICAS.
        nodo.obtenerAbonados(abonados);
    }

    private void obtenerAbonados(LinkedList<TAbonado> abonados) {
        //Esta función obtiene los abonados recorriendo el trie de manera recursiva.
        if(esAbonado) {
            abonados.add(abonado);
        }
        for(TNodoTrieTelefonos hijo : hijos) {
            if(hijo != null) {
                hijo.obtenerAbonados(abonados);
            }
        }
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        String numeroAbonado = unAbonado.getTelefono();
        for(int c = 0; c < numeroAbonado.length(); c++) {
            int indice = getIndice(numeroAbonado.charAt(c));
            if(nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esAbonado = true;
        nodo.abonado = unAbonado;
    }

    private int getIndice(char c) {
        return c - '0';
    }
}
