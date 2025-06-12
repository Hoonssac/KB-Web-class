package org.scoula.icecream.controller;

import java.util.List;

import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.service.IcecreamServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/icecream")
@RequiredArgsConstructor
public class IcecreamController {

	private final IcecreamServiceImpl service;

	@GetMapping("/new")
	public String create() {
		return "icecream/create";
	}

	@PostMapping("/new")
	public String create(@ModelAttribute IcecreamDTO dto) {
		log.info("create... IcecreamDTO(" + dto + ")");
		service.register(dto);
		log.info("이동되는 뷰: redirect:/icecream/list");
		return "redirect:/icecream/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<IcecreamDTO> icecreams = service.getList();
		model.addAttribute("list", icecreams);
		return "icecream/list";
	}
}
