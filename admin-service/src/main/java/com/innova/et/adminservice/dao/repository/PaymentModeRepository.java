package com.innova.et.adminservice.dao.repository;

import com.innova.et.adminservice.beans.PaymentMode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentModeRepository extends MongoRepository<PaymentMode, String> {
}
