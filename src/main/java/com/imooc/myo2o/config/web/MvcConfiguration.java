package com.imooc.myo2o.config.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *<p>Description:对标spring-mvc，开启Mvc自动注入spring容器
 *实现了ApplicationContextAware之后，这个类就可以方便获得ApplicationContext中的所有bean<p>	
 * @author Administrator
 * @version 2020-10-27
 *
 */
@SuppressWarnings("deprecation")
@Configuration
//等价于<mvc:annotation-driven />
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware{

	//spring容器
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	/**
	 * 静态资源配置
	 * @param registry
	 */
	public void addResourcehandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
	}
	
	/**
	 * 定义默认的请求处理器
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * 定义视图解析器
	 * @return
	 * 
	 */
	@Bean(name = "viewResolver")
	public ViewResolver creatViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//设置spring容器
		viewResolver.setApplicationContext(this.applicationContext);
		//取消缓存
		viewResolver.setCache(false);
		//设置解析的前缀
		viewResolver.setPrefix("/WEB-INF/html/");
		//设置后缀
		viewResolver.setSuffix(".html");
		return viewResolver;
	}

	/**
	 * 文件上传解析器
	 * @return
	 */
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		//1024*1024*20=20M
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(20971520);
		return multipartResolver;
	}
	
}
