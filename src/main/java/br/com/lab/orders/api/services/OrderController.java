package br.com.lab.orders.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.lab.orders.api.dtos.OrderDTO;
import br.com.lab.orders.services.interfaces.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	@ResponseBody
	public List<OrderDTO> findAll(			
			@RequestParam(name="status", required=false) String status,
			@RequestParam(name="page", required=false) Integer page, 
			@RequestParam(name="pageSize", required=false)Integer pageSize){
		return orderService.findAll(status, page, pageSize);
	}
	
	@ResponseBody
	@GetMapping(value = "/{id}")
	public OrderDTO getById(@PathVariable("id") Integer id) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(id);
		return orderService.findById(orderDTO);
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody OrderDTO orderDTO) {
		orderService.save(orderDTO);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody OrderDTO orderDTO) {
		orderDTO.setId(id);
		//orderDTO.getItemsDTO().forEach(src->src.setId(idItem));
		orderService.save(orderDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Integer id) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(id);
		orderService.delete(orderDTO);
	}
	
}
