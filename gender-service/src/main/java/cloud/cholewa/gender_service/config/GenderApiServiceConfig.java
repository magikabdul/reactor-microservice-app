package cloud.cholewa.gender_service.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("services.gender-api")
public record GenderApiServiceConfig(
        @NotNull String scheme,
        @NotNull String host,
        @NotNull String path,
        @NotNull String key
) {
}
