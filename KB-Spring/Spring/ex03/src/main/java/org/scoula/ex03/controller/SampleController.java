package org.scoula.ex03.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.SmapleDTOList;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

	@RequestMapping("") // 모든 메소드 허용
	public void basic() {
		log.info("basic.............");
	}

	// GET과 POST 모두 허용하는 특정 경로 매핑, /sample/basic
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get............");
	}

	// GET 전용 매핑, /sample/basicOnlyGet
	@GetMapping("/basicOnlyGet") // url : /sample/basicOnlyGet
	public void basicGet2() {
		log.info("basic get only get............");
	}

	// /sample/ex01
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		// dto의 기본 생성자와 setter 사용
		log.info("" + dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("nmae") String name, @RequestParam("age") int age) {
		// DTO 객체를 사용하지 않고 파라미터를 각각 사용할 때
		log.info("name:" + name);
		log.info("age:" + age);

		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
		return "ex02LIst";
	}

	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids: " + Arrays.toString(ids));
		return "ex02Array";
	}

	@GetMapping("/ex02Bean")
	public String ex02Bean(SmapleDTOList list) {
		log.info("list dtos: " + list);
		return "ex02Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		return "ex03";
	}

	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto); // SampleDTO 내부 필드 자동 바인딩
		log.info("page: " + page); // 일반 파라미터도 자동 바인딩

		return "sample/ex04";
	}

	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05.........");
	}

	@GetMapping("/ex06")
	public String ex06(RedirectAttributes ra) {
		log.info("/ex06.............");
		ra.addAttribute("name", "AAA");
		ra.addAttribute("age", 10);

		return "redirect:/sample/ex06-2";
	}

	@GetMapping("/ex07")
	public @ResponseBody SampleDTO ex07() {
		log.info("/ex07.............");

		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");

		return dto;
	}

	// ResponseEntity : 바디, 헤더, 상태코드를 객체에 담아서 넘긴다.
	@GetMapping("/ex08")
	public ResponseEntity<String> ex08() {
		log.info("/ex08..........");
		// {"name": "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}

	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...............");
	}

	@PostMapping("exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		for (MultipartFile file : files) {
			log.info("-------------------------");
			log.info("name: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
		}
	}
}
