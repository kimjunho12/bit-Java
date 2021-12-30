package base;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(location = "c:/Temp/uploadtest")		// 저장 위치
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String path = "c:/Temp/uploadtest";
		File isDir = new File(path);
		if (!isDir.isDirectory()) {		// 디렉토리 없으면 생성
			isDir.mkdirs();
		}
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			String fileName = part.getSubmittedFileName();
			System.out.printf("%s, %b\n", fileName, fileName != null);
			if (fileName != null && !fileName.isEmpty()) {
				part.write(System.currentTimeMillis()+"_"+fileName);	// write로 알아서 저장 (경로는 상위 MultipartConfig에 지정)
				out.print("업로드한 파일 이름: " + fileName + "<br>");
				out.print("크기: " + part.getSize() + "<br>");
			} else {
				String partName = part.getName();					// 네임 속성 추출
				String fieldValue = request.getParameter(partName);	// 네임 속성 데이터 추출
				out.print(partName + " : " + fieldValue + "<br>");
			}
		}
		out.close();
	}
}
