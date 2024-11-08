package com.pet_haven.Pet.Haven.Util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    private HttpStatus status;
    private String message;

    public GenericResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
