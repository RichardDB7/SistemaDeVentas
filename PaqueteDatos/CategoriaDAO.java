
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


//Se implementa la interface enviando el objeto entidad Categoria
public class CategoriaDAO implements CrudSimpleInterface<Categoria> {
  
    //Declaracion de constantes
    private final Conexion CON;
    private PreparedStatement ps;//Variable que compila la sentencia SQL y se envía al motor de base de datos MYSQL 
    private ResultSet rs;//Almacenamiento y recuperación de los datos de la consulta SQL
    private boolean resp;
    
  //Constructor de la clase
    public CategoriaDAO(){
        //Obtenemos la instancia con su respectivo metodo
        CON=Conexion.getInstancia();
    }
     
    @Override
    public List<Categoria> listar(String texto) {
        //Se crea el objeto list llamado registro donde cada elemento o esquema va a ser de la entidad categoria
        List<Categoria> registros=new ArrayList();
      
        //Creamos el capturador de excepciones 
        try {
            //Envío como texto del código SQL a compilar para ser ejecutado en el motor de base de datos MYSQL  
            ps=CON.conectar().prepareStatement("SELECT * FROM categoria WHERE nombre LIKE ?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();//Aqui se recibe el listado proveniente del prepareStatement y se almacenan en el resultSet
            //recorrido del objeto resultSet
            while(rs.next()){
                //Objeto de tipo List
                registros.add(new Categoria(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        //Al ser un objeto Array List retorna un objeto de tipo List
        return registros;
    }
    
    public List<Categoria> seleccionar() {
        List<Categoria> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT id,nombre FROM categoria ORDER BY nombre asc");
            
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Categoria(rs.getInt(1),rs.getString(2)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    
    
    
    
    //Métodos abstractos
    
    @Override
    public boolean insertar(Categoria obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO categoria (nombre,descripcion,activo) VALUES (?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Categoria obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET nombre=?, descripcion=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getId());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categoria SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros=0;
        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) FROM categoria");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT nombre FROM categoria WHERE nombre=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }           
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
}
