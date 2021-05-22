package br.com.lab.orders.services.converters;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import br.com.lab.orders.repositories.entities.Item;
import br.com.lab.orders.repositories.entities.Product;

@Component
public class ProductConverter extends AbstractConverter<Item, Product>{

	@Override
	public Product convert(Item source) {
		
		return source.getProduct();
	}

}
