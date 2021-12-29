package base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" })
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();	// 입력받은 URI 추출
		System.out.println(uri);
		String filename = "";
		String contentType = "";
		if (uri.endsWith("getHTML")) {			// 여러 URL을 받을 수 있어 해당 타입을 지정
			filename = "c:/Temp/sample.html";	
			contentType = "text/html; charset=utf-8";
		} else if (uri.endsWith("getXML")) {
			filename = "c:/Temp/sample.xml";	
			contentType = "application/xml; charset=utf-8";
		} else if (uri.endsWith("getJSON")) {
			filename = "c:/Temp/sample.json";	
			contentType = "text/json; charset=utf-8";
		} else {
			filename = "c:/Temp/trans_duke.png";	
			contentType = "image/png";
		}
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		response.setContentType(contentType);
		if(contentType.startsWith("image")) {		// 이미지 형태일 때
			byte[] content = new byte[(int)f.length()];
			ServletOutputStream sos = response.getOutputStream();	// 바이트단위로 출력
			fis.read(content);
			sos.write(content);			
			sos.close();
		} else {									// 다른 형태일 때
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			PrintWriter out = response.getWriter();
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}
