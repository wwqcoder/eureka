package com.jd.money.repository;

import com.jd.money.pojo.Money;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Money,Integer> {
}
