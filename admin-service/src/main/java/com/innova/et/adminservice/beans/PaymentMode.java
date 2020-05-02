package com.innova.et.adminservice.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "payments")
@Getter
@Setter
@NoArgsConstructor
public class PaymentMode implements Serializable {

    private String id;
    @Indexed(unique = true)
    private String mode;

    public PaymentMode(String mode) {
        this.mode = mode;
    }
}
