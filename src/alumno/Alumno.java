package alumno;

public class Alumno
{
    private String codigo;
    private String Nombre;
    private int edad;

    public Alumno() {
    }

    public Alumno(String codigo, String Nombre, int edad) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.edad = edad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
