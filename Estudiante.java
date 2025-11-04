/**
 * La clase Estudiante hereda de Socio
 * Tiene restricciones de prestamo relacionadas con la cantidad maxima de libros
 * @author (Escubilla Micaela Belén) 
 * @version (28/10/2025)
 */
public class Estudiante extends Socio{
    private String carrera;
    /**
     * Constructor de la clase Docente
     * @param int p_dni
     * @param String p_nombre 
     * @param int p_diasPrestamo 
     * @param String p_carrera
     */
    public Estudiante(int p_dni, String p_nombre, int p_diasPrestamo, String p_carrera){
        super(p_dni, p_nombre, p_diasPrestamo);
        this.setCarrera(p_carrera);
    }
    

    // Setters
    /**
     * Establece la carrera del estudiante
     * @param p_carrera el nuevo valor para la carrera
     */
    private void setCarrera(String p_carrera){
        this.carrera = p_carrera;
    }
    
    // Getters
    /**
     * Obtiene la carrera que esta cursando el estudiante
     * @return String con la carrera del estudiante
     */
    public String getCarrera(){
        return this.carrera;
    }
    
    // Métodos
    /**
     * Determina si el Estudiante puede pedir un nuevo libro
     * @return true si el estudiante cumple con las condiciones
     */
    @Override
    public boolean puedePedir(){
        if((super.puedePedir() == true) && this.cantLibroPrestados() <= 3){
            return true;
        } else {
            return false;
        }
    }
    /**
     * Devuelve el tipo de clase del socio
     * @return un String "Estudiante"
     */
    @Override
    public String soyDeLaClase(){
        return "Estudiante";
    }
}