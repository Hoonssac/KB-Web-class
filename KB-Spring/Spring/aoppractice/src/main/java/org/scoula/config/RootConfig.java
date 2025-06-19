package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
	"org.scoula.aop", // AOP Advice 클래스 스캔
	"org.scoula.service", // 서비스 컴포넌트 스캔
	"org.scoula.exception"
})
@EnableAspectJAutoProxy // AspectJ 기반 AOP 자동 프록시 생성 활성화
public class RootConfig {
}