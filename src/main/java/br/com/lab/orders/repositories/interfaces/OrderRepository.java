package br.com.lab.orders.repositories.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.lab.orders.repositories.entities.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer>{
	
	@Query("select distinct o from Order o inner join o.items i inner join i.product p where o.status=:status")
	public List<Order> getAll(@Param("status") String status, Pageable paging);
	
	@Query("select distinct o from Order o inner join o.items i inner join i.product p where o.status=:status or o.status is null")
	public List<Order> getAll(@Param("status") String status);

}
