package net.adfinem.adwebstart.controller;

import net.adfinem.adwebstart.application.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> addProduct(@RequestBody final ProductDTO dto) {
        return new ResponseEntity<>(
                ProductDTO.builder().name("a sample product added").build(),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final String id) {
        return new ResponseEntity<>(
                ProductDTO.builder().name("a sample product: " + id).build(),
                HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProducts() {
        final List<ProductDTO> products = Arrays.asList(
                ProductDTO.builder().name("first product").build(),
                ProductDTO.builder().name("second product").build()
        );

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID productId) {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
