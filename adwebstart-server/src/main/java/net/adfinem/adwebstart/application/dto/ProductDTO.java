/**
 * AdWebStart - A snippet that can be used to create a web project with
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/adwebstart
 * License:    GNU General Public License v3.0  see: LICENSE
 */

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
