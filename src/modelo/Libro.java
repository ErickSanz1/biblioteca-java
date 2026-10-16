package src.modelo;
public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(){
        this("Sin título", "Sin autor");
    }

    public Libro(String titulo, String autor){
        setTitulo(titulo);
        setAutor(autor);
        this.disponible = true;
    }

    public Libro(String titulo, String autor, boolean disponible){
        setTitulo(titulo);
        setAutor(autor);
        this.disponible = disponible;
    }

    public String getTitulo(){ return  titulo;}
    public String getAutor(){ return autor;}
    public boolean isDisponible(){ return disponible;}

    public void setTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("El titulo no puede ir vacio");
        }
        this.titulo = titulo.trim();
    }

    public void setAutor(String autor){
        if(autor == null || autor.isBlank()){
            throw new IllegalArgumentException("El autor no puede ir vacio");
        }
        this.autor = autor.trim();
    }

    public void prestar(){
        if(!disponible){
            throw new IllegalStateException("El libro ya esta prestado");
        }
        this.disponible = false;
    }

    public void devolver(){
        this.disponible = true;
    }
    
    @Override 
    public String toString(){
        return "Titulo: " + titulo + " | Autor: " + autor + 
                " | Disponible: " + ((disponible) ? "Si" : "No");
    }
}
