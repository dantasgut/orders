package br.com.lab.orders.repositories.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.lab.orders.repositories.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select p from Product p")
	public List<Product> findAll();
	
	@Query("select p from Product p where id=:id")
	public Optional<Product> findById(@Param("id") Integer id);
}
