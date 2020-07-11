package com.innova.et.adminservice.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Set;

@Document(collection = "merchants")
@Getter
@Setter
@NoArgsConstructor
public class Merchant implements Serializable {

    private String id;
    private String name;
    private Set<String> paymentModes;

    public Merchant(String name, Set<String> paymentModes) {
        this.name = name;
        this.paymentModes = paymentModes;
    }
}
