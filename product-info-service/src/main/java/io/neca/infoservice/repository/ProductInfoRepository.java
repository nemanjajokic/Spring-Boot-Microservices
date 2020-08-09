package io.neca.infoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.neca.infoservice.model.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

}
