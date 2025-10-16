
package fusanjose;


public class Persona 
{
    public String nombre, apellido, tel, correo;
    public int edad;
    
    public Persona()
    {
        
    }

    public Persona(String nombre, String apellido, String tel, String correo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tel = tel;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return  "" + nombre + " | " + apellido + " | " + tel + " | " + correo + " | " +  edad ;
    }
}
