package net.adfinem.adwebstart.infrastructure.repository;

import net.adfinem.adwebstart.domain.entity.Product;
import net.adfinem.adwebstart.domain.repository.ProductRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends ProductRepository, CrudRepository<Product, Long> {

}
