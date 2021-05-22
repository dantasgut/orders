package br.com.lab.orders.services.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import br.com.lab.orders.repositories.entities.Item;
import br.com.lab.orders.repositories.entities.Product;

@Component
public class ProductListConverter extends AbstractConverter<List<Item>, List<Product>> {

	@Override
	protected List<Product> convert(List<Item> items) {
		return items
		          .stream()
		          .map(Item::getProduct)
		          .collect(Collectors.toList());
	}
	
}
