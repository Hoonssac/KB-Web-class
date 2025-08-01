package org.scoula.security.config;

import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.AuthenticationErrorFilter;
import org.scoula.security.filter.JwtAuthenticationFilter;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.scoula.security.handler.CustomAccessDeniedHandler;
import org.scoula.security.handler.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity // Spring Security 활성화
@Log4j2
@MapperScan(basePackages = {
	"org.scoula.security.account.mapper"
})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// DB 기반 인증 처리를 위한 서비스 (in-memory 방식과 병행 불가)
	private final UserDetailsService userDetailsService;
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationErrorFilter authenticationErrorFilter;

	private final CustomAccessDeniedHandler accessDeniedHandler;
	private final CustomAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;

	// 문자셋 필터
	public CharacterEncodingFilter encodingFilter() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return encodingFilter;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// 한글 인코딩 필터 설정
		http.addFilterBefore(encodingFilter(), CsrfFilter.class)
			// 인증 에러 필터
			.addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class)
			// Jwt 인증 필터
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			// 로그인 인증 필터
			.addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		// 예외 처리 설정
		http
			.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint)
			.accessDeniedHandler(accessDeniedHandler);

		// http
		// 	.authorizeRequests() // 경로별 접근 권한 설정
		// 	.antMatchers(HttpMethod.OPTIONS).permitAll()
		// 	.antMatchers("/api/security/all").permitAll() // 모두 허용
		// 	.antMatchers("/api/security/member").access("hasRole('ROLE_MEMBER')") // ROLE_MEMBER 이상 접근 허용
		// 	.antMatchers("/api/security/admin").access("hasRole('ROLE_ADMIN')") // ROLD_ADMIN 이상 접근 허용
		// 	.anyRequest().authenticated(); // 나머지는 로그인 된 경우 모두 허용

		http
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			// .antMatchers(HttpMethod.POST,"/api/member").authenticated()
			.antMatchers(HttpMethod.POST, "/api/board/**" ).authenticated()
			.antMatchers(HttpMethod.PUT,"/api/member", "/api/member/*/changepassword", "/api/board/**").authenticated()
			.antMatchers(HttpMethod.DELETE, "/api/board/**").authenticated()
			.anyRequest().permitAll();

		http.httpBasic().disable() // 기본 HTTP 인증 비활성화
			.csrf().disable() // csrf 비활성화
			.formLogin().disable() // formLogin 비활성화
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 생성 모드 설정 (JWT 기반 인증 대응)
	}

	// 인증 매니저 구성 : 사용자 장보와 패스워드 인코더 설정
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// DB에서 사용자 정보를 조회하고, 해시된 비밀번호 인증
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// 보안 강화를 위한 BCrypt 해시 및 알고리즘 사용
		return new BCryptPasswordEncoder();
	}

	// AuthenticationManager 빈 등록
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// cross origin 접근 허용
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	// 접근 제한 무시 경로 설정 - resource
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**",
			"/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v2/api-docs"
		);
	}
}
