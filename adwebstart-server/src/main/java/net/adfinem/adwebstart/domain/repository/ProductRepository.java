/**
 * AdWebStart - A snippet that can be used to create a web project with
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/bps2
 * License:    GNU General Public License v3.0  see: LICENSE
 */
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
