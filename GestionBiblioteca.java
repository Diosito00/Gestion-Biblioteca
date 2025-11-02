/**

 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionBiblioteca {

    public static void main(String[] args) {
        
        // 1. Instanciar la Biblioteca
        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central");
        System.out.println("Se ha creado la " + miBiblioteca.getNombre() + "\n");

        // 2. Instanciar Socios (Estudiantes y Docentes) usando los métodos de Biblioteca 
        // (dni, nombre, diasPrestamo, area/carrera)
        
        // Docentes (días de préstamo iniciales 5 según consigna [cite: 9])
        miBiblioteca.nuevoSocioDocente(14524782, "Juan Perez", 5, "Informática");
        miBiblioteca.nuevoSocioDocente(17982110, "Juan Fernández", 5, "Matemática");
        miBiblioteca.nuevoSocioDocente(10912002, "María Alegre", 5, "Letras");

        // Estudiantes (días de préstamo 20 según consigna [cite: 7])
        miBiblioteca.nuevoSocioEstudiante(28987498, "Francisco Paenza", 20, "Ingeniería");
        miBiblioteca.nuevoSocioEstudiante(31987123, "Cesar Milstein", 20, "Medicina");

        // 3. Instanciar Libros usando los métodos de Biblioteca 
        // (titulo, edicion, editorial, anio)
        miBiblioteca.nuevoLibro("JAVA. Como Programar", 9, "Pearson", 2014);
        miBiblioteca.nuevoLibro("Longman. Diccionario Pocket", 1, "Longman", 2010);
        miBiblioteca.nuevoLibro("Vivir para contarla", 1, "Sudamericana", 2002);
        
        // Libro para la pregunta 4 [cite: 104]
        miBiblioteca.nuevoLibro("Programando con JAVA", 1, "Editorial X", 2020); 

        System.out.println("... Socios y Libros cargados en el sistema ...\n");

        // 4. Responder a las preguntas de la consigna [cite: 99]

        // --- Pregunta: ¿Qué cantidad de socios de tipo Estudiante hay? [cite: 101] ---
        // (Se muestra también Docente, replicando el formato de ejemplo del PDF [cite: 74, 75])
        System.out.println("--- Cantidad de Socios por Tipo ---");
        int cantEstudiantes = miBiblioteca.cantidadDeSociosPorTipos("Estudiante");
        System.out.println("Cantidad de Socios del tipo Estudiante: " + cantEstudiantes); // [cite: 74]
        
        int cantDocentes = miBiblioteca.cantidadDeSociosPorTipos("Docente");
        System.out.println("Cantidad de Socios del tipo Docente: " + cantDocentes); // [cite: 75]
        System.out.println("**************************************\n");


        // --- Pregunta: ¿Cuál es la lista de docentes que nunca han adeudado ni adeudan libros? [cite: 102] ---
        // Se usa el método listaDeDocentesResponsables() que implementa esa lógica [cite: 26, 32, 45]
        System.out.println("--- Lista de Docentes Responsables ---");
        System.out.println(miBiblioteca.listaDeDocentesResponsables());
        System.out.println("**************************************\n");

        // --- Pregunta: ¿Cuál es la lista de libros? ¿Y la de socios? [cite: 103] ---
        System.out.println("--- Lista de Libros ---");
        // Se usa el método 'listaDeLibro' de tu clase Biblioteca.java [cite: 30]
        System.out.println(miBiblioteca.listaDeLibro()); 
        System.out.println("**************************************\n");
        
        System.out.println("--- Lista de Socios ---");
        // Se usa el método 'listarSocio' de tu clase Biblioteca.java [cite: 29]
        System.out.println(miBiblioteca.listarSocio()); 
        System.out.println("**************************************\n");

        // --- Pregunta: ¿Qué socio tiene prestado el libro "Programando con JAVA"? [cite: 104] ---
        
        // Para probar esto, primero debemos prestar el libro.
        Socio socioPrueba = miBiblioteca.buscarSocio(28987498); // Buscamos a Francisco Paenza [cite: 28]
        Libro libroJava = null;
        
        // No hay método buscarLibroPorTitulo, así que lo buscamos manualmente
        for (Libro libro : miBiblioteca.getLibros()) {
            if (libro.getTitulo().equals("Programando con JAVA")) {
                libroJava = libro;
                break;
            }
        }
        
        // Realizamos el préstamo [cite: 21]
        if (libroJava != null && socioPrueba != null) {
            miBiblioteca.prestarLibro(new GregorianCalendar(), socioPrueba, libroJava);
            System.out.println("... (Se presta el libro 'Programando con JAVA' a " + socioPrueba.getNombre() + ") ...\n");
        } else {
            System.out.println("... (No se pudo encontrar el libro o socio para la prueba de préstamo) ...\n");
        }

        // Ahora sí, respondemos la pregunta usando el método 'quienTieneElLibro' [cite: 27]
        System.out.println("--- Quién tiene 'Programando con JAVA' ---");
        try {
            if (libroJava != null) {
                String nombreSocio = miBiblioteca.quienTieneElLibro(libroJava);
                System.out.println("El libro 'Programando con JAVA' lo tiene: " + nombreSocio);
            } else {
                System.out.println("El libro 'Programando con JAVA' no se encontró en la biblioteca.");
            }
        } catch (LibroEnBiblioteca e) {
            // Se maneja la excepción 'LibroEnBiblioteca' que definiste
            System.out.println(e.getMessage());
        }
        System.out.println("**************************************\n");

        // --- Prueba Adicional: ¿Qué pasa si preguntamos por un libro NO prestado? ---
        Libro libroGabo = null;
        for (Libro libro : miBiblioteca.getLibros()) {
            if (libro.getTitulo().equals("Vivir para contarla")) {
                libroGabo = libro;
                break;
            }
        }

        System.out.println("--- Quién tiene 'Vivir para contarla' (Prueba de excepción) ---");
        try {
            if (libroGabo != null) {
                String nombreSocio = miBiblioteca.quienTieneElLibro(libroGabo);
                System.out.println("El libro 'Vivir para contarla' lo tiene: " + nombreSocio);
            }
        } catch (LibroEnBiblioteca e) {
            // El método 'quienTieneElLibro' lanza esta excepción si no está prestado [cite: 27]
            // Tu código en Biblioteca.java implementa esto correctamente.
            System.out.println("Respuesta esperada: \n" + e.getMessage());
        }
        System.out.println("**************************************\n");
    }
}
