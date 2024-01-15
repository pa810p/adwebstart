package net.adfinem.adwebstart.application.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

//@Builder
@Jacksonized
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ProductDTO {
    private UUID productId;

    private String name;

    private BigDecimal price;

}
