package controller;

import java.io.IOException;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int l, r;
		String op;
		l = Integer.parseInt(request.getParameter("left"));
		r = Integer.parseInt(request.getParameter("right"));
		op = request.getParameter("op");

		if (op.equals("/") && r == 0) {
			request.setAttribute("errMsg", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!");
			request.getRequestDispatcher("/jspsrc/errorResult.jsp").forward(request, response);
		} else {
			Object result = 0;
			try {
				result = new ScriptEngineManager().getEngineByName("js").eval(String.format("%d%s%d", l, op, r));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
			request.setAttribute("result", result);
			request.getRequestDispatcher("/jspsrc/calcResult.jsp").forward(request, response);
		}
	}

}
