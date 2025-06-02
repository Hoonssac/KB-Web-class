package org.scoula.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sports")
public class SportsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 다중 선택된 값은 배열로 받음
		String[] sports = req.getParameterValues("sports");

		// 단일 선택된 값은 String으로 받아옴
		String sex = req.getParameter("sex");

		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();

		out.print("<html><body>");
		for (String sport : sports) {
			out.print("좋아하는 운동: " + sport + "<br>");
		}
		out.print("성별 : " + sex + "<br>");
		out.print("</body></html>");
	}
}
