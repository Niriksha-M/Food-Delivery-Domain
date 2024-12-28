package com.example.Ordert_Services.repository;

import com.example.Ordert_Services.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<OrderInfo,Long> {
    Optional<OrderInfo> findByMenuid(long menuid);

}
