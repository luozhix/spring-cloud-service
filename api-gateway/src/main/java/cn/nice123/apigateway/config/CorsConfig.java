package cn.nice123.apigateway.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		// 允许cookie跨域
		config.setAllowCredentials(true);
		// 允许的原始域
		config.setAllowedOrigins(Arrays.asList("*"));
		// 允许的头
		config.setAllowedHeaders(Arrays.asList("*"));
		// 允许的请求方式
		config.setAllowedMethods(Arrays.asList("*"));
		// 缓存时间
		config.setMaxAge(300l);
		configSource.registerCorsConfiguration("/**", config);
		return new CorsFilter(configSource);
	}
}
