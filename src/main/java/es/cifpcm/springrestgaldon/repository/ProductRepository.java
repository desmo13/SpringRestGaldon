package es.cifpcm.springrestgaldon.repository;

import es.cifpcm.springrestgaldon.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Producto, Long> {

}
