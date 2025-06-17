package org.scoula.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	final private BoardService service;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}

	@GetMapping("/create")
	public void create() {
		log.info("create");
	}

	@PostMapping("/create")
	public String create(BoardDTO board, RedirectAttributes ra) {
		log.info("create:" + board);
		service.create(board);
		ra.addAttribute("result", board.getNo());
		return "redirect:/board/list";
	}

	@GetMapping({"/get", "/update"})
	public void get(@RequestParam("no") Long no, Model model) {
		log.info("/get or update");
		model.addAttribute("board", service.get(no));
	}

	@PostMapping("/update")
	public String update(BoardDTO board, RedirectAttributes ra) {
		if (service.update(board)) {
			ra.addFlashAttribute("result", "success");
		}
		log.info("update:" + board);
		return "redirect:/board/get?no=" + board.getNo();
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("no") Long no, RedirectAttributes ra) {
		log.info("delete......" + no);
		if (service.delete(no)) {
			ra.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@GetMapping("/download/{no}")
	@ResponseBody
	public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
		BoardAttachmentVO attach = service.getAttachment(no);
		log.info("download get");
		System.out.println(attach);

		File file = new File(attach.getPath());
		UploadFiles.download(response, file, attach.getFilename());
	}
}
