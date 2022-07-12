
/*Mediante la entidad categoria represento la tabla categoria de la base de datos*/

package entidades;

import java.util.Objects;

public class Categoria {
  
    /*Variables que representan los campos de la tabla categoria, las mismas son de tipo
    privado para evitar el acesso desde otra clase*/
    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    
    //Constructores
    public Categoria() {
        
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
   
    public Categoria(int id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    /*Uso de métodos Setter & getter para acceder a las variables privadas, aplicando el 
    método de encapsulamiento*/
    
    /*Llamado al metodo getId para obtener el valor de la variable Id dentro de la clase, que al 
    ser público me retorna el valor de la variable*/
    public int getId() {
        return id;
    }
    /*Asignacion de valor a la variable Id mediante el método público setId*/
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    //Método toString
    /*Este metodo se emplea para crear una representacion String de un objeto utilizando todo su contenido*/
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.descripcion);
        hash = 89 * hash + (this.activo ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }
    
    
    
}
