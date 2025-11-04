import java.util.*;

/**
 * Clase ejecutable que prueba el funcionamiento de la clase {@link Biblioteca}.
 * 
 * Crea una biblioteca con socios (docentes y estudiantes) y libros,
 * luego realiza préstamos, consultas y genera distintos reportes:
 * 
 * <ul>
 *   <li>Cantidad de socios por tipo</li>
 *   <li>Lista de docentes responsables</li>
 *   <li>Listado completo de libros y socios</li>
 *   <li>Consulta de quién tiene un libro prestado</li>
 * </ul>
 * 
 * @author Aguirre Mauricio Alejandro
 * @version 25/10/25
 */
public class GestionBiblioteca {

    /**
     * Método principal del programa.
     * Ejecuta una serie de operaciones de alta, préstamo y consulta 
     * sobre la biblioteca para verificar el correcto funcionamiento
     * de las clases del sistema.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central");
        System.out.println("Se ha creado la " + miBiblioteca.getNombre() + "\n");

        // Carga de socios docentes
        miBiblioteca.nuevoSocioDocente(14524782, "Juan Perez", 5, "Informática");
        miBiblioteca.nuevoSocioDocente(17982110, "Juan Fernández", 5, "Matemática");
        miBiblioteca.nuevoSocioDocente(10912002, "María Alegre", 5, "Letras");

        // Carga de socios estudiantes
        miBiblioteca.nuevoSocioEstudiante(28987498, "Francisco Paenza", 20, "Ingeniería");
        miBiblioteca.nuevoSocioEstudiante(31987123, "Cesar Milstein", 20, "Medicina");

        // Carga de libros
        miBiblioteca.nuevoLibro("JAVA. Como Programar", 9, "Pearson", 2014);
        miBiblioteca.nuevoLibro("Longman. Diccionario Pocket", 1, "Longman", 2010);
        miBiblioteca.nuevoLibro("Vivir para contarla", 1, "Sudamericana", 2002);
        miBiblioteca.nuevoLibro("Programando con JAVA", 1, "Editorial X", 2020); 

        System.out.println("... Socios y Libros cargados en el sistema ...\n");

        // Se realizan algunos préstamos de libros
        Socio socio1 = miBiblioteca.buscarSocio(14524782);
        Libro libro1 = miBiblioteca.getLibros().get(1); 
        if (socio1 != null && libro1 != null) {
            miBiblioteca.prestarLibro(new GregorianCalendar(), socio1, libro1);
        }

        Socio socio2 = miBiblioteca.buscarSocio(28987498);
        Libro libro2 = miBiblioteca.getLibros().get(3); 
        if (socio2 != null && libro2 != null) {
            miBiblioteca.prestarLibro(new GregorianCalendar(), socio2, libro2);
        }

        Socio socio3 = miBiblioteca.buscarSocio(31987123);
        Libro libro3 = miBiblioteca.getLibros().get(2); 
        if (socio3 != null && libro3 != null) {
            miBiblioteca.prestarLibro(new GregorianCalendar(), socio3, libro3);
        }

        // Consulta: cantidad de socios de tipo Estudiante
        System.out.println("Cantidad de socios de tipo Estudiante: " + 
                            miBiblioteca.cantidadDeSociosPorTipos("estudiante"));

        // Lista de docentes responsables (sin deudas)
        System.out.println(miBiblioteca.listaDeDocentesResponsables());

        // Listado completo de libros con estado de préstamo
        System.out.println(miBiblioteca.listaDeLibro());

        // Listado de socios registrados
        System.out.println(miBiblioteca.listarSocio());

        // Consulta: quién tiene un libro específico
        try {
            System.out.println("El socio " + 
                miBiblioteca.quienTieneElLibro(miBiblioteca.getLibros().get(3)) + 
                " tiene el libro 'Programando con JAVA'");
        } catch (LibroEnBibliotecaException ex) {
            System.out.println(ex);
        }
    }
}
