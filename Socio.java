import java.util.*;
/**
 * Write a description of class Socio here.
 * 
 * @author Aguirre Mauricio Alejandro
 * @version 25/10/25
 */
public abstract class Socio
{
    private int dniSocio, diasPrestamo;
    private String nombre;
    private ArrayList<Prestamo> prestamos;

    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }

    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(p_prestamos);
    }

    private void setDniSocio(int p_dniSocio){
        this.dniSocio = p_dniSocio;
    }

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setDiasPrestamo(int p_diasPrestamo){
        this.diasPrestamo = p_diasPrestamo;
    }

    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }

    public int getDniSocio(){
        return this.dniSocio;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }

    public void agregarPrestamo(Prestamo p_prestamo){
        this.getPrestamos().add(p_prestamo);
    }

    public boolean quitarPrestamo(Prestamo p_prestamo){
        if(this.getPrestamos().size() > 1){
            return this.getPrestamos().remove(p_prestamo);
        } else {
            return false;
        }
    }

    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }

    public int cantLibroPrestados(){
        int lib = 0;
        for(int i = 0; i < this.getPrestamos().size(); i++){
            if(this.getPrestamos().get(i).getFechaDevolucion() == null){
                lib++;
            }
        }
        return lib;
    }

    public String toString(){
        return "D.N.I.: "+this.getDniSocio()+" || "+this.getNombre()+"("+this.soyDeLaClase()+") || Libros Prestados: "+this.cantLibroPrestados();
    }

    public boolean puedePedir(){
        Calendar hoy = new GregorianCalendar();
        boolean puede = true;
        for(Prestamo unPrestamo: this.getPrestamos()){
            puede = (puede && unPrestamo.vencido(hoy));
        }
        return puede;
    }
    
    public abstract String soyDeLaClase();
}