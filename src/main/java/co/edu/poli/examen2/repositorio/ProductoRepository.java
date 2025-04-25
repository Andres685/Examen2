package co.edu.poli.examen2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.examen2.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{

}
