package co.edu.poli.examen2.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.examen2.modelo.Producto;
import co.edu.poli.examen2.repositorio.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }
    public Producto obtenerProductoPorId(String id) {
        return productoRepository.findById(id).orElse(null);
    }
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    public Producto eliminarProducto(String id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            productoRepository.delete(producto);
            return producto;
        }
        return null;
    }
    public Producto actualizarProducto(Producto producto) {
        Producto productoExistente = productoRepository.findById(producto.getId()).orElse(null);
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());  
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            return productoRepository.save(productoExistente);
        }
        return null;
    }
    
}
