package src.modelo;

import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(){
        this(null, null);
    }

    public Prestamo(Libro libro, Usuario usuario){
        setLibro(libro);
        setUsuario(usuario);
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public Libro getLibro(){ return libro;}
    public Usuario getUsuario(){ return usuario;}
    public LocalDate getFechaPrestamo(){ return fechaPrestamo;}
    public LocalDate getFechaDevolucion(){ return fechaDevolucion;}

    public void setLibro(Libro libro){
        if(libro == null){
            throw new IllegalArgumentException("El libro no puede ser null");
        }
        this.libro = libro;
    }

    public void setUsuario(Usuario usuario){
        if(usuario == null){
            throw new IllegalArgumentException("El usuario no puede ir null");
        }
        this.usuario = usuario;
    }

    public boolean isActivo(){
        return fechaDevolucion == null;
    }

    public void devolver(){
        if(fechaDevolucion != null){
            throw new IllegalStateException("Este prestamo ya fue devuelto");
        }
        this.fechaDevolucion = LocalDate.now();
    }

    @Override 
    public String toString(){
        return "Libro: " + libro.getTitulo()
            + " | Usuario: " + usuario.getNombre() + " " + usuario.getApellido()
            + " | Prestamo: " + fechaPrestamo
            + " | Devuelto: " + (fechaDevolucion == null ? "Pendiente" : fechaDevolucion);
    }
}
