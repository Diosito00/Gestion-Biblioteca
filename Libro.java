import java.util.ArrayList;
/**
 * Representa un libro dentro del sistema bibliotecario, con su informacion basica
 * y la lista de prestamos que se le han realizado.
 * 
 * @author (Gomez Ingrid Micaela Itati) 
 * @version (28/10/2025)
 */
public class Libro {
    /**
     * Atributos
     */
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor de la clase Libro.
     * Inicializa todos los atributos del libro.
     * 
     * @param p_titulo Titulo del libro
     * @param p_edicion Numero de edicion
     * @param p_editorial Editorial del libro
     * @param p_anio Año de publicacion
     * @param p_prestamos Lista de prestamos
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList<Prestamo> p_prestamos) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }
    
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
    // Setters
    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }
    private void setEdicion(int p_edicion) {
        this.edicion = p_edicion;
    }
    private void setEditorial(String p_editorial) {
        this.editorial = p_editorial;
    }
    private void setAnio(int p_anio) {
        this.anio = p_anio;
    }
    private void setPrestamos(ArrayList<Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }
    
    // Getters
    public String getTitulo() {
        return this.titulo;
    }
    public int getEdicion() {
        return this.edicion;
    } 
    public String getEditorial() {
        return this.editorial;
    }
    public int getAnio() {
        return this.anio;
    }
    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }

    /**
     * Agrega un nuevo prestamo a la lista de prestamos del libro
     * 
     * @param p_prestamo El prestamo a agregar
     * @return true si se agrego correctamente
     */
    public boolean agregarPrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().add(p_prestamo);
    }

    /**
     * Quita un prestamo existente de la lista de prestamos.
     * 
     * @param p_prestamo El prestamo a quitar
     * @return true si se elimino correctamente
     */
    public boolean quitarPrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().remove(p_prestamo);
    }

    // Métodos
    /**
     * Retorna el ultimo prestamo del libro.
     * 
     * @return El prestamo mas reciente o null si nunca fue prestado
     */
    public Prestamo ultimoPrestamo() {
        if (prestamos.isEmpty()) { // si la lista está vacía, no hay préstamos registrados
            return null;
        }
        return prestamos.get(prestamos.size() - 1); // obtiene el último préstamo (el más reciente)
    }

    /**
     * Indica si el libro esta actualmente prestado.
     * 
     * @return true si el libro esta prestado (sin devolucion), false en caso contrario
     */
    public boolean prestado() {
        if (prestamos.isEmpty()) {
            return false;
        }
        Prestamo ultimo = ultimoPrestamo(); // obtiene el prestamo mas reciente
        return ultimo != null && ultimo.getFechaDevolucion() == null;
        // si la fecha de devolucion es null, significa que aún no fue devuelto
    }

    /**
     * Devuelve una representacion en texto del libro.
     * 
     * @return Cadena con el titulo del libro
     */
    public String toString() {
        return "Título: " + this.getTitulo();
    }
}