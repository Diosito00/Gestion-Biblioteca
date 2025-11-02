import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Prestamo here.
 * 
 * @author Aguirre Mauricio Alejandro
 * @version 25/10/25
 */
public class Prestamo
{
    private Calendar fechaRetiro, fechaDevolucion;
    private Libro libro;
    private Socio socio;
    
    public Prestamo(Calendar p_fechaRetiro, Libro p_libro, Socio p_socio){
        this.setFechaRetiro(p_fechaRetiro);
        this.setFechaDevolucion(null);
        this.setLibro(p_libro);
        this.setSocio(p_socio);
    }
    
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
    
    public void registrarFechaDevolucion(Calendar p_fecha){
        this.setFechaDevolucion(p_fecha);
    }
    
    public boolean vencido(Calendar p_fecha){
        int diasP = this.getSocio().getDiasPrestamo();
        Calendar retiro = this.getFechaRetiro();
        retiro.add(5, diasP);
        return p_fecha.after(retiro);
    }
    
    public String toString(){
        Date retiro = this.getFechaRetiro().getTime();
        Date devolucion = this.getFechaDevolucion().getTime();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd"); //Formato para mostrar la fecha
        
        String fr = formato.format(retiro);//Convierte a String con el formato anterior
        String fd = formato.format(devolucion);
        return "Retiro: "+fr+" - Devolución: "+fd+"\nLibro: "+this.getLibro().getTitulo()+"\nSocio: "+this.getSocio().getNombre();
    }
}