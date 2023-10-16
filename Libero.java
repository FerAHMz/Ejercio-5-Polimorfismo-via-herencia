/**
 * Clase que representa un jugador de tipo Líbero en el torneo de voleibol.
 */
public class Libero extends Jugador {

    private int recibosEfectivos;

    /**
     * Constructor para la clase Libero.
     *
     * @param nombre          Nombre del jugador.
     * @param pais            País del jugador.
     * @param errores         Número de errores cometidos por el jugador.
     * @param aces            Número de aces (puntos directos por servicios) del jugador.
     * @param totalServicios  Total de servicios realizados por el jugador.
     * @param recibosEfectivos Número de recibos efectivos realizados por el líbero.
     */
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    /**
     * Calcula la efectividad del líbero.
     *
     * @return Efectividad del líbero.
     */
    @Override
    public double calcularEfectividad() {
        double efectividadRecibos = ((double) (recibosEfectivos - getErrores()) * 100) / (recibosEfectivos + getErrores());
        double efectividadAces = ((double) getAces() * 100) / getTotalServicios();
        return efectividadRecibos + efectividadAces;
    }

    /**
     * Convierte los datos del líbero a formato CSV.
     *
     * @return Datos del líbero en formato CSV.
     */
    @Override
    public String toCSV() {
        return super.toCSV() + "," + recibosEfectivos;
    }

    // Getter y setter para el atributo recibosEfectivos

    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    @Override
    public String toString() {
        return "Libero {" + 
            "\n\tNombre: " + getNombre() + 
            "\n\tPaís: " + getPais() + 
            "\n\tErrores: " + getErrores() + 
            "\n\tAces: " + getAces() + 
            "\n\tTotal de Servicios: " + getTotalServicios() + 
            "\n\tRecibos Efectivos: " + recibosEfectivos +
            "\n}";
}


}
