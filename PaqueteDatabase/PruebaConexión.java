package Database;

public class PruebaConexion {
	public static void main(String[] args) {
		
		//Creo un objeto de tipo conexión y hago referencia a la clase Conexión junto a su método getInstancia
		Conexion con = Conexion.getInstancia();
		//Llamada al método conectar
		con.conectar();
		//Condicional para comprobar el estado de la conexión
		if(con.cadena!=null) {
			System.out.println("Conectado");
		}
		else {
			System.out.println("Desconectado");
		}
		
		
		
	}
	
}
