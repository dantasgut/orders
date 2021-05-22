package br.com.lab.orders.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lab.orders.api.dtos.OrderDTO;
import br.com.lab.orders.services.interfaces.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	@ResponseBody
	public List<OrderDTO> getAll(			
			@RequestParam(name="status", required=false) String status,
			@RequestParam(name="page", required=false) Integer page, 
			@RequestParam(name="pageSize", required=false)Integer pageSize){
		return orderService.getAll(status, page, pageSize);
	}
	
}
