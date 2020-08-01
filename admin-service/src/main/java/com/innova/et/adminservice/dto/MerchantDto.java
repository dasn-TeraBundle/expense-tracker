package com.innova.et.adminservice.dto;

import com.innova.et.adminservice.beans.Merchant;

import java.util.List;
import java.util.stream.Collectors;

import static com.innova.et.common.dto.MerchantDto.MerchantDtoRequest;
import static com.innova.et.common.dto.MerchantDto.MerchantDtoResponse;

public class MerchantDto {

    private MerchantDto() {
    }

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
}
