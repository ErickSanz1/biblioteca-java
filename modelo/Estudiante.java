package modelo;
public class Estudiante extends Usuario{
    private String carrera;

    public Estudiante(){
        super();
    }

    public Estudiante(String nombre, String apellido, String carrera){
        super(nombre, apellido);
        setCarrera(carrera);
    }

    public String getCarrera(){ return carrera;}

    public void setCarrera(String carrera){
        if(carrera == null || carrera.isBlank()){
            throw new IllegalArgumentException("La carrera no puede ir vacio");
        }
        this.carrera = carrera.trim();
    }

    @Override 
    public int limitePrestamos(){ return 3;}

    @Override 
    public int diasPrestados(){ return 7;}

    @Override 
    public String toString(){
        return super.toString()
            + " | Carrera: " + carrera
            + " | Tipo: Estudiante"; 
    }
}
