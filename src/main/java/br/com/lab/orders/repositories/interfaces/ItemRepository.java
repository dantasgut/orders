package br.com.lab.orders.repositories.interfaces;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.lab.orders.repositories.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Query("select i from Item i where id_order=:id")
	public Set<Item> findItemByOrder(@Param("id") Integer idOrder);
}
