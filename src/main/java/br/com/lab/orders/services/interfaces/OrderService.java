package br.com.lab.orders.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lab.orders.api.dtos.OrderDTO;

@Service
public interface OrderService {

	public List<OrderDTO> getAll(String Status, Integer page, Integer pageSize);
	public OrderDTO findById(OrderDTO orderDTO);
	public void save(OrderDTO orderDTO);
	public void delete(OrderDTO orderDTO);
	
		
}
