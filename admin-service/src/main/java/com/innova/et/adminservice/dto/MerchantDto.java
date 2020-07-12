package com.innova.et.adminservice.dto;

import com.innova.et.adminservice.beans.Merchant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MerchantDto {

    private MerchantDto() { }

    public static Merchant convert(MerchantDtoRequest request) {
        return new Merchant(request.getName(), request.getAcceptedPaymentModes());
    }

    public static MerchantDtoResponse convert(Merchant merchant) {
        MerchantDtoResponse response = new MerchantDtoResponse();
        response.setId(merchant.getId());
        response.setName(merchant.getName());
        response.setAcceptedPaymentModes(merchant.getPaymentModes());
        return response;
    }

    public static List<MerchantDtoResponse> convert(List<Merchant> merchants) {
        return merchants
                .stream()
                .map(MerchantDto::convert)
                .collect(Collectors.toList());
    }

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
