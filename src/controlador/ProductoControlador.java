package controlador;

import dao.ProductoDao;
import java.util.*;
import modelo.ProductoModelo;


public class ProductoControlador {
    
    private ProductoDao productoDao;

    public ProductoControlador() {
        this.productoDao = new ProductoDao();
    }
    
    public boolean registrar(ProductoModelo productoModelo){
        boolean respuesta = this.productoDao.registrar(productoModelo);
        return respuesta;
        
    }
    
    public List<ProductoModelo> listar(){
        List<ProductoModelo> listaProductos = this.productoDao.listar();
        return listaProductos;
              
    }
    
    
}
