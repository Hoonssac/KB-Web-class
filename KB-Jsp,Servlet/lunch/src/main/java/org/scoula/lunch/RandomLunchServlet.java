package org.scoula.lunch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "random", value = "/lunch/random")
public class RandomLunchServlet extends HelloServlet {
	static HashMap<String, int[]> lunch = new HashMap<>();
	static String[] menus = {"쭈꾸미볶음", "김치찌개", "크림파스타", "부대찌개", "햄버거", "제육볶음"};

	@Override
	public void init() {
		for (String menu : menus) {
			lunch.put(menu, new int[] {0, 0});
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String menu = request.getParameter("menu");
		String vote = request.getParameter("vote");

		if (menu != null && vote != null && lunch.containsKey(menu)) {
			int[] votes = lunch.get(menu);
			if (vote.equals("like")) {
				votes[0]++;
			} else {
				votes[1]++;
			}

			out.println("<h1>🍽️ '" + menu + "' 메뉴에 대한 투표 결과</h1>");
			out.println("<p>👍 좋아요: " + lunch.get(menu)[0] + "</p>");
			out.println("<p>👎 싫어요: " + lunch.get(menu)[1] + "</p>");
			out.println("<a href=\"/lunch/random\"> ← 다시 추천 받기</a>");

		} else {
			String selected = menus[(int)(Math.random() * menus.length)];

			out.println("<html><body>");
			out.println("<h1>오늘의 점심 메뉴 추천 🍴</h1>");
			out.println("<p>" + selected + "</p>");
			out.println("<a href='/lunch/random?menu=" + selected + "&vote=like'>👍 좋아요</a>");
			out.println("<a href='/lunch/random?menu=" + selected + "&vote=dislike'>👎 싫어요</a>");
			out.println("</html></body>");
		}


	}
}
