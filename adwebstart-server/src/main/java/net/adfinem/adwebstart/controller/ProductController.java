/**
 * AdWebStart - A snippet that can be used to create a web project with
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/adwebstart
 * License:    GNU General Public License v3.0  see: LICENSE
 */
package net.adfinem.adwebstart.controller;

import net.adfinem.adwebstart.application.dto.ProductDTO;
import net.adfinem.adwebstart.application.service.ProductService;
import net.adfinem.adwebstart.domain.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> addProduct(@RequestBody final ProductDTO dto) {
        final Product product = modelMapper().map(dto, Product.class);
        final Product createdProduct = this.productService.add(product);
        modelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return ResponseEntity.ok(modelMapper().map(createdProduct, ProductDTO.class));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final UUID productId) {
        final Product product = this.productService.get(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(
                    modelMapper().map(product, ProductDTO.class)
            );
        }
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProducts() {
        final List<Product> products = this.productService.findAll();
        final List<ProductDTO> productsDto = products.stream()
                .map(this::convertProductToDto)
                .toList();
        return ResponseEntity.ok(productsDto);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID productId) {
        final Product product = this.productService.delete(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok("Product deleted: " + productId);
    }

    private ProductDTO convertProductToDto(final Product product) {
        return modelMapper().map(product, ProductDTO.class);
    }
}
