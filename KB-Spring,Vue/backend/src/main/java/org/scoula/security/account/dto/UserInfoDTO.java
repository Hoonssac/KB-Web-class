package org.scoula.security.account.dto;

import java.util.List;

import org.scoula.security.account.domain.MemberVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
	String username;
	String email;
	List<String> roles;

	public static UserInfoDTO of (MemberVO member) {
		return new UserInfoDTO(
			member.getUsername(),
			member.getEmail(),
			member.getAuthList().stream()
				.map(a -> a.getAuth())
				.toList()
		);
	}
}
