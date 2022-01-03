<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 예제</title>
<style>
input {
   margin: 1px;
}
</style>
</head>
<body>
   <%
   if (request.getMethod().equals("POST")) {
      if (session.isNew() || session.getAttribute("member_id") == null) {
         
         String name = request.getParameter("membername");
         String passwd = request.getParameter("memberpassword");
         
         if (name.equals("duke") && passwd.equals("java")) {
            session.setAttribute("member_id", name);
            session.setAttribute("member_passwd", passwd);
            session.setMaxInactiveInterval(60);
            %>
            <script>
               alert("성공적으로 로그인했습니다!!");
            </script>
            <h3>
               <%=name%> 회원님.. 좋은하루 되세요...
            </h3>
            <a href="/edu/jspsrc/exam16.jsp">POST 로그아웃</a>
            <%
         } else {
            %>
            <script>
               alert("로그인에 실패했습니다 !!");
            </script>
            <%@ include file="login.jspf"%>
            <%
         }
      }
      else {
    	  out.print("새 세션이 아닙니다.");
      }
   } else if (request.getMethod().equals("GET")) {
      String name = (String) session.getAttribute("member_id");
      if (name != null) {
         %>
         <h3><%=name%> 회원님.. 좋은하루 되세요...
         </h3>
         <a href="/edu/jspsrc/exam16.jsp">GET 로그아웃</a>
         <%
      } else {
         %>
         <script>
            alert("로그인 해주세요!");
         </script>
         <%@ include file="login.jspf"%>
         <%
      }
   }
   %>
</body>
</html>