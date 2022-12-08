package cloud.cholewa.gender_service.controller;

import cloud.cholewa.gender_service.model.GenderResponse;
import cloud.cholewa.gender_service.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/gender/{name}")
    public Mono<ResponseEntity<GenderResponse>> retrieveGender(@PathVariable String name) {
        //TODO remove block
        return Mono.just(ResponseEntity.ok(genderService.retrieveGender(name).block()));
    }
}
