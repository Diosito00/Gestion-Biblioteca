import java.util.*;

/**
 * Clase que representa una Biblioteca que administra socios, libros y préstamos.
 * Permite registrar nuevos socios (docentes o estudiantes), agregar libros,
 * realizar préstamos y devoluciones, y generar distintos listados y estadísticas.
 * 
 * Además, gestiona las excepciones cuando se intenta devolver o consultar un libro
 * que aún se encuentra en la biblioteca.
 * 
 * @author Iturrieta Waldemar - Sanchez Rodriguez Enzo Nahuel - Gomez Perkovich Francisco Jose
 * @version 25/10/25
 */
public class Biblioteca {
    private String nombre;
    private HashMap<Integer,Socio> socios;
    private ArrayList<Libro> libros;

    // Constructores 
    public Biblioteca(String p_nombre) {
        this.setNombre(p_nombre);
        this.setSocios(new HashMap<Integer,Socio>());
        this.setLibros(new ArrayList<Libro>());
    }

    public Biblioteca(String p_nombre,HashMap<Integer,Socio> p_socios) {
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(new ArrayList<Libro>());
    } 

    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros) {
        this.setNombre(p_nombre);
        this.setSocios(new HashMap<Integer,Socio>());
        this.setLibros(p_libros);
    }

    public Biblioteca(String p_nombre, HashMap<Integer,Socio> p_socios,  ArrayList<Libro> p_libros) {
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros);
    }

    // Setters
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setLibros(ArrayList<Libro> p_libros){
        this.libros = p_libros;
    }

    private void setSocios(HashMap<Integer,Socio> p_socios){
        this.socios = p_socios;
    }

    // Getters
    public String getNombre(){
        return this.nombre;
    }

    public HashMap<Integer,Socio> getSocios(){
        return this.socios;
    }

    public ArrayList<Libro> getLibros(){
        return this.libros;
    }

    /**
     * Agrega un libro al inventario de la biblioteca.
     * @param p_libro Objeto {@code Libro} a agregar
     */
    public void agregarLibro(Libro p_libro){
        this.getLibros().add(p_libro);
    }

    /**
     * Elimina un libro del inventario.
     * @param p_libro Libro a quitar de la lista
     */
    public void quitarLibro(Libro p_libro){
        this.getLibros().remove(p_libro);
    }

    /**
     * Registra un nuevo socio en la biblioteca.
     * @param p_socio Socio a agregar al sistema
     */
    public void agregarSocio(Socio p_socio){
        this.getSocios().put(new Integer(p_socio.getDni()) , p_socio);
    }  

    /**
     * Elimina un socio del registro.
     * @param p_socio Socio a eliminar
     */
    public void eliminarSocio(Socio p_socio){
        this.getSocios().remove(new Integer(p_socio.getDni()));
    }

    /**
     * Crea y agrega un nuevo libro al inventario.
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.agregarLibro(new Libro(p_titulo, p_edicion, p_editorial, p_anio));
    }

    /**
     * Registra un nuevo socio de tipo estudiante.
     */
    public void nuevoSocioEstudiante(int p_dni, String p_nombre, int p_diasPrestamo, String p_carrera){
        this.agregarSocio(new Estudiante(p_dni, p_nombre, p_diasPrestamo, p_carrera));
    }

    /**
     * Registra un nuevo socio de tipo docente.
     */
    public void nuevoSocioDocente(int p_dni, String p_nombre, int p_diasPrestamo, String p_area){
        this.agregarSocio(new Docente(p_dni, p_nombre, p_diasPrestamo, p_area));
    }

    /**
     * Registra la devolución de un libro. 
     * Lanza una excepción si el libro no está prestado.
     * 
     * @param p_libro Libro a devolver
     * @throws LibroEnBibliotecaException Si el libro ya se encuentra en la biblioteca
     */
    public void devolverLibro(Libro p_libro) throws LibroEnBibliotecaException {
        if (p_libro.prestado()) {
            Prestamo prestamoActivo = p_libro.ultimoPrestamo();
            if (prestamoActivo != null) {
                prestamoActivo.registrarFechaDevolucion(new GregorianCalendar());
            } else {
                throw new RuntimeException("Error interno: Libro marcado como prestado sin un préstamo activo.");
            }
        } else {
            throw new LibroEnBibliotecaException("El libro '" + p_libro.getTitulo() + "' no se puede devolver ya que se encuentra en la biblioteca\n");
        }
    }

    /**
     * Devuelve la cantidad de socios de un tipo específico.
     * 
     * @param p_tipo Tipo de socio ("Docente" o "Estudiante")
     * @return Cantidad de socios de ese tipo
     */
    public int cantidadDeSociosPorTipos(String p_tipo){
        int cont = 0;
        for(Map.Entry<Integer,Socio> entrada : this.getSocios().entrySet()){
            if(entrada.getValue().soyDeLaClase().equalsIgnoreCase(p_tipo)){
                cont++;
            }
        }
        return cont;
    }

    /**
     * Devuelve una lista con los préstamos vencidos al día actual.
     * 
     * @return Lista de préstamos vencidos
     */
    public ArrayList prestamosVencidos(){
        Calendar fechaActual = Calendar.getInstance();
        ArrayList prestamosVencidos = new ArrayList();
        for(Map.Entry<Integer,Socio> entrada : this.getSocios().entrySet()){
            for(Prestamo unPrestamo : entrada.getValue().getPrestamos()){
                if(unPrestamo.vencido(fechaActual)){
                    prestamosVencidos.add(unPrestamo);
                }
            }
        }
        return prestamosVencidos;
    }

    /**
     * Genera un listado con los datos de todos los socios registrados.
     * @return Cadena con el listado formateado
     */
    public String listarSocio(){
        StringBuilder auxListado = new StringBuilder();
        int n=0;
        auxListado.append("Lista de Socios: \n");
        for(Map.Entry<Integer,Socio> entrada : this.getSocios().entrySet()){
            n++;
            auxListado.append(n + ") ");
            auxListado.append(entrada.getValue().toString());
            auxListado.append("\n");
        }
        return auxListado.toString();
    }

    /**
     * Devuelve un listado completo de libros con su estado de préstamo.
     */
    public String listaDeLibro(){
        StringBuilder auxListado = new StringBuilder();
        int n=0;
        auxListado.append("Lista de Libros: \n");
        for(Libro unLibro : this.getLibros()){
            n++;
            auxListado.append(n + ") ");
            auxListado.append(unLibro.toString() + "|| Prestado: "+ (unLibro.prestado() ? "Si" : "No"));
            auxListado.append("\n");
        }
        return auxListado.toString();
    }

    /**
     * Devuelve un listado con los títulos de los libros registrados.
     */
    public String listaDeTitulos(){
        StringBuilder auxListado = new StringBuilder();
        int n=0;
        for(Libro unLibro : this.getLibros()){
            n++;
            auxListado.append(n + ") ");
            auxListado.append(unLibro.toString());
            auxListado.append("\n");
        }
        return auxListado.toString();
    }

    /**
     * Devuelve una lista de docentes que son responsables de préstamos activos.
     */
    public String listaDeDocentesResponsables() {
        StringBuilder auxListado = new StringBuilder();
        auxListado.append("Lista de Docentes Responsables:\n");
        for (Socio unDocente : this.docentesResponsables()) {
            auxListado.append("* ").append(unDocente.toString()).append("\n");
        }
        return auxListado.toString();
    }

    /**
     * Registra un préstamo de un libro a un socio si las condiciones lo permiten.
     * 
     * @return true si se realizó el préstamo, false en caso contrario
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        if (p_socio != null) {
            if (p_socio.puedePedir() && !p_libro.prestado()) {
                p_socio.agregarPrestamo(new Prestamo(p_fechaRetiro, p_libro, p_socio));
                p_libro.agregarPrestamo(new Prestamo(p_fechaRetiro, p_libro, p_socio));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Indica qué socio tiene actualmente un libro prestado.
     * 
     * @param p_libro Libro a consultar
     * @return Nombre del socio que posee el libro
     * @throws LibroEnBibliotecaException Si el libro está en la biblioteca
     */
    public String quienTieneElLibro(Libro p_libro) throws LibroEnBibliotecaException{
        if (p_libro.prestado()) {
            return p_libro.ultimoPrestamo().getSocio().getNombre();
        } else {
            throw new LibroEnBibliotecaException("El libro '" + p_libro.getTitulo() + "' se encuentra en la biblioteca\n");
        }
    }

    /**
     * Devuelve una lista con los docentes responsables (que poseen préstamos vigentes).
     */
    public ArrayList<Docente> docentesResponsables() {
        ArrayList<Docente> docentesResponsables = new ArrayList<>(); 
        for (Map.Entry<Integer, Socio> entry : this.getSocios().entrySet()) { 
            Socio socio = entry.getValue(); 
            if (socio.soyDeLaClase().equalsIgnoreCase("Docente")) {
                Docente unDocente = (Docente) socio;
                if (unDocente.esResponsable()) {
                    docentesResponsables.add(unDocente);
                }
            }
        }
        return docentesResponsables;
    }

    /**
     * Busca y devuelve un socio por su DNI.
     */
    public Socio buscarSocio(int p_dni) {
        return this.getSocios().get(p_dni);
    }
}
