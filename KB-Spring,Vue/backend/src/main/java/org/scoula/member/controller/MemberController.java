package org.scoula.member.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.scoula.common.util.UploadFiles;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

	final MemberService service;

	// 아이디 중복 체크
	@GetMapping("/checkusername/{username}")
	public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
		return ResponseEntity.ok().body(service.checkDuplicate(username));
	}

	// 회원 가입
	@PostMapping("")
	public ResponseEntity<MemberDTO> join(@ModelAttribute MemberJoinDTO member) {
		return ResponseEntity.ok(service.join(member));
	}

	@GetMapping("/{username}/avatar")
	public void getAvatar(@PathVariable String username, HttpServletResponse response) {
		String avatarPath = "/Users/hoonssac/Desktop/" + username + ".png";
		File file = new File(avatarPath);
		System.out.println(avatarPath);;
		// 아바타 이미지 없으면 디폴트 이미지로 대체
		if (!file.exists()) {
			file = new File("/Users/hoonssac/Desktop/unknown.png");
		}

		UploadFiles.downloadImage(response, file);
	}

	@PutMapping("/{username}")
	public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) {
		return ResponseEntity.ok(service.update(member));
	}

	@PutMapping("/{username}/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		service.changePassword(changePasswordDTO);
		return ResponseEntity.ok().build();
	}
}
