package cn.nice123.product.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 廖师兄
 * 2017-12-10 20:37
 */
@RestController
@RequestMapping("/product")
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg";
    }
}
