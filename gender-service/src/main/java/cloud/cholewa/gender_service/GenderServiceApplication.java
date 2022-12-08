package cloud.cholewa.gender_service;

import cloud.cholewa.gender_service.config.GenderApiServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        GenderApiServiceConfig.class
})
public class GenderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenderServiceApplication.class, args);
    }

}
