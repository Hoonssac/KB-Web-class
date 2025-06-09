package org.scoula.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// web.xml을 대체하는 설정
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	// Root Application 설정 (Service, DAO, DB 등)
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	// Servlet Application 설정 (Controller, ViewResolver 등)
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	// DispatcherServlet의 URL 매핑
	@Override
	protected String[] getServletMappings() {
		// 모든 요청을 DispatcherServlet이 처리
		return new String[] {"/"};
	}

	// 한글 POST 요청 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);

		return new Filter[] {characterEncodingFilter};
	}
}
