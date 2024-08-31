/**
 * AdWebStart - A snippet that can be used to create a web project with
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/adwebstart
 * License:    GNU General Public License v3.0  see: LICENSE
 */
package net.adfinem.adwebstart.infrastructure.repository;

import net.adfinem.adwebstart.domain.entity.Product;
import net.adfinem.adwebstart.domain.repository.ProductRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends ProductRepository, CrudRepository<Product, Long> {

}
