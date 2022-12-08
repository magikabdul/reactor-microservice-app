package cloud.cholewa.gender_service.client;

import cloud.cholewa.gender_service.config.GenderApiServiceConfig;
import cloud.cholewa.gender_service.model.GenderReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class GenderApiClient {

    private final GenderApiServiceConfig genderApiServiceConfig;

    private final WebClient webClient;

    public Mono<GenderReply> retrieveGender(String name) {
        return webClient
                .get()
                .uri(this.genderUri(name))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::isError, this::logError)
                .bodyToMono(GenderReply.class);
    }

    private Mono<? extends Throwable> logError(ClientResponse clientResponse) {
        log.error("[GENDER API] - call error");
        return Mono.error(new Throwable("Gender API error"));

    }

    private Function<UriBuilder, URI> genderUri(String name) {
        return uriBuilder -> uriBuilder.queryParamIfPresent("name", Optional.of(name))
                .build();
    }
}
