package main;
import java.util.Scanner;

import modelo.Estudiante;
import modelo.Libro;
import modelo.Profesor;
import servicio.Biblioteca;

public class Main {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       Biblioteca biblioteca = new Biblioteca();

       precargarDatos(biblioteca);

       int opcion = 1;

       do{
        mostrarMenu();
        System.out.print("Opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> agregarLibro(sc, biblioteca);
            case 2 -> agregarEstudiante(sc, biblioteca);
            case 3 -> agregarProfesor(sc, biblioteca);
            case 4 -> prestarLibro(sc, biblioteca);
            case 5 -> devolverLibro(sc, biblioteca);
            case 6 -> biblioteca.mostrarLibros();
            case 7 -> biblioteca.mostrarUsuarios();
            case 8 -> biblioteca.mostrarPrestamos();
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opcion invalida.");
        }

        System.out.println();
       }while (opcion != 0);

       sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     SISTEMA BIBLIOTECA       ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. Agregar libro             ║");
        System.out.println("║ 2. Agregar estudiante        ║");
        System.out.println("║ 3. Agregar profesor          ║");
        System.out.println("║ 4. Prestar libro             ║");
        System.out.println("║ 5. Devolver libro            ║");
        System.out.println("║ 6. Ver libros                ║");
        System.out.println("║ 7. Ver usuarios              ║");
        System.out.println("║ 8. Ver préstamos             ║");
        System.out.println("║ 0. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");
    }

    private static void agregarLibro(Scanner sc, Biblioteca b){
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        try {
            Libro libro = new Libro(titulo, autor);
            b.agregarLibro(libro);
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void agregarEstudiante(Scanner sc, Biblioteca b){
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Carrera: ");
        String carrera = sc.nextLine();

        try {
            Estudiante e = new Estudiante(nombre, apellido, carrera);
            b.agregarUsuario(e);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void agregarProfesor(Scanner sc, Biblioteca b){
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Curso: ");
        String curso = sc.nextLine();

        try {
            Profesor p = new Profesor(nombre, apellido, curso);
            b.agregarUsuario(p);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void prestarLibro(Scanner sc, Biblioteca b){
        System.out.print("Titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.print("ID del usuario: ");
        int id = sc.nextInt();
        sc.nextLine();

        b.prestar(titulo, id);
    }

    private static void devolverLibro(Scanner sc, Biblioteca b){
        System.out.print("Titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.print("ID del usuario: ");
        int id = sc.nextInt();
        sc.nextLine();

        b.devolver(titulo, id);
    }

    private static void precargarDatos(Biblioteca b){
        b.agregarLibro(new Libro("Cien años de soledad", "García Márquez"));
        b.agregarLibro(new Libro("Clean Code", "Robert Martin"));
        b.agregarLibro(new Libro("El Quijote", "Cervantes"));

        b.agregarUsuario(new Estudiante("Ana", "García", "Ingeniería"));
        b.agregarUsuario(new Estudiante("Pedro", "López", "Medicina"));
        b.agregarUsuario(new Profesor("Luis", "Pérez", "Matemáticas"));
    }
}