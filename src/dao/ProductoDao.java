package dao;

import conexion.ConexionMysql;
import modelo.ProductoModelo;
import java.sql.*;
import java.util.*;

public class ProductoDao {
    
    private ConexionMysql fabricaConexion;

    public ProductoDao() {
        this.fabricaConexion = new ConexionMysql();
    }
    
    public boolean registrar (ProductoModelo productoModelo){
        try {
             String SQL = "INSERT INTO tb_producto(codigo, nombre, categoria, compra, venta, obsequio, precio, estado ) "
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
    
    public List<ProductoModelo> listar(){
        
        List<ProductoModelo> listaProductos = new ArrayList<>();
        
        try {
            
            String SQL = "SELECT * FROM tb_producto";
            
            Connection connection = this.fabricaConexion.getConnection();
            
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            
            ResultSet resultado = sentencia.executeQuery();
            
            while (resultado.next()){
                ProductoModelo prod = new ProductoModelo();
                
                prod.setId(resultado.getInt(1));
                prod.setCodigo(resultado.getString(2));
                prod.setNombre(resultado.getString(3));
                prod.setCategoria(resultado.getString(4));
                prod.setCompra(resultado.getBoolean(5));
                prod.setVenta(resultado.getBoolean(6));
                prod.setObsequio(resultado.getBoolean(7));
                prod.setPrecio(resultado.getDouble(8));
                prod.setEstado(resultado.getString(9));
                
                listaProductos.add(prod);
            }
            resultado.close();
            sentencia.close();
            connection.close();
            
        } catch (Exception e) {
               // Manejo de errores durante la conexión
             System.out.println("Ocurrio un error en el proceso dao de listar los producto");
             System.out.println("Mensaje del error: "+e.getMessage());
             System.out.println("Detalles del error");
             
             e.printStackTrace();
        }
           
        return listaProductos;
    }
}
 