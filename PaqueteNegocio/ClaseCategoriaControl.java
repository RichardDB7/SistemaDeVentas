/*Clase de control de categorias para la capa lógica de negocio*/


package negocio;

import datos.CategoriaDAO;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;



public class CategoriaControl { 
    private final CategoriaDAO DATOS; //Constante que instancia la clase categoriaDAO
    private Categoria obj;//Objeto que instancia la entidad categoria
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    
    //Implementación de constructor de tipo público
    public CategoriaControl(){
        this.DATOS=new CategoriaDAO();//Inicio del objeto dato
        this.obj=new Categoria();//Inicio de objeto como instancia de la entidad categoria
        this.registrosMostrados=0;
    }
    
    //Este método devuelve desde la capa lógica de negocio a la capa presentación un table model para ser incluido en el form GUI
    public DefaultTableModel listar(String texto){
        
        List<Categoria> lista=new ArrayList();//Creacion de un objeto List que implementa cada uno de los items siguiendo la entidad categoria
        lista.addAll(DATOS.listar(texto));//Envío de lista de registros referenciado la capa datos
        
        String[] titulos={"Id","Nombre","Descripción","Estado"};//Declaración de columnas de la tabla
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[4];
        
        this.registrosMostrados=0;
        for (Categoria item:lista){//Recorrido del objeto lista
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());//Conversión de dato Int a String
            registro[1]=item.getNombre();
            registro[2]=item.getDescripcion();
            registro[3]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public String insertar(String nombre,String descripcion){
        //Condicional para determinar si el registro es duplicado
        if (DATOS.existe(nombre)){//Si existe devuelve true
            return "El registro ya existe.";
        }else{//Al ser false se envian los valores correspondientes al objeto (obj) que instancia la clase categoria
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            if (DATOS.insertar(obj)){//Si el objeto enviado devuelve true retorna OK
                return "OK";
            }else{//Por la via del falso retorna un error
                return "Error en el registro.";
            }
        }
    }
    
    public String actualizar(int id, String nombre,String nombreAnt,String descripcion){//Ingreso de parametros, donde nombreAnt sirve para evitar duplicados   
        //Condicional que determina si el nombre a modificar es igual al nombre anterior
        if (nombre.equals(nombreAnt)){
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualización.";
            }
        }else{
            if (DATOS.existe(nombre)){
                return "El registro ya existe.";
            }else{
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setDescripcion(descripcion);
                if (DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "Error en la actualización.";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
}
