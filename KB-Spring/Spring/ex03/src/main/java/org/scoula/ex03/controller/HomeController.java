package org.scoula.ex03.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@ComponentScan
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		// Model : Spring에서 제공하는 데이터 전달 객체
		// request scope에 데이터 저장
		model.addAttribute("name", "홍길동");

		return "index";
	}
}
