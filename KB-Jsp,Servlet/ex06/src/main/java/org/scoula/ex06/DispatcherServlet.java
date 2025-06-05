package org.scoula.ex06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scoula.ex06.command.Command;

// 어노테이션은 상속되지 않기 때문에 부모 클래스에 안붙임
public class DispatcherServlet extends HttpServlet {
	Map<String, Command> getMap; // GET 방식 요청 처리용 커맨드 맵
	Map<String, Command> postMap; // POST 방식 요청 처리용 커맨드 맵

	String prefix = "/WEB-INF/views/";
	String suffix = ".jsp";

	public void init() {
		getMap = new HashMap<>();
		postMap = new HashMap<>();
		createMap(getMap, postMap);
		for (String key : postMap.keySet()) {
			System.out.println(key + " " + postMap.get(key));

		}
	}

	protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
	}

	public void execute(Command command, HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException {
		String viewName = command.execute(req, resp);
		if(viewName.startsWith("redirect:")) { // redirect 처리
			resp.sendRedirect(viewName.substring("redirect:".length()));
		} else { // forward 처리
			String view = prefix + viewName + suffix;
			RequestDispatcher dis = req.getRequestDispatcher(view);
			dis.forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Command command = getCommand(req);
		if (command != null) {
			execute(command, req, resp);
		} else {
			// 404 에러 처리
			String view = prefix + "404" + suffix;
			RequestDispatcher dis = req.getRequestDispatcher(view);
			dis.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private String getCommandName(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		return requestURI.substring(contextPath.length());
	}

	private Command getCommand(HttpServletRequest req) {
		String commandName = getCommandName(req);

		Command command;
		// 요청에서 현재 메소드 가져와서 GET인지 대소문자 무시해서 체크
		if (req.getMethod().equalsIgnoreCase("GET")) {
			command = getMap.get(commandName); // GET 요청이면 getMap에서 꺼냄
		} else {
			command = postMap.get(commandName); // POST 요청이면 postMap에서 꺼냄
		}
		return command;
	}
}
