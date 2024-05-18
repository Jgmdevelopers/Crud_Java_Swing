package dao;

import conexion.ConexionMysql;
import modelo.ProductoModelo;
import java.sql.*;

public class ProductoDao {
    
    private ConexionMysql fabricaConexion;

    public ProductoDao() {
        this.fabricaConexion = new ConexionMysql();
    }
    
    public boolean registrar (ProductoModelo productoModelo){
        try {
             String SQL = "INSERT INTO tb_producto(codigo, nombre, categoria,  compra, venta, obsequio, precio, estado ) "
                     + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
             
             Connection connection = this.fabricaConexion.getConnection();
             
             PreparedStatement sentencia = connection.prepareStatement(SQL);
             
             sentencia.setString(1, productoModelo.getCodigo());
             sentencia.setString(2, productoModelo.getNombre());
             sentencia.setString(3, productoModelo.getCategoria());
             
             sentencia.setBoolean(4, productoModelo.isCompra());
             sentencia.setBoolean(5, productoModelo.isVenta());
             sentencia.setBoolean(6, productoModelo.isObsequio());
             
             sentencia.setDouble(7, productoModelo.getPrecio());
             sentencia.setString(8, productoModelo.getEstado());
             
             sentencia.executeUpdate();
             
             sentencia.close();
             connection.close();
             
             return true;
             
        } catch (Exception e) {
              // Manejo de errores durante la conexión
             System.out.println("Ocurrio un error en el proceso dao de registro de producto");
             System.out.println("Mensaje del error: "+e.getMessage());
             System.out.println("Detalles del error");
             
             e.printStackTrace();
             
             return false;
        }
        
    }
    
}
