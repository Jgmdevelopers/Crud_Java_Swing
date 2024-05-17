
package conexion;


public class ProbarConexion {
    public static void main(String[] args) {
        // Crear una instancia de ConexionMysql para probar la conexión
        ConexionMysql conexionMysql = new ConexionMysql();
        
        // Cerrar la conexión después de la prueba
        conexionMysql.closeConnection();
    }
}
