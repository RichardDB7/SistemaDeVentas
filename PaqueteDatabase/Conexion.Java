
package database;


//Definición de importaciones para gestionar la conexión
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    //Declaración de constantes privadas
    private final String DRIVER="com.mysql.jdbc.Driver"; //Referencia de la clase jdbc
    private final String URL="jdbc:mysql://localhost:3306/"; //Ubicación de la base de datos
    private final String DB="dbsistema"; //Nombre de la base de datos
    private final String USER="root"; //Usuario por defecto
    private final String PASSWORD="";
    
    //Variables Publicas
    public Connection cadena; // Variable que almacena la clase que es el driver jdvc para conectarse a la base de datos
    
    //Aplicación del patrón singleton mediante brindamos un solo punto de acceso global
    public static Conexion instancia;
    
    //Constructor
    private Conexion(){
        this.cadena=null;
    }
    //Método de conexión
    public Connection conectar(){
        //Capturador de exepciones
        try {
            Class.forName(DRIVER);//Llamada a la constante Driver
            this.cadena=DriverManager.getConnection(URL+DB,USER,PASSWORD);//Establecemos la conexión mediante DriverManager con el metodo
            //GetConnection y sus respectivos parámetros, que se guardan en la variable cadena
        } catch (ClassNotFoundException | SQLException e) { //Gestion de problemas en la conexión de la base de datos
            JOptionPane.showMessageDialog(null, e.getMessage());//Mostramos la exepción con JOptionPane mediante el método showMessageDialog
            System.exit(0);
        }
        return this.cadena;//Retorno del valor tipo Connection
    }
    
    //Método de desconexión
    public void desconectar(){
        try {
            this.cadena.close();//Cierre de cadena de conexión
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Método que retorna un objeto de tipo conexión
    public synchronized static Conexion getInstancia(){
        //Comprobación de la existencia de una instancia previa 
        if (instancia==null){
            instancia=new Conexion();
        }
        //Retorno la instancia cada vez que se invoque el método instancia
        return instancia;
    }
}
