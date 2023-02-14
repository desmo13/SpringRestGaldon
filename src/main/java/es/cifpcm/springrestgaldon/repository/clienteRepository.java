package es.cifpcm.springrestgaldon.repository;


import es.cifpcm.springrestgaldon.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<Customer, Long> {

}
