package br.com.lab.orders.services.converters;

import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import br.com.lab.orders.repositories.entities.Item;
import br.com.lab.orders.repositories.entities.Order;

@Component
public class ItemConverter extends AbstractConverter<Order, Set<Item>>{

	@Override
	protected Set<Item> convert(Order source) {
		return source.getItems();
	}

}
