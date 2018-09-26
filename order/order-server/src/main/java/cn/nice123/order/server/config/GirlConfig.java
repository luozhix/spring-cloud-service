package cn.nice123.order.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Created by 廖师兄 2018-02-03 22:25
 */
@Data
@Component
@ConfigurationProperties(prefix = "girl")
@RefreshScope
public class GirlConfig {

	private String name;

	private Integer age;
}
