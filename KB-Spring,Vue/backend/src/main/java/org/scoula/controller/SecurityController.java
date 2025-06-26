package org.scoula.controller;

import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api/security")
@RestController
public class SecurityController {

	@GetMapping("/all")
	public ResponseEntity<String> doAll() {
		log.info("do all can access everybody");
		return ResponseEntity.ok("All can access everybody");
	}

	@GetMapping("/member")
	public ResponseEntity<String> doMember(Authentication authentication) {
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		log.info("username = " + userDetails.getUsername());
		return ResponseEntity.ok(userDetails.getUsername());
	}

	// 사용자 정보 얻기 3. AuthenticationPrincipal 어노테이션
	// 커스텀 사용자 정보 접근 가능
	@GetMapping("/admin")
	public ResponseEntity<MemberVO> doAdmin(@AuthenticationPrincipal CustomUser customUser) {
		MemberVO member = customUser.getMember();
		log.info("username = " + member);
		return ResponseEntity.ok(member);
	}
}
