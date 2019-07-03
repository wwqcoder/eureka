package com.jd.money.service.impl;

import com.jd.money.pojo.Money;
import com.jd.money.repository.MoneyRepository;
import com.jd.money.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    MoneyRepository moneyRepository;

    @Override
    public List<Money> listMoney() {
        return moneyRepository.findAll();
    }

    @Override
    public void createMoney(Money m) {
        moneyRepository.save(m);
    }

    @Override
    public Money getMoney(Integer id) {
        return moneyRepository.findById(id).orElse(null);
    }

    @Override
    public Money updateMoney(Integer id, String consumer) {
        Optional<Money> optional = moneyRepository.findById(id);
        if (optional.isPresent()){
            Money money = optional.get();
            money.setId(id);
            money.setConsumer(consumer);
            return moneyRepository.save(money);
        }
        return null;
    }
}
