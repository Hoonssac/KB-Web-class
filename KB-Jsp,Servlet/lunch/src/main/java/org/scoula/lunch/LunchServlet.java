package org.scoula.lunch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="lunch", value="/lunch")
public class LunchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String mood = request.getParameter("mood");
		String message;

		if (mood == null) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>오늘 기분은 어떤가요?</h1>");
			out.println("<form method='GET' action='/lunch'>");
			out.println("<select id='mood' name='mood'>");
			out.println("<option value='happy'>기분 최고야</option>");
			out.println("<option value='soso'>그냥 그래</option>");
			out.println("<option value='sad'>우울해</option>");
			out.println("<option value='stressed'>스트레스 쩔어</option>");
			out.println("<option value='etc'>-</option>");
			out.println("</select><br><br>");
			out.println("<button type='submit'>추천 받기</button>");
			out.println("</form>");
			out.println("</body></html>");
		} else {
			switch (mood) {
				case "happy":
					message = "🐙 매콤한 쭈꾸미볶음 추천!";
					break;
				case "soso":
					message = "🥘 든든한 김치찌개 어떠세요?";
					break;
				case "sad":
					message = "🍝 부드러운 크림파스타로 위로받으세요.";
					break;
				case "stressed":
					message = "🔥 부대찌개 한 냄비 추천드려요!";
					break;
				default:
					message = "🍱 오늘은 도시락도 괜찮아요!";
					break;
			}

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>오늘의 추천 메뉴 🍽️</h1>");
			out.println("<p>" + message + "</p>");
			out.println("<a href=\"/lunch\">← 다시 선택하기</a>");
			out.println("</body></html>");
		}


	}
}
