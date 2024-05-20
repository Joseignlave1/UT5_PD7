import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] listaAbonados = ManejadorArchivosGenerico.leerArchivo("src/abonados.txt");
        for(String elemAbonado : listaAbonados) {
            String[] abonados = elemAbonado.split(",");
            TAbonado abonado = new TAbonado(abonados[1], abonados[0]);
            trieAbonados.insertar(abonado);
        }

        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        // crear el archivo "salida.txt", con los abonados (1 por linea)
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        for(TAbonado abonado : ab) {
            System.out.println(abonado.getNombre() + " " + abonado.getTelefono());
            String[] datosAbonado = {abonado.getNombre() + "," + abonado.getTelefono()};
            ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", datosAbonado);
        }
        //PREGUNTARLE AL PROFE COMO ORDENARLOS ALFABÉTICAMENTE
    }
}