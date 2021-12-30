package base;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/part")
@MultipartConfig  
public class PartTestServlet extends HttpServlet {   
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        Collection<Part> parts = request.getParts();
        System.out.println("========== 요청 받음 =========");
        System.out.println("요청 파라미터로 "+ parts.size() + "개의 파트가 전달됨...");
        for(Part part : parts) {        	
            System.out.print("name 값(<form>태그의 name 속성의 값 : ");
            System.out.println(part.getName());            
            System.out.println("[ 파트만의  헤더 정보 ] ");
            for(String headerName : part.getHeaderNames()) {
                System.out.print(headerName + " : ");
                System.out.println(part.getHeader(headerName));
            }
            System.out.println("값(컨텐트) 크기 : "+ part.getSize());
            String filename = part.getSubmittedFileName();
            if (filename != null)
            	System.out.println("파일명 : "+filename);
            System.out.println("------------------------------------");
        }        
    }
}


