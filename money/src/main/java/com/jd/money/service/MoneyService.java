package com.jd.money.service;

import com.jd.money.pojo.Money;

import java.util.List;

public interface MoneyService {
    List<Money> listMoney();

    void createMoney(Money m);

    Money getMoney(Integer id);

    Money updateMoney(Integer id, String consumer);
}
