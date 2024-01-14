package net.adfinem.adwebstart.application;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Jacksonized
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductDTO {
    private UUID productId;

    private String name;

    private BigDecimal price;

}
