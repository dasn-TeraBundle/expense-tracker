package com.innova.et.adminservice.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Merchant merchant = (Merchant) o;

        if (id != null ? !id.equals(merchant.id) : merchant.id != null) return false;
        return name.equals(merchant.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }
}
