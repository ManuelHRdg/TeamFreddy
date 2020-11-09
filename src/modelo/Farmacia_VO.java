package modelo;

public class Farmacia_VO {
    private String id;
    private String nombre;
    private String password;
    private String direccion;
    private String c_p;
    private String telefono;
    
    public Farmacia_VO(String id, String nombre, String password, String direccion, String c_p, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
        this.c_p = c_p;
        this.telefono = telefono;
    }
    
    public Farmacia_VO(){        
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setC_p(String c_p) {
        this.c_p = c_p;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getC_p() {
        return c_p;
    }

    public String getTelefono() {
        return telefono;
    }
}