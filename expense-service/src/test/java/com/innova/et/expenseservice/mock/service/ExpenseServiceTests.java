package com.innova.et.expenseservice.mock.service;


import com.innova.et.common.dto.CategoryDto;
import com.innova.et.expenseservice.beans.Expense;
import com.innova.et.expenseservice.dao.ExpenseDao;
import com.innova.et.expenseservice.dto.ExpenseDto;
import com.innova.et.expenseservice.exception.InvalidDataException;
import com.innova.et.expenseservice.feign.AdminServiceClient;
import com.innova.et.expenseservice.service.impl.ExpenseServiceImpl;
import feign.FeignException;
import feign.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static com.innova.et.expenseservice.dto.ExpenseDto.convert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTests {

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @Mock
    private ExpenseDao expenseDao;
    @Mock
    private AdminServiceClient adminServiceClient;

    @Test
    void create() {
        List<String> subCategories = Arrays.asList("Bus", "Cab", "Train");
        Set<String> subCategoriesSet = new HashSet<>(subCategories);
        Date date = new Date();

        var request = new ExpenseDto.ExpenseDtoRequest();
        request.setCategory("00000000000000");
        request.setSubCategory("Cab");
        request.setQuantity("1");
        request.setPurchaseDate(date);
        request.setAmount(100);
        request.setMerchant("UBER");
        Expense expenseR = convert(request);

        var expense = mock(Expense.class);
        var dtoResponse = mock(CategoryDto.CategoryDtoResponse.class);

        when(adminServiceClient.getCategoryById("00000000000000")).thenReturn(dtoResponse);
        when(dtoResponse.getSubCategories()).thenReturn(subCategoriesSet);
        when(expenseDao.create(expenseR)).thenReturn(expense);
        when(expense.getId()).thenReturn("111111111111111");

        ExpenseDto.ExpenseDtoResponse response = expenseService.create(request);

        assertNotNull(response);
        assertNotNull(response.getExpenseId());
    }

    @Test
    void create_InvalidDataException() {
        List<String> subCategories = Arrays.asList("Bus", "Cab", "Train");
        Set<String> subCategoriesSet = new HashSet<>(subCategories);
        Date date = new Date();

        var request = new ExpenseDto.ExpenseDtoRequest();
        request.setCategory("00000000000000");
        request.setSubCategory("Plane");
        request.setQuantity("1");
        request.setPurchaseDate(date);
        request.setAmount(100);
        request.setMerchant("INDIGO");

        var dtoResponse = mock(CategoryDto.CategoryDtoResponse.class);

        when(adminServiceClient.getCategoryById("00000000000000")).thenReturn(dtoResponse);
        when(dtoResponse.getSubCategories()).thenReturn(subCategoriesSet);

        assertThrows(InvalidDataException.class, () -> expenseService.create(request));
    }

    @Test
    void create_FeignException404() {
        Date date = new Date();

        var request = new ExpenseDto.ExpenseDtoRequest();
        request.setCategory("00000000000000");
        request.setSubCategory("Plane");
        request.setQuantity("1");
        request.setPurchaseDate(date);
        request.setAmount(100);
        request.setMerchant("INDIGO");

        var httpRequest = Request.create(Request.HttpMethod.GET, "", new HashMap<>(), "".getBytes(), null, null);

        doThrow(new FeignException.NotFound("", httpRequest, "".getBytes()))
                .when(adminServiceClient)
                .getCategoryById("00000000000000");

        assertThrows(InvalidDataException.class, () -> expenseService.create(request));
    }

    @Test
    void create_FeignException504() {
        Date date = new Date();

        var request = new ExpenseDto.ExpenseDtoRequest();
        request.setCategory("00000000000000");
        request.setSubCategory("Plane");
        request.setQuantity("1");
        request.setPurchaseDate(date);
        request.setAmount(100);
        request.setMerchant("INDIGO");

        var httpRequest = Request.create(Request.HttpMethod.GET, "", new HashMap<>(), "".getBytes(), null, null);

        doThrow(new FeignException.GatewayTimeout("", httpRequest, "".getBytes()))
                .when(adminServiceClient)
                .getCategoryById("00000000000000");

        assertThrows(Exception.class, () -> expenseService.create(request));
    }

    @Test
    void findById() {
        assertNull(expenseService.findById("111111111111111"));
    }

    @Test
    void findAll() {
        when(expenseDao.findAll()).thenReturn(new ArrayList<>());

        assertEquals(0, expenseService.findAll().size());
    }

    @Test
    void update() {
        assertNull(expenseService.update("111111111111111", null));
    }

    @Test
    void remove() {
        expenseService.remove("111111111111111");
        expenseService.remove();

        assertTrue(true);
    }
}
