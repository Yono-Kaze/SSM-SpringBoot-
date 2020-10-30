package com.imooc.myo2o.config.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.imooc.myo2o.interceptor.shop.ShopLoginInterceptor;
import com.imooc.myo2o.interceptor.shop.ShopPermissionInterceptor;
import com.imooc.myo2o.interceptor.superadmin.SuperAdminLoginInterceptor;

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
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:G:\\projectdev\\image\\upload\\");
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

	@Value("${kaptcha.border}")
	private	String border;
	@Value("${kaptcha.textproducer.font.color}")
	private	String fcolor;
	@Value("${kaptcha.image.width}")
	private	String	width;
	@Value("${kaptcha.textproducer.char.string}")
	private	String cstring;
	@Value("${kaptcha.image.height}")
	private	String	height;
	@Value("${kaptcha.textproducer.font.size}")
	private	String	fsize;
	@Value("${kaptcha.noise.color}")
	private	String	ncolor;
	@Value("${kaptcha.textproducer.char.length}")
	private	String	clength;
	@Value("${kaptcha.textproducer.font.names}")
	private	String	fnames;

	/**
	 * 配置Kaptcha验证码
	 * @return
	 */
	@Bean(name = "Kaptcha")
	public ServletRegistrationBean<KaptchaServlet> servletRegistrationBean () {
		//拦截的url
		ServletRegistrationBean<KaptchaServlet> servlet = new ServletRegistrationBean<KaptchaServlet>(new KaptchaServlet(), "/Kaptcha");
		servlet.addInitParameter("kaptcha.border", border);//	<!-- 是否有边框 -->
		servlet.addInitParameter("kaptcha.textproducer.font.color", fcolor);//	<!-- 字体颜色 -->
		servlet.addInitParameter("kaptcha.image.width", width);//	<!-- 图片宽度 -->
		servlet.addInitParameter("kaptcha.textproducer.char.string", cstring);//	<!-- 使用哪些字符生成验证码 -->
		servlet.addInitParameter("kaptcha.image.height", height);//	<!-- 图片高度 -->
		servlet.addInitParameter("kaptcha.textproducer.font.size", fsize);//	<!-- 字体大小 -->
		servlet.addInitParameter("kaptcha.noise.color", ncolor);//	<!-- 干扰线的颜色 -->
		servlet.addInitParameter("kaptcha.textproducer.char.length", clength);//	<!-- 字符个数 -->
		servlet.addInitParameter("kaptcha.textproducer.font.names", fnames);//	<!-- 使用哪些字体 -->
		return servlet;
	}

	/**
	 * 添加权限拦截器配置
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		String interceptPath = "/shop/**";
		String interceptSuperAdminPath = "/superadmin/**";
		//注册登录的拦截器
		InterceptorRegistration loginIR = registry.addInterceptor(new ShopLoginInterceptor());
		//		//配置拦截的路径
		loginIR.addPathPatterns(interceptPath);
		//		//配置不拦截的路径
		loginIR.excludePathPatterns("/shop/ownerlogin");
		loginIR.excludePathPatterns("/shop/register");
		loginIR.excludePathPatterns("/shop/ownerlogincheck");
		loginIR.excludePathPatterns("/shop/logout");
		loginIR.excludePathPatterns("/shop/shopedit");
		loginIR.excludePathPatterns("/shop/getshopinitinfo" );
		loginIR.excludePathPatterns("/shop/registershop");
		loginIR.excludePathPatterns("/shop/shopmanage");
		loginIR.excludePathPatterns("/shop/getshopmanagementinfo");
		loginIR.excludePathPatterns("/shop/getshopauthmapbyid");
		//对该店铺有操作权限的拦截器
		InterceptorRegistration permissionIR = registry.addInterceptor(new ShopPermissionInterceptor());
		//配置拦截的路径
		permissionIR.addPathPatterns(interceptPath);
		//配置不拦截的路径
		permissionIR.excludePathPatterns("/shop/ownerlogin");
		permissionIR.excludePathPatterns("/shop/ownerlogincheck");
		permissionIR.excludePathPatterns("/shop/register");
		permissionIR.excludePathPatterns("/shop/shoplist");
		permissionIR.excludePathPatterns("/shop/logout");
		permissionIR.excludePathPatterns("/shop/list");
		permissionIR.excludePathPatterns("/shop/shopedit");
		permissionIR.excludePathPatterns("/shop/shopmanage");
		permissionIR.excludePathPatterns("/shop/getshopmanagementinfo");
		permissionIR.excludePathPatterns("/shop/getshopinitinfo" );
		permissionIR.excludePathPatterns("/shop/registershop");
		permissionIR.excludePathPatterns("/shop/getshopauthmapbyid");

		//Superadmin权限验证拦截器
		InterceptorRegistration SupperAdminIR = registry.addInterceptor(new SuperAdminLoginInterceptor());
		//配置拦截的路径
		SupperAdminIR.addPathPatterns(interceptSuperAdminPath);
		//配置不拦截的路径
		SupperAdminIR.excludePathPatterns("/superadmin/login");
		SupperAdminIR.excludePathPatterns("/superadmin/logincheck");
	}
}
