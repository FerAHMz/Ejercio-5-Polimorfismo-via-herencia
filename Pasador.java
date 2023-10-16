/**
 * Clase que representa a un jugador de tipo Pasador en un torneo de voleibol.
 */
public class Pasador extends Jugador {

    private int pases;
    private int fintasEfectivas;

    /**
     * Constructor para la clase Pasador.
     *
     * @param nombre          Nombre del jugador.
     * @param pais            País del jugador.
     * @param errores         Número de errores cometidos por el jugador.
     * @param aces            Número de aces realizados por el jugador.
     * @param totalServicios  Total de servicios realizados por el jugador.
     * @param pases           Número de pases realizados por el Pasador.
     * @param fintasEfectivas Número de fintas efectivas realizadas por el Pasador.
     */
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    /**
     * Obtiene el número de pases realizados por el Pasador.
     *
     * @return Número de pases.
     */
    public int getPases() {
        return pases;
    }

    /**
     * Establece el número de pases realizados por el Pasador.
     *
     * @param pases Número de pases.
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    /**
     * Obtiene el número de fintas efectivas realizadas por el Pasador.
     *
     * @return Número de fintas efectivas.
     */
    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    /**
     * Establece el número de fintas efectivas realizadas por el Pasador.
     *
     * @param fintasEfectivas Número de fintas efectivas.
     */
    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }

    /**
     * Calcula la efectividad del Pasador basado en sus pases, fintas y otros criterios.
     * 
     * @return La efectividad del Pasador como un valor entre 0 y 100.
     */
    @Override
    public double calcularEfectividad() {
        // Implementación básica: puedes ajustar la fórmula según tus necesidades
        double efectividad = ((double) (pases + fintasEfectivas) / getTotalServicios()) * 100;
        return efectividad;
    }

    /**
     * Representación en cadena de caracteres de un Pasador.
     *
     * @return Datos del Pasador en formato String.
     */
    @Override
    public String toString() {
        return "Pasador {" + 
            "\n\tNombre: " + getNombre() + 
            "\n\tPaís: " + getPais() + 
            "\n\tErrores: " + getErrores() + 
            "\n\tAces: " + getAces() + 
            "\n\tTotal de Servicios: " + getTotalServicios() + 
            "\n\tNúmero de Pases: " + getPases() + 
            "\n\tFintas Efectivas: " + getFintasEfectivas() +
            "\n}";
}

}
