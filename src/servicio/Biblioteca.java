package src.servicio;

import java.util.ArrayList;
import java.util.List;

import src.modelo.*;

public class Biblioteca{
    private List<Libro> libros = new ArrayList<>(0);
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();

    //Libros
    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    public Libro buscarLibro(String titulo){
        for(Libro i : libros){
            if(i.getTitulo().trim().equals(titulo.trim())) return i;
        }
        return null;
    }
    
    //Usuarios
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(int id){
        for(Usuario u : usuarios){
            if(u.getId() == id) return u;
        }
        return null;
    }

    //Mostrar
    public void mostrarLibros(){
        if(libros.isEmpty()){
            System.out.println("No hay libros registrados.");
            return;
        }
        for(Libro l : libros) System.out.println(l);
    }

    public void mostrarUsuarios(){
        if(usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for(Usuario u : usuarios) System.out.println(u);
    }

    public void prestar(String titulo, int idUsuario){
        //buscar libro
        Libro libro = buscarLibro(titulo);
        if(libro == null){
            System.out.println("Libro no encontrado.");
            return;
        }

        //Buscar usuario
        Usuario usuario = buscarUsuario(idUsuario);
        if(usuario == null){
            System.out.println("Usuario no encontrado.");
            return;
        }

        //Validar que el libro este disponible
        if(!libro.isDisponible()){
            System.out.println("El libro no esta disponible.");
            return;
        }

        //Validar que el usuario no haya alcanzado su limite
        if(usuario.getPrestamos().size() >= usuario.limitePrestamos()){
            System.out.println("El usuario alcanzo su limite de prestamos.");
            return;
        }

        //Crear el prestamo
        Prestamo prestamo = new Prestamo(libro, usuario);
        prestamos.add(prestamo);
        usuario.agregarPrestamo(prestamo);

        //Marcar el libro como no disponible
        libro.prestar();

        System.out.println("Prestamo registrado con exito.");

    }

    public void devolver(String titulo, int idUsuario){
        //Buscar libro y usuario
        Libro libro = buscarLibro(titulo);
        Usuario usuario = buscarUsuario(idUsuario);

        if(libro == null || usuario == null){
            System.out.println("Datos invalidos.");
            return;
        }

        //Buscar el prestamo activo
        Prestamo prestamoActivo = null;
        for(Prestamo p : usuario.getPrestamos()){
            if(p.getLibro().equals(libro) && p.isActivo()){
                prestamoActivo = p;
                break;
            }
        }

        if(prestamoActivo == null){
            System.out.println("No hay un prestamo activo de este libro para este usuario.");
            return;
        }

        //registrar devolucion
        prestamoActivo.devolver();
        libro.devolver();

        System.out.println("Devolucion registrada.");
    }

    
    public void mostrarPrestamos(){
        if(prestamos.isEmpty()){
            System.out.println("No hay prestamos.");
            return;
        }
        for(Prestamo p: prestamos)System.out.println(p);
    }
}
