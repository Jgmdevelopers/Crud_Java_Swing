package controlador;

import dao.ProductoDao;
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
    
    
    
}
