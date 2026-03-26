package com.example.microservicespro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@NoArgsConstructor
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    @NonNull
    @NotBlank(message = "firstname must be set")
    private String firstName;
    @NonNull
    @NotBlank(message = "lastName must be set")
    private String lastName;

}
