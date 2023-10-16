import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase principal para gestionar el torneo de voleibol.
 */
public class Main {
    private static SistemaTorneo sistema = new SistemaTorneo();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal para ejecutar el programa.
     *
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {
        cargarCatalogoInicial();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar un jugador");
            System.out.println("2. Mostrar todos los jugadores inscritos");
            System.out.println("3. Mostrar los 3 mejores líberos");
            System.out.println("4. Mostrar cantidad de pasadores con más del 80% de efectividad");
            System.out.println("5. Calcular efectividad de un jugador");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarJugador();
                    break;
                case 2:
                    mostrarJugadores();
                    break;
                case 3:
                    mostrarMejoresLiberos();
                    break;
                case 4:
                    mostrarPasadoresEfectivos();
                    break;
                case 5:
                    calcularEfectividadJugador();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    /**
     * Carga el catálogo inicial desde el archivo CSV.
     */
    private static void cargarCatalogoInicial() {
        try {
            sistema.cargarCatalogoCSV("CatalogoVoleyball.csv");
            System.out.println("Catálogo cargado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar el catálogo: " + e.getMessage());
        }
    }

    /**
     * Permite registrar un nuevo jugador en el sistema.
     */
    private static void registrarJugador() {
        System.out.println("Ingrese el tipo de jugador (Libero, Pasador, AuxiliarOpuesto):");
        String tipo = scanner.nextLine();

        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el país del jugador:");
        String pais = scanner.nextLine();

        System.out.println("Ingrese el número de errores:");
        int errores = scanner.nextInt();

        System.out.println("Ingrese el número de aces:");
        int aces = scanner.nextInt();

        System.out.println("Ingrese el total de servicios:");
        int totalServicios = scanner.nextInt();

        Jugador jugador = null;

        switch (tipo.toLowerCase()) {
            case "libero":
                System.out.println("Ingrese el número de recibos efectivos:");
                int recibos = scanner.nextInt();
                jugador = new Libero(nombre, pais, errores, aces, totalServicios, recibos);
                break;
            case "pasador":
                System.out.println("Ingrese el número de pases:");
                int pases = scanner.nextInt();
                System.out.println("Ingrese el número de fintas efectivas:");
                int fintas = scanner.nextInt();
                jugador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintas);
                break;
            case "auxiliaropuesto":
                System.out.println("Ingrese el número de ataques:");
                int ataques = scanner.nextInt();
                System.out.println("Ingrese el número de bloqueos efectivos:");
                int bloqueosEfectivos = scanner.nextInt();
                System.out.println("Ingrese el número de bloqueos fallidos:");
                int bloqueosFallidos = scanner.nextInt();
                jugador = new AuxiliarOpuesto(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);
                break;
            default:
                System.out.println("Tipo de jugador no válido.");
                return;
        }

        sistema.agregarJugador(jugador);
        System.out.println("Jugador registrado exitosamente.");

        // Guardar la información actualizada en el archivo CSV
        guardarCatalogo();
    }

    /**
     * Guarda el catálogo actual en el archivo CSV.
     */
    private static void guardarCatalogo() {
        String nombreArchivo = "CatalogoVoleyball.csv";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) { // Añadido 'true' para no sobrescribir el archivo
            // Escribe la línea de encabezados solo si el archivo está vacío
            if (new File(nombreArchivo).length() == 0) {
                escritor.write("Tipo;Nombre;Pais;Errores;Aces;Total de Servicios;Recibos;Pases;Fintas;Ataques;Bloqueos Fallidos;Bloqueos Efectivos");
                escritor.newLine();
            }

            // Escribe los datos de los jugadores
            ArrayList<Jugador> jugadores = sistema.mostrarJugadores();
            for (Jugador jugador : jugadores) {
                String linea = jugador.toCSV();
                escritor.write(linea);
                escritor.newLine();
            }
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo CSV");
            System.out.println(e);
        }
    }


    /**
     * Muestra todos los jugadores inscritos en el sistema.
     */
    private static void mostrarJugadores() {
        ArrayList<Jugador> jugadores = sistema.mostrarJugadores();
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    /**
     * Muestra los tres mejores líberos inscritos en el sistema.
     */
    private static void mostrarMejoresLiberos() {
        ArrayList<Libero> liberos = sistema.tresMejoresLiberos();
        if (liberos.isEmpty()) {
            System.out.println("No hay líberos registrados.");
            return;
        }
        System.out.println("Los 3 mejores líberos son:");
        for (Libero libero : liberos) {
            System.out.println(libero);
        }
    }

    /**
     * Muestra la cantidad de pasadores con más del 80% de efectividad.
     */
    private static void mostrarPasadoresEfectivos() {
        int cantidad = sistema.cantidadPasadoresEfectivos();
        System.out.println("Cantidad de pasadores con más del 80% de efectividad: " + cantidad);
    }

    /**
     * Calcula y muestra la efectividad de un jugador específico.
     */
    private static void calcularEfectividadJugador() {
        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();

        Jugador jugador = null;
        for (Jugador j : sistema.mostrarJugadores()) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                jugador = j;
                break;
            }
        }

        if (jugador == null) {
            System.out.println("Jugador no encontrado.");
            return;
        }

        double efectividad = jugador.calcularEfectividad();
        System.out.println("La efectividad del jugador " + nombre + " es: " + efectividad + "%");
    }
}
