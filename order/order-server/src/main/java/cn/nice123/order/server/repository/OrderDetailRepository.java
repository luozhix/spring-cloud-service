package cn.nice123.order.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.nice123.order.server.dataobject.OrderDetail;

/**
 * Created by 廖师兄 2017-12-10 16:12
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

	List<OrderDetail> findByOrderId(String orderId);
}
