package org.snack.controller;


import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vote-submit")
public class VoteSubmitServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String snack = req.getParameter("snack");
		Cookie cookie = new Cookie("lastSnack", snack);
		cookie.setMaxAge(60 * 60);
		resp.addCookie(cookie);

		req.setAttribute("snack", snack);
		req.getRequestDispatcher("/vote_result.jsp").forward(req, resp);


	}
}
