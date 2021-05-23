package br.com.lab.orders.repositories.specifications;

import java.math.BigDecimal;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import br.com.lab.orders.repositories.entities.Item;
import br.com.lab.orders.repositories.entities.Order;
import br.com.lab.orders.repositories.entities.Product;

public class OrderSpecification {
	
	public static Specification<Order> status(String status) {
		return (root, query, builder) -> { 
			Join<Order,Item> item = root.join("items");
			Join<Item, Product> product = item.join("product");
			
			Expression <BigDecimal> subTotal = builder.sum(builder.prod(item.get("quantity"),product.get("price")));
			query.multiselect(root.get("id"), subTotal.alias("total")).distinct(true);
			query.groupBy(root.get("id"));
			return builder.equal(root.get("status"), status);
		};
	}
	
}
