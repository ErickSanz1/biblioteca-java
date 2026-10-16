package src.modelo;
public class Profesor extends Usuario{
    private String curso;

    public Profesor(){
        super();
    }

    public Profesor(String nombre, String apellido, String curso){
        super(nombre, apellido);
        setCurso(curso);
    }

    public String getCurso(){ return curso;}

    public void setCurso(String curso){
        if(curso == null || curso.isBlank()){
            throw new IllegalArgumentException("Curso no puede ir vacio");
        }
        this.curso = curso.trim();
    }

    @Override 
    public int limitePrestamos(){ return 5;}

    @Override 
    public int diasPrestados(){ return 14;}

    @Override 
    public String toString(){
        return super.toString()
            + " | Curso: " + curso
            + " | Tipo: Profesor";
    }
    
}
