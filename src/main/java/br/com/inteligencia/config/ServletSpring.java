package br.com.inteligencia.config;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author Marcelo
 * Classe de configuracao do spring para atender todas as requisicoes que chega para a aplicacao 
 */
public class ServletSpring extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{AppWebConfiguration.class, JPAConfigurator.class,JPAProductionConfiguration.class};
	}

	/**
	 * Esse método recebe um array de classes de configuracoes
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {};
	}

	/**
	 * Recebe um array com o  mapeamento que queremos que nosso servlet atenda
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		/** definimos que  servlet atenderá as requisições a partir da raiz do nosso projeto*/
		return new String[]{"/"};
		
	}
	
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.addListener(RequestContextListener.class);
		servletContext.setInitParameter("spring.profiles.active", "prod");
	}

}
