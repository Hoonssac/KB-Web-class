package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:/application.properties"}) // 설정 파일 위치 지정
@MapperScan(basePackages = {"org.scoula.mapper"}) // Mapper 인터페이스 검색용
public class RootConfig {

	// application.properties에서 값 주입
	@Value("${jdbc.driver}")
	String driver;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();

		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);

		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}

	@Autowired
	ApplicationContext applicationContext;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

		// MyBatis 설정 파일(xml) 위치 지정
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));

		// 커넥션 풀 설정 주입
		sqlSessionFactory.setDataSource(dataSource());

		// 실제 SqlSessionFactory 객체 반환
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}

	// Transaction Manager 등록
	// Spring에서 @Transactional 사용 가능하게 함
	@Bean
	public DataSourceTransactionManager transactionManager() {
		// DataSource 기반 transaction manager 생성
		DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());

		return manager;
	}
}
