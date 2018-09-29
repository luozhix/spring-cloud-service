package cn.nice123.product.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.nice123.product.common.DecreaseStockInput;
import cn.nice123.product.common.ProductInfoOutput;

@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

	@PostMapping("/product/listForOrder")
	List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

	@PostMapping("/product/decreaseStock")
	void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

	@Component
	static class ProductClientFallback implements ProductClient {

		@Override
		public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

		}

		@Override
		public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
