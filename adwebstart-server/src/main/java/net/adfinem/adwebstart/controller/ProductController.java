package net.adfinem.adwebstart.controller;

import net.adfinem.adwebstart.application.dto.ProductDTO;
import net.adfinem.adwebstart.application.service.ProductService;
import net.adfinem.adwebstart.domain.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
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
        product.setProductId(UUID.randomUUID());
        final Product createdProduct = this.productService.add(product);
        modelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper().map(createdProduct, ProductDTO.class));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final UUID productId) {
        final Product product = this.productService.get(productId);

        return ResponseEntity.ok(
                modelMapper().map(product, ProductDTO.class)
        );
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
        this.productService.delete(productId);

        return ResponseEntity.ok("ok");
    }

    private ProductDTO convertProductToDto(final Product product) {
        return modelMapper().map(product, ProductDTO.class);
    }
}
