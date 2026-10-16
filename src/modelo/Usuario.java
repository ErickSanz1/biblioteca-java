package src.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private static int contador = 0;
    
    private int id;
    private String nombre;
    private String apellido;
    private List<Prestamo> prestamos;

    public Usuario(){
        this("Sin nombre", "Sin apellido");
    }

    public Usuario(String nombre, String apellido){
        this.id = ++contador;
        setNombre(nombre);
        setApellido(apellido);
        this.prestamos = new ArrayList<>();
    }

    public int getId(){ return id;}
    public String getNombre(){ return  nombre;}
    public String getApellido(){ return apellido;}
    public List<Prestamo> getPrestamos(){
        return List.copyOf(prestamos);
    }

    public void setNombre(String nombre){
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede ir vacio");
        }
        this.nombre = nombre.trim();
    }

    public void setApellido(String apellido){
        if(apellido == null || apellido.isBlank()){
            throw new IllegalArgumentException("El apellido no puede ir vacio");
        }
        this.apellido = apellido.trim();
    }

    public void agregarPrestamo(Prestamo p){
        prestamos.add(p);
    }

    public abstract int limitePrestamos();
    public abstract int diasPrestados();

    @Override 
    public String toString(){
        return "ID: " + id
            + " | Nombre: " + nombre 
            + " | Apellido: " + apellido;
    }
    
}
