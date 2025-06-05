package org.scoula.ex06.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
	public String getIndex(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 뷰 이름 반환
		return "index";
	}
}
