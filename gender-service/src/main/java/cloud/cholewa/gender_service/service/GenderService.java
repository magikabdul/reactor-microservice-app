package cloud.cholewa.gender_service.service;

import cloud.cholewa.gender_service.client.GenderApiClient;
import cloud.cholewa.gender_service.model.GenderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class GenderService {

    private final GenderApiClient genderApiClient;

    public Mono<GenderResponse> retrieveGender(String name) {
        return genderApiClient.retrieveGender(name);
    }
}
