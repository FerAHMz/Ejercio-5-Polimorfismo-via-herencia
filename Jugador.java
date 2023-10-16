/**
 * Clase base que representa un jugador en el torneo de voleibol.
 */
public abstract class Jugador {

    private String nombre;
    private String pais;
    private int errores;
    private int aces;
    private int totalServicios;

    /**
     * Constructor para la clase Jugador.
     *
     * @param nombre         Nombre del jugador.
     * @param pais           País del jugador.
     * @param errores        Número de errores cometidos por el jugador.
     * @param aces           Número de aces (puntos directos por servicios) del jugador.
     * @param totalServicios Total de servicios realizados por el jugador.
     */
    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    /**
     * Método abstracto para calcular la efectividad del jugador.
     * Debe ser implementado por las clases derivadas.
     *
     * @return Efectividad del jugador.
     */
    public abstract double calcularEfectividad();

    /**
     * Convierte los datos del jugador a formato CSV.
     *
     * @return Datos del jugador en formato CSV.
     */
    public String toCSV() {
        return nombre + "," + pais + "," + errores + "," + aces + "," + totalServicios;
    }

    // Getters y setters para los atributos de la clase

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getAces() {
        return aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public int getTotalServicios() {
        return totalServicios;
    }

    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

}
