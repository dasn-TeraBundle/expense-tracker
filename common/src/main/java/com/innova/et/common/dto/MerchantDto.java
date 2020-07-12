package com.innova.et.common.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class MerchantDto {

    @Getter
    @Setter
    public static class MerchantDtoRequest {
        @NotNull
        private String name;
        @NotNull
        private Set<String> acceptedPaymentModes;
    }

    @Getter
    @Setter
    public static class MerchantDtoResponse extends MerchantDtoRequest {
        private String id;
    }
}
