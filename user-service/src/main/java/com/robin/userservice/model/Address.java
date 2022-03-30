package com.robin.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int houseNumber;
    private String extension;
    private String street;
    private long postalCode;
}
