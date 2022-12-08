package cloud.cholewa.gender_service.model;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
public class GenderResponse {
    private String name;
    private String gender;
}
