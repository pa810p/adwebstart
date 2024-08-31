/**
 * AdWebStart - A snippet that can be used to create a web project with
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/adwebstart
 * License:    GNU General Public License v3.0  see: LICENSE
 */
package net.adfinem.adwebstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages =
        "net.adfinem.adwebstart.infrastructure.repository")
@EntityScan("net.adfinem.adwebstart.domain.entity")
public class AdWebStart {
    public static void main(String[] args) {
        SpringApplication.run(AdWebStart.class, args);
    }
}
