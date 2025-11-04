import java.util.*;

/**
 * Clase abstracta que representa a un socio de una biblioteca.
 * 
 * Cada socio posee un DNI, un nombre, una cantidad de días de préstamo 
 * permitidos y una lista de préstamos asociados. Define el comportamiento 
 * común de los distintos tipos de socios, como agregar y quitar préstamos, 
 * verificar si puede solicitar nuevos libros y calcular la cantidad de 
 * libros actualmente prestados.
 * 
 * Las subclases deberán implementar el método {@code soyDeLaClase()} 
 * para indicar su tipo (por ejemplo, “Socio Pleno”, “Socio Vip”, etc.).
 * 
 * @author Aguirre Mauricio Alejandro
 * @version 25/10/25
 */
public abstract class Socio
{
    private int dniSocio, diasPrestamo;
    private String nombre;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor que crea un socio con una lista vacía de préstamos.
     * 
     * @param p_dniSocio DNI del socio
     * @param p_nombre Nombre del socio
     * @param p_diasPrestamo Días máximos permitidos para devolver un libro
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }

    /**
     * Constructor que inicializa un socio con una lista existente de préstamos.
     * 
     * @param p_dniSocio DNI del socio
     * @param p_nombre Nombre del socio
     * @param p_diasPrestamo Días máximos permitidos para devolver un libro
     * @param p_prestamos Lista de préstamos asociados al socio
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(p_prestamos);
    }

    // Setters
    
    private void setDniSocio(int p_dniSocio){
        this.dniSocio = p_dniSocio;
    }

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    protected void setDiasPrestamo(int p_diasPrestamo){
        this.diasPrestamo = p_diasPrestamo;
    }

    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }

    // Getters

    public int getDni(){
        return this.dniSocio;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }

    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }

    /**
     * Agrega un nuevo préstamo a la lista del socio.
     * 
     * @param p_prestamo Préstamo a agregar
     */
    public void agregarPrestamo(Prestamo p_prestamo){
        this.getPrestamos().add(p_prestamo);
    }

    /**
     * Quita un préstamo de la lista, siempre que haya más de uno.
     * 
     * @param p_prestamo Préstamo a quitar
     * @return true si se quitó correctamente, false si no fue posible
     */
    public boolean quitarPrestamo(Prestamo p_prestamo){
        if(this.getPrestamos().size() > 1){
            return this.getPrestamos().remove(p_prestamo);
        } else {
            return false;
        }
    }
    
    // Métodos
    /**
     * Calcula la cantidad de libros que el socio tiene actualmente prestados,
     * es decir, aquellos que no han sido devueltos.
     * 
     * @return Número de libros prestados sin devolver
     */
    public int cantLibroPrestados(){
        int lib = 0;
        for(int i = 0; i < this.getPrestamos().size(); i++){
            if(this.getPrestamos().get(i).getFechaDevolucion() == null){
                lib++;
            }
        }
        return lib;
    }

    /**
     * Devuelve una representación textual del socio, indicando su DNI, nombre,
     * tipo de socio y cantidad de libros prestados.
     * 
     * @return Cadena con la información formateada del socio
     */
    public String toString(){
        return "D.N.I.: "+ this.getDni() +" || "+this.getNombre()+"("+this.soyDeLaClase()+") || Libros Prestados: "+ this.cantLibroPrestados();
    }

    /**
     * Determina si el socio está habilitado para solicitar nuevos préstamos.
     * 
     * El socio podrá hacerlo solo si todos sus préstamos anteriores están
     * devueltos o vencidos según la fecha actual.
     * 
     * @return true si puede pedir libros, false si tiene préstamos activos o no vencidos
     */
    public boolean puedePedir(){
        Calendar hoy = new GregorianCalendar();
        boolean puede = true;
        for(Prestamo unPrestamo: this.getPrestamos()){
            puede = (puede && unPrestamo.vencido(hoy));
        }
        return puede;
    }
    
    /**
     * Método abstracto que devuelve una cadena indicando el tipo de socio.
     * 
     * @return Tipo de socio (por ejemplo, “Pleno”, “Vip”, “Activo”, etc.)
     */
    public abstract String soyDeLaClase();
}
