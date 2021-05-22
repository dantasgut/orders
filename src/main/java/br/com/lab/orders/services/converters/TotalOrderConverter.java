package br.com.lab.orders.services.converters;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import br.com.lab.orders.repositories.entities.Order;

@Component
public class TotalOrderConverter extends AbstractConverter<Order,Double>{

	@Override
	public Double convert(Order source) {
		
		return source
				.getItems()
				.stream()
				.map(item-> item.getProduct().getPrice() * item.getQuantity() 
						
					).reduce(0.0,Double::sum);
	}
}
