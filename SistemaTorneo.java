import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Representa el sistema de gestión del torneo de voleibol.
 */
public class SistemaTorneo {
    private ArrayList<Jugador> jugadores;

    /**
     * Constructor para la clase SistemaTorneo.
     */
    public SistemaTorneo() {
        this.jugadores = new ArrayList<>();
    }

    /**
     * Añade un jugador al sistema.
     *
     * @param jugador Jugador a añadir.
     */
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /**
     * Muestra todos los jugadores inscritos en el torneo.
     *
     * @return Lista de jugadores inscritos.
     */
    public ArrayList<Jugador> mostrarJugadores() {
        return jugadores;
    }

    /**
     * Obtiene los tres mejores líberos en función de su efectividad.
     *
     * @return Lista de los tres mejores líberos.
     */
    public ArrayList<Libero> tresMejoresLiberos() {
        ArrayList<Libero> liberos = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Libero) {
                liberos.add((Libero) jugador);
            }
        }
        liberos.sort((l1, l2) -> Double.compare(l2.calcularEfectividad(), l1.calcularEfectividad()));
        return new ArrayList<>(liberos.subList(0, Math.min(3, liberos.size())));
    }

    /**
     * Calcula la cantidad de pasadores con más del 80% de efectividad.
     *
     * @return Número de pasadores con más del 80% de efectividad.
     */
    public int cantidadPasadoresEfectivos() {
        int count = 0;
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador && jugador.calcularEfectividad() > 80) {
                count++;
            }
        }
        return count;
    }

    /**
     * Guarda la lista de jugadores en un archivo CSV.
     *
     * @param filename Nombre del archivo CSV.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void guardarCatalogoCSV(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Jugador jugador : jugadores) {
                writer.write(jugador.toCSV());
                writer.write("\n");
            }
        }
    }

    /**
     * Carga la lista de jugadores desde un archivo CSV.
     *
     * @param filename Nombre del archivo CSV.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void cargarCatalogoCSV(String filename) throws IOException {
        jugadores.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Aquí deberías tener una lógica para determinar el tipo de jugador basado en los datos y agregarlo a la lista.
                // Por ejemplo, si detectas que tiene datos específicos de un Líbero, creas un objeto Líbero y lo agregas.
                // Lo mismo para Pasador y AuxiliarOpuesto.
            }
        }
    }
}
