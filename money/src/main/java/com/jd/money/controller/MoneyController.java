package com.jd.money.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jd.money.pojo.Money;
import com.jd.money.result.ResponseResult;
import com.jd.money.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("money")
public class MoneyController {

    @Autowired
    MoneyService moneyService;

    /**
     * 查询红包
     * @return
     */
    @GetMapping("moneyList")
    public ResponseResult listMoney(){
        List<Money> moneyList = moneyService.listMoney();
        return new ResponseResult("查询成功",JSON.toJSONString(moneyList));
    }
    /**
     * 创建红包
     */
    @PostMapping("createMoney")
    public ResponseResult createMoney(
            @RequestParam("producer") String producer,
            @RequestParam("money") BigDecimal money
            ){
        Money m = new Money();
        m.setProducer(producer);
        m.setMoney(money);

        try {
            moneyService.createMoney(m);
            return new ResponseResult(1111,"创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(0000,"创建失败");
        }
    }

    /**
     * 通过ID查询红包
     * @param id
     * @return
     */
    @GetMapping("getMoney/{id}")
    public ResponseResult getMoney(@PathVariable Integer id){
        try {
            Money money = moneyService.getMoney(id);
            return new ResponseResult("查询成功",JSONObject.toJSON(money).toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(0000,"查询失败");
        }
    }

    /**
     * 更新红包
     * @param id
     * @param consumer
     * @return
     */
    @PutMapping("updateMoney/{id}")
    public ResponseResult updateMoney(
            @PathVariable("id") Integer id,
            @RequestParam("consumer") String consumer
    ){
        try {
            moneyService.updateMoney(id, consumer);
            return new ResponseResult(1111,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(0000,"更新失败");
        }
    }
    /**
     * 限制条件
     * @param money
     * @param bindingResult
     * @return
     */
    @PostMapping("/limit")
    public String limit(@Valid Money money, BindingResult bindingResult){
        if (money.getMoney().doubleValue() < 2.0){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "您的金额符合要求！！！";
    }
}
