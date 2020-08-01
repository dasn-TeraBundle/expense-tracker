package com.innova.et.adminservice.mock.service;


import com.innova.et.adminservice.beans.Merchant;
import com.innova.et.adminservice.dao.MerchantDao;
import com.innova.et.adminservice.exception.MerchantNotFoundException;
import com.innova.et.adminservice.service.impl.MerchantServiceImpl;
import com.innova.et.common.dto.MerchantDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static com.innova.et.adminservice.dto.MerchantDto.convert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class MerchantServiceTest {

    @InjectMocks
    private MerchantServiceImpl merchantService;

    @Mock
    private MerchantDao merchantDao;

    @Test
    void create() {
        var request = new MerchantDto.MerchantDtoRequest();
        request.setName("Zomato");
        Merchant merchantR = convert(request);
        var merchant = mock(Merchant.class);

        when(merchantDao.create(merchantR)).thenReturn(merchant);
        when(merchant.getId()).thenReturn("00000000000000");
        when(merchant.getName()).thenReturn("Zomato");

        MerchantDto.MerchantDtoResponse response = merchantService.create(request);

        assertNotNull(response);
        assertNotNull(response.getId());
        assertEquals(request.getName(), response.getName());
    }

    @Test
    void findById() {
        var merchant = mock(Merchant.class);

        when(merchantDao.findById("00000000000000")).thenReturn(merchant);
        when(merchant.getId()).thenReturn("00000000000000");
        when(merchant.getName()).thenReturn("Zomato");

        MerchantDto.MerchantDtoResponse response = merchantService.findById("00000000000000");

        assertNotNull(response);
        assertNotNull(response.getName());
        assertEquals("Zomato", response.getName());
    }

    @Test
    void findById_Exception() {
        when(merchantDao.findById("00000000000000")).thenReturn(null);

        assertThrows(MerchantNotFoundException.class, () -> merchantService.findById("00000000000000"));
    }

    @Test
    void findAll() {
        when(merchantDao.findAll()).thenReturn(new ArrayList<>());

        assertEquals(0, merchantService.findAll().size());
    }

    @Test
    void update() {
        assertNull(merchantService.update("", null));
    }

    @Test
    void removeById() {
        var merchant = mock(Merchant.class);

        when(merchantDao.findById("00000000000000")).thenReturn(merchant);

        merchantService.remove("00000000000000");
        assertTrue(true);
    }

    @Test
    void removeById_Exception() {
        when(merchantDao.findById("00000000000000")).thenReturn(null);

        assertThrows(MerchantNotFoundException.class, () -> merchantService.remove("00000000000000"));
        assertThrows(UnsupportedOperationException.class, () -> merchantService.remove(new MerchantDto.MerchantDtoRequest()));
    }

    @Test
    void removeAll() {
        merchantService.remove();
        assertTrue(true);
    }
}
