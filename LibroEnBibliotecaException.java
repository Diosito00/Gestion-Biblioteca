/**
 * Excepción personalizada para manejar situaciones en las que
 * se intenta realizar una operación inválida sobre un libro que
 * aún se encuentra en la biblioteca.
 * 
 * Esta clase extiende {@code Exception}, permitiendo lanzar y 
 * capturar errores específicos relacionados con la gestión de 
 * libros en préstamo o disponibles.
 * 
 * Ejemplo de uso:
 * <pre>
 * if (libro.estaEnBiblioteca()) {
 *     throw new LibroEnBibliotecaException("El libro aún no ha sido prestado.");
 * }
 * </pre>
 * 
 * @author Aguirre Mauricio Alejandro
 * @version 25/10/25
 */
public class LibroEnBibliotecaException extends Exception {
    
    /**
     * Crea una nueva excepción con el mensaje especificado.
     * 
     * @param mensaje Descripción del error ocurrido
     */
    public LibroEnBibliotecaException(String mensaje) {
        super(mensaje);
    }
}
