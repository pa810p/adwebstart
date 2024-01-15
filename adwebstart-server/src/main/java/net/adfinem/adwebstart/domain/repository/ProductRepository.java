package net.adfinem.adwebstart.domain.repository;

import net.adfinem.adwebstart.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository {

    Product save(Product product);

    void delete(Product productId);

    Product getByProductId(UUID productId);

    List<Product> findAll();

}
