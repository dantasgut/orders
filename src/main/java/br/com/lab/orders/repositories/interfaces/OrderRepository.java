package br.com.lab.orders.repositories.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.lab.orders.repositories.entities.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer>, JpaSpecificationExecutor<Order>{
	
	@Query("select distinct o from Order o inner join o.items i inner join i.product p where o.status=:status")
	public List<Order> findAll(@Param("status") String status, Pageable paging);
	
	@Query("select distinct o from Order o inner join o.items i inner join i.product p where o.status=:status")
	public List<Order> findAll(@Param("status") String status);	
	
	public Page<Order> findAll(Specification<Order> specification, Pageable pageable);
	public List<Order> findAll(Specification<Order> specification);

}
