package cn.nice123.order.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.nice123.order.server.config.GirlConfig;

/**
 * Created by 廖师兄
 * 2018-02-03 22:25
 */
@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print() {
        return "name:" + girlConfig.getName() + " age:" + girlConfig.getAge();
    }
}
