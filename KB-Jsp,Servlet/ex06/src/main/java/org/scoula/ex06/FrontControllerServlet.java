package org.scoula.ex06;

import java.util.Map;

import javax.servlet.annotation.WebServlet;

import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

// 확장명 기반 : *.do
// 디렉토리명 기반 : / (하위 경로 포함)
@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet {
	String prefix = "/WEB-INF/views/";
	String suffix = ".jsp";

	HomeController homeController = new HomeController();
	TodoController todoController = new TodoController();

	@Override
	protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
		getMap.put("/", homeController::getIndex); // 메서드 참조

		getMap.put("/todo/list", todoController::getList);
		getMap.put("/todo/view", todoController::getView);
		getMap.put("/todo/create", todoController::getCreate);
		getMap.put("/todo/update", todoController::getUpdate);

		postMap.put("/todo/create", todoController::postCreate);
		postMap.put("/todo/update", todoController::postUpdate);
		postMap.put("/todo/delete", todoController::postDelete);

	}
}