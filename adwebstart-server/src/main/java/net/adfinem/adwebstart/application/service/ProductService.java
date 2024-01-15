package net.adfinem.adwebstart.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.adfinem.adwebstart.domain.entity.Product;
import net.adfinem.adwebstart.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product add(final Product product) {
        return this.productRepository.save(product);
    }

    public Product get(final UUID productId) {
        return this.productRepository.getByProductId(productId);
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product delete(final UUID productId) {
        final Product product = this.productRepository.getByProductId(productId);
        if (product == null) {
            return null;
        } else {
            this.productRepository.delete(product);
        }
        return product;
    }

}
