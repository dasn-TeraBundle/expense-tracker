package com.innova.et.expenseservice.repository;

import com.innova.et.expenseservice.beans.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
