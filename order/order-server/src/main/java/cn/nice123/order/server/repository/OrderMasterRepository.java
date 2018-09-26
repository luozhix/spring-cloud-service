package cn.nice123.order.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cn.nice123.order.server.dataobject.OrderMaster;

/**
 * Created by 廖师兄
 * 2017-12-10 16:11
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
