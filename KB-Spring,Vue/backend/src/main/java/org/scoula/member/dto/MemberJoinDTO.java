package org.scoula.member.dto;

import org.scoula.security.account.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberJoinDTO {
	private String username;
	private String password;
	private String email;
	private MultipartFile avatar;

	// DTO를 VO로 변환하는 메서드
	public MemberVO toVO() {
		return MemberVO.builder()
			.username(username)
			.password(password)
			.email(email)
			.build();
	}
}
