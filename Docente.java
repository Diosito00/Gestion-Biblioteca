/**
 * La clase Docente hereda de Socio
 * Tiene beneficios adicionales y reglas de responsabilidad
 * Permite ver su historial de prestamos y cambiar sus dias de prestamo
 * @author (Escubilla Micaela Belén) 
 * @version (28/10/2025)
 */
import java.util.Calendar;
import java.util.ArrayList;
public class Docente extends Socio{
    private String area;
    /**
     * Constructor de la clase Docente
     * @param int p_dni
     * @param String p_nombre 
     * @param int p_diasPrestamo 
     * @param String p_area 
     */
    public Docente(int p_dni, String p_nombre, int p_diasPrestamo, String p_area){
        super(p_dni, p_nombre, p_diasPrestamo);
        this.setArea(p_area);
    }

    // Setters
    /**
     * Establece el area del docente.
     * @param p_area el nuevo valor para el area
     */
    private void setArea(String p_area){
        this.area = p_area;
    }

    // Getters
    /**
     * Obtiene el area al que pertenece el docente
     * @return String con el area del docente
     */
    public String getArea(){
        return this.area;
    }

    // Métodos
    /**
     * Verifica el historial del Docente para ver si es responsable
     * @return true si el docente es responsable, nunca tuvo ni tiene un prestamo vencido
     */
    public boolean esResponsable(){
        Calendar fechaHoy = Calendar.getInstance(); //creo objeto Calendar para indicar la fecha actual
        for(Prestamo unPrestamo : super.getPrestamos()){ //inicia bucle, devuelve la lista de todos los objetos Prestamo del docente
            if(unPrestamo.getFechaDevolucion() != null){ //si el prestamo tiene una fecha de devolucion significa que el libro fue devuelto a tiempo
                if (unPrestamo.vencido(unPrestamo.getFechaDevolucion())){ //llama al metodo vencido de Prestamo y pasa como parametro la fechaDevolucion 
                    //si es true entonces la fecha de devolucion fue posterior a la fecha limite lo que significa que hubo en algun momento un prestamo vencido 
                    return false;
                }
            } else { //si no hay fecha de devolucion el libro no fue devuelto
                if (unPrestamo.vencido(fechaHoy)){ //llama al metodo vencido de Prestamo con fechaHoy, si es true el docente tiene en este momento un prestamo vencido 
                    return false; 
                }
            }
        }
        return true; //si al recorrer todo el bucle de los prestamos tanto pasados como presentes sin que se cumpla las condiciones entonces 
        //el docente es responsable y nunca tuvo un prestamo vencido
    }

    /**
     * Agrega dias de prestamo a la cantidad de dias base del docente como recomprensa por la responsabilidad
     * @param int p_dias, cantidad de dias que se pueden agregar al periodo de prestamo
     */
    public void cambiarDiasDePrestamo(int p_dias){
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }

    /**
     * Determina si el docente puede pedir un nuevo libro
     * @return true si el docente es responsable
     */
    @Override
    public boolean puedePedir(){
        return this.esResponsable();
    }

    /**
     * Devuelve el tipo de clase del socio
     * @return un String "Docente"
     */
    @Override
    public String soyDeLaClase(){
        return "Docente";
    }
}