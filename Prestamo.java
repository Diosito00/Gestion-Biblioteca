import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Clase que representa un préstamo de un libro realizado por un socio.
 * 
 * Contiene información sobre la fecha de retiro, la fecha de devolución,
 * el libro prestado y el socio que lo solicitó. 
 * Permite registrar devoluciones, determinar si un préstamo está vencido 
 * según la fecha actual y mostrar los datos del préstamo formateados.
 * 
 * @author Aguirre Mauricio Alejandro
 * @version 25/10/25
 */
public class Prestamo
{
    private Calendar fechaRetiro, fechaDevolucion;
    private Libro libro;
    private Socio socio;

    /**
     * Constructor que crea un préstamo con fecha de retiro y asocia
     * un libro y un socio. La fecha de devolución se inicializa en null.
     * 
     * @param p_fechaRetiro Fecha en la que se realiza el préstamo
     * @param p_libro Libro prestado
     * @param p_socio Socio que solicita el préstamo
     */
    public Prestamo(Calendar p_fechaRetiro, Libro p_libro, Socio p_socio){
        this.setFechaRetiro(p_fechaRetiro);
        this.setFechaDevolucion(null);
        this.setLibro(p_libro);
        this.setSocio(p_socio);
    }

    // Setters
    private void setFechaRetiro(Calendar p_fechaRetiro){
        this.fechaRetiro = p_fechaRetiro;
    }

    private void setFechaDevolucion(Calendar p_fechaDevolucion){
        this.fechaDevolucion = p_fechaDevolucion;
    }

    private void setLibro(Libro p_libro){
        this.libro = p_libro;
    }

    private void setSocio(Socio p_socio){
        this.socio = p_socio;
    }

    // Getters
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }

    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }

    public Libro getLibro(){
        return this.libro;
    }

    public Socio getSocio(){
        return this.socio;
    }
    
    // Métodos
    /**
     * Registra la fecha en la que el libro es devuelto por el socio.
     * 
     * @param p_fecha Fecha de devolución del préstamo
     */
    public void registrarFechaDevolucion(Calendar p_fecha){
        this.setFechaDevolucion(p_fecha);
    }

    /**
     * Determina si el préstamo está vencido en función de la fecha actual.
     * 
     * Se calcula sumando los días de préstamo permitidos a la fecha de retiro
     * y comparando con la fecha pasada por parámetro.
     * 
     * @param p_fecha Fecha actual a comparar
     * @return true si el préstamo está vencido, false si aún está dentro del plazo
     */
    public boolean vencido(Calendar p_fecha){
        int diasP = this.getSocio().getDiasPrestamo();
        Calendar retiro = this.getFechaRetiro(); // para no modificar el original
        retiro.add(5, diasP);
        return p_fecha.after(retiro);
    }

    /**
     * Devuelve una cadena con la información del préstamo.
     * 
     * Muestra las fechas de retiro y devolución (si existe), junto con los datos
     * del libro y del socio. Si el libro aún no fue devuelto, se indica en el mensaje.
     * 
     * @return Cadena con los datos del préstamo formateados
     */
    public String toString(){
        try{
            Date retiro = this.getFechaRetiro().getTime();
            Date devolucion = this.getFechaDevolucion().getTime();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

            String fr = formato.format(retiro);
            String fd = formato.format(devolucion);
            return "Retiro: " + fr + " - Devolución: " + fd +
                   "\nLibro: " + this.getLibro().getTitulo() +
                   "\nSocio: " + this.getSocio().getNombre();
        } catch(NullPointerException ex){
            // Si la fecha de devolución no existe aún
            System.out.println("El libro aun no ha sido devuelto.");
        } finally {
            Date retiro = this.getFechaRetiro().getTime();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            String fr = formato.format(retiro);
            return "Retiro: " + fr +
                   "\nLibro: " + this.getLibro().getTitulo() +
                   "\nSocio: " + this.getSocio().getNombre();
        }
    }
}
