package br.com.inteligencia.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * @author Marcelo
 * Classe de configuracao do servlet do spring mvc
 */

@EnableWebMvc /** habilita o recurso web mvc do spring*/
/**indica onde o spring deve procurar os controllers */
@ComponentScan(basePackages ={"br.com.inteligencia.controller","br.com.inteligencia.service"})  
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	/**
	 * Resolvedpr de views do spring, determina onde encontrar as views jsp
	 * @return o resolvedor
	 */
	@Bean /** Determina que esse método deve ser gerênciado pelo spring*/
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/**
	 * Esse metodo  responsavel por informar ao spring o arquivo de mensagem que ele deve utilizar
	 * @return
	 */
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(5);
		
		return messageSource;
	}

	/** Informa ao spring as configurções default, deixando passar as requisições default para o container*/
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 
		configurer.enable();
	}
	
	
}
