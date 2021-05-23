package br.com.lab.orders.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.lab.orders.api.dtos.OrderDTO;
import br.com.lab.orders.repositories.entities.Order;
import br.com.lab.orders.repositories.interfaces.OrderRepository;
import br.com.lab.orders.repositories.specifications.OrderSpecification;
import br.com.lab.orders.services.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	<S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
		
	
	public List<OrderDTO> findAll(String status, Integer page, Integer pageSize){
		List<Order> orders;
		
		if(page != null && pageSize !=null ) {
			Pageable paging = PageRequest.of(page, pageSize);
			orders = orderRepository.findAll(status, paging);
		} else {
			orders = orderRepository.findAll(Specification.where(OrderSpecification.status(status)));
		}
					
		orders
		.stream()
		.map((src)->  {			
				src.setTotal(src
						.getItems()
						.stream()
						.map(item-> item.getProduct().getPrice() * item.getQuantity())
						.reduce(0.0,Double::sum));
				return src.getTotal();
				
				}
			).collect(Collectors.toList());
		
		

		
		modelMapper.typeMap(Order.class, OrderDTO.class)
        .setPropertyCondition(context -> true).addMappings(mapper -> {
       	
			mapper.map(src-> src.getItems(), OrderDTO::setItemsDTO);
			
		});
		
		
		return mapList(orders, OrderDTO.class);
	}

	@Override
	public OrderDTO findById(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		
	}
	
}
