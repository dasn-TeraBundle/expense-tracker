package com.innova.et.adminservice.service;

import com.innova.et.common.service.GenericService;

import static com.innova.et.adminservice.dto.MerchantDto.MerchantDtoRequest;
import static com.innova.et.adminservice.dto.MerchantDto.MerchantDtoResponse;

public interface MerchantService extends GenericService<MerchantDtoRequest, MerchantDtoResponse, String> {
}
