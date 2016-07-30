package lt.gt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
//@EnableWebSecurity
@ComponentScan({ "lt.gt.sudoku.web" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

//	// @Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		// auth.userDetailsService(userDetailsService);
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//
//		// auth.jdbcAuthentication().
//	}
//
//	@Configuration
////	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.httpBasic().and().authorizeRequests()
////			.antMatchers("/index.html", "/home.html", "/login.html", "/")
//			.antMatchers( "/aaa")
//					.permitAll().anyRequest().authenticated();
//		}
//
//		@Autowired
//		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
////			auth.userDetailsService(userDetailsService);
//			 auth
//			 .inMemoryAuthentication()
//			 .withUser("user").password("password").roles("USER");
//
//			// auth.jdbcAuthentication().
//
//			// auth.ano
//		}
//	}
}