package org.scoula.stock.controller;

import org.scoula.stock.dto.StockDTO;
import org.scoula.stock.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

	final private StockService service;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("get list controller");
		model.addAttribute("list", service.getList());
	}

	@GetMapping("/list/mesu")
	public void mesuList(Model model) {
		log.info("get mesu list controller");
		model.addAttribute("list", service.getMesuList());
	}

	@GetMapping("/create")
	public void create() {
		log.info("get create controller");
	}

	@PostMapping("/create")
	public String create(StockDTO stock, RedirectAttributes ra) {
		log.info("post create controller");
		service.create(stock);
		ra.addFlashAttribute("result", stock.getNo());
		return "redirect:/stock/list";
	}

	@PostMapping("/mesu")
	public String mesu(StockDTO stock, RedirectAttributes ra) {
		log.info("mesu controller");
		service.mesu(stock);
		ra.addFlashAttribute("result", stock.getNo());
		return "redirect:/stock/list";
	}

	@GetMapping("/get")
	public void get(@RequestParam("no") Long no, Model model) {
		log.info("get stock controller");
		model.addAttribute("stock", service.get(no));
	}

	@PostMapping("/mesu/delete")
	public String delete(@RequestParam Long no) {
		service.delete(no); // 혹은 buyService.delete(no);
		return "redirect:/stock/list/mesu"; // 삭제 후 목록 페이지로 리다이렉트
	}
}
