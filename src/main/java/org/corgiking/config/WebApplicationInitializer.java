package org.corgiking.config;
import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {//DispatcherServlet 映射到"/"
		return new String[]{"/"};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {//DispatcherServlet 上下文配置
		return new Class<?>[]{DispatcherServletConfig.class};
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {//Root 上下文配置
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Filter[] getServletFilters() {//配置过滤器
		return super.getServletFilters();
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		//当registerDispatcherServlet完成时自定义registration  
		super.customizeRegistration(registration);
	}
}
