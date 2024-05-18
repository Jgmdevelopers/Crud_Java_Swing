package conexion;
import java.sql.*;

public class ConexionMysql {

    private Connection connection;
    
    private String usuario = "root";
    private String password = "123456";
    private String servidor = "localhost";
    private String puerto = "3306";
    private String baseDeDatos = "db_crud_java_swing";
   private final String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDeDatos + "?serverTimezone=UTC";
  

    
    // Clase del driver de MySQL
    private final String driver = "com.mysql.cj.jdbc.Driver";

    public ConexionMysql() {
        
        try {
           // Cargar el driver de MySQL
            Class.forName(driver);
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection(url, usuario, password);
            
            if (connection != null) {
                System.out.println("Conexion realizada correctamente");
            }
        } catch (Exception e) {
            // Manejo de errores durante la conexión
             System.out.println("Ocurrio un error en la conexion");
             System.out.println("Mensaje del error: "+e.getMessage());
             System.out.println("Detalles del error");
             
             e.printStackTrace();
        }
        
    }
    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
    
    // Método para cerrar la conexión
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexion cerrada correctamente");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al cerrar la conexion");
            e.printStackTrace();
        }
    }
    

    
}
