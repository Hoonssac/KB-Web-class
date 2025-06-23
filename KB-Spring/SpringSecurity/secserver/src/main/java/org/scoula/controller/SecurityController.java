package org.scoula.controller;

import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/security")
@Controller
public class SecurityController {

	@GetMapping("/all")
	public void doAll() {
		log.info("do all can access everybody");
	}

	// @GetMapping("/member")
	// public void doMember() {
	// 	log.info("logined member");
	// }

	// @GetMapping("/member")
	// public void doMember(Pricipal principal) {
	// 	log.info("username = " + principal.getName());
	// }

	// 사용자 정보 얻기 2. Authentication 주입
	// Authentication 객체 전제 접근 가능
	// @GetMapping("/member")
	// public void doMember(Authentication authentication) {
	// 	UserDetails userDetails = (UserDetails)authentication.getPrincipal();
	// 	log.info("username = " + userDetails.getUsername());
	// }

	// 사용자 정보 얻기 3. AuthenticationPrincipal 어노테이션
	// 커스텀 사용자 정보 접근 가능
	@GetMapping("/admin")
	public void doAdmin(@AuthenticationPrincipal CustomUser customUser) {
		MemberVO member = customUser.getMember();
		log.info("username = " + member);
	}

	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin only");
	}

	@GetMapping("/login")
	public void login() {
		log.info("login page");
	}

	@GetMapping("/logout")
	public void logout() {
		log.info("logout page");
	}
}
