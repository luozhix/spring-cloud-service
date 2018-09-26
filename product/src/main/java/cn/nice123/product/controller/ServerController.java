package cn.nice123.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ServerController {

	@GetMapping("/msg")
	public String msg() {
		return "this is a product message!";
	}
}
