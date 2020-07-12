package com.innova.et.adminservice.service.impl;


import com.innova.et.adminservice.beans.Merchant;
import com.innova.et.adminservice.dao.MerchantDao;
import static com.innova.et.adminservice.dto.MerchantDto.*;

import com.innova.et.adminservice.exception.MerchantNotFoundException;
import com.innova.et.adminservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantDao merchantDao;

    @Autowired
    public MerchantServiceImpl(MerchantDao merchantDao) {
        this.merchantDao = merchantDao;
    }

    @Override
    public MerchantDtoResponse create(MerchantDtoRequest request) {
        return convert(merchantDao.create(convert(request)));
    }

    @Override
    public MerchantDtoResponse findById(String s) {
        Merchant merchant = merchantDao.findById(s);
        if (merchant == null) {
            throw new MerchantNotFoundException();
        }

        return convert(merchant);
    }

    @Override
    public List<MerchantDtoResponse> findAll() {
        return convert(merchantDao.findAll());
    }

    @Override
    public MerchantDtoResponse update(String s, MerchantDtoRequest item) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public void remove(MerchantDtoRequest item) {

    }

    @Override
    public void remove() {

    }
}
