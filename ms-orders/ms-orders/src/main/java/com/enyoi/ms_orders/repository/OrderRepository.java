package com.enyoi.ms_orders.repository;

import com.enyoi.ms_orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
