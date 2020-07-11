package com.innova.et.adminservice.dao.repository;

import com.innova.et.adminservice.beans.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<Merchant, String> {
}
