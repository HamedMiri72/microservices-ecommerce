package com.hamed.order.orderline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface orderLineRepository extends JpaRepository<OrderLine, Integer> {
}
