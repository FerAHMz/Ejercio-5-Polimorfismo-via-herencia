/**
 * Clase que representa a un jugador de tipo AuxiliarOpuesto en un torneo de voleibol.
 */
public class AuxiliarOpuesto extends Jugador {

    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    /**
     * Constructor para la clase AuxiliarOpuesto.
     *
     * @param nombre            Nombre del jugador.
     * @param pais              País del jugador.
     * @param errores           Número de errores cometidos por el jugador.
     * @param aces              Número de aces realizados por el jugador.
     * @param totalServicios    Total de servicios realizados por el jugador.
     * @param ataques           Número de ataques realizados por el AuxiliarOpuesto.
     * @param bloqueosEfectivos Número de bloqueos efectivos realizados por el AuxiliarOpuesto.
     * @param bloqueosFallidos  Número de bloqueos fallidos realizados por el AuxiliarOpuesto.
     */
    public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * Obtiene el número de ataques realizados por el AuxiliarOpuesto.
     *
     * @return Número de ataques.
     */
    public int getAtaques() {
        return ataques;
    }

    /**
     * Establece el número de ataques realizados por el AuxiliarOpuesto.
     *
     * @param ataques Número de ataques.
     */
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    /**
     * Obtiene el número de bloqueos efectivos realizados por el AuxiliarOpuesto.
     *
     * @return Número de bloqueos efectivos.
     */
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    /**
     * Establece el número de bloqueos efectivos realizados por el AuxiliarOpuesto.
     *
     * @param bloqueosEfectivos Número de bloqueos efectivos.
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    /**
     * Obtiene el número de bloqueos fallidos realizados por el AuxiliarOpuesto.
     *
     * @return Número de bloqueos fallidos.
     */
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    /**
     * Establece el número de bloqueos fallidos realizados por el AuxiliarOpuesto.
     *
     * @param bloqueosFallidos Número de bloqueos fallidos.
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * Calcula la efectividad del AuxiliarOpuesto basado en sus ataques, bloqueos y otros criterios.
     * 
     * @return La efectividad del AuxiliarOpuesto como un valor entre 0 y 100.
     */
    @Override
    public double calcularEfectividad() {
        // Implementación básica: puedes ajustar la fórmula según tus necesidades
        double efectividad = ((double) (ataques + bloqueosEfectivos - bloqueosFallidos) / getTotalServicios()) * 100;
        return efectividad;
    }

    /**
     * Representación en cadena de caracteres de un AuxiliarOpuesto.
     *
     * @return Datos del AuxiliarOpuesto en formato String.
     */
    @Override
    public String toString() {
        return "AuxiliarOpuesto {" + 
            "\n\tNombre: " + getNombre() + 
            "\n\tPaís: " + getPais() + 
            "\n\tErrores: " + getErrores() + 
            "\n\tAces: " + getAces() + 
            "\n\tTotal de Servicios: " + getTotalServicios() + 
            "\n\tNúmero de Ataques: " + getAtaques() + 
            "\n\tBloqueos Efectivos: " + getBloqueosEfectivos() +
            "\n\tBloqueos Fallidos: " + getBloqueosFallidos() +
            "\n}";
}

}
