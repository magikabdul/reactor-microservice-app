package cloud.cholewa.gender_service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class GenderReply {
    public static final String JSON_PROPERTY_GENDER = "gender";
    String gender;
    public static final String JSON_PROPERTY_ACCURACY = "accuracy";
    String accuracy;
}
