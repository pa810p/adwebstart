/**
 * AdWebStart - A snippet that can be used to create a web project with
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/adwebstart
 * License:    GNU General Public License v3.0  see: LICENSE
 */
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
        log.debug("add product");
        product.setProductId(UUID.randomUUID());
        return this.productRepository.save(product);
    }

    public Product get(final UUID productId) {
        log.debug("get product");
        return this.productRepository.getByProductId(productId);
    }

    public List<Product> findAll() {
        log.debug("find all products");
        return this.productRepository.findAll();
    }

    public Product delete(final UUID productId) {
        log.debug("delete product by Id:" + productId);
        final Product product = this.productRepository.getByProductId(productId);
        if (product == null) {
            return null;
        } else {
            this.productRepository.delete(product);
        }
        return product;
    }

}
