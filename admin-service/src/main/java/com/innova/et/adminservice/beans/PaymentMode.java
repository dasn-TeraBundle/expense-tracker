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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentMode that = (PaymentMode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return mode.equals(that.mode);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + mode.hashCode();
        return result;
    }
}
