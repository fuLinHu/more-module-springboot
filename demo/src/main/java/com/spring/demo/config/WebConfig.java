/**
 * 
 */
package com.spring.demo.config;


import com.spring.demo.Filter.TimeFilter;
import com.spring.demo.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhailiang
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@SuppressWarnings("unused")
	@Autowired
	private TimeInterceptor timeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*registry.addInterceptor(new JJRUserLoginInterceptor()).addPathPatterns("/xx/**")
				.excludePathPatterns("/xx/**");*/
		registry.addInterceptor(timeInterceptor).addPathPatterns("/user/*");
	}
	
	@Bean
	public FilterRegistrationBean timeFilter() {
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/user/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
		
	}

}
