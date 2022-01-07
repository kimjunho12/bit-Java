<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "vo.MeetingVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Poor+Story:400" rel="stylesheet">
<style>
    * {
    	font-family: "Poor Story"   
    }
	td{
		border-bottom : 2px dotted green;
		padding-left : 20px;
	}
	tr:hover{ 
		background-color : pink;	
		font-weight : bold;
	}
	td:nth-child(3){
		width : 300px;
	}
</style>
</head>
<body>
<%
	ArrayList<MeetingVO> list = (ArrayList<MeetingVO>)request.getAttribute("list");
	if(list !=null){
%>
	<h2>미팅 스케쥴</h2><hr>
	<table>
<%
		for(MeetingVO vo : list){
%>
			<tr>
			<td class='<%= vo.getId() %>'><%= vo.getName() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getMeetingDate() %></td>
			<td class='<%= vo.getId() %>'><%= vo.getTitle() %></td>
			<td><a href ='/mvc/meeting?action=delete&id=<%= vo.getId() %>'>
			<img src = "/mvc/images/delete.png" width = '30'></a></td>
			<td><img onclick="displayUpdateForm('<%= vo.getId() %>')" 
			       src="/mvc/images/edit.png" width = '30'></td>
			</tr>
<%
		}
%>
	</table>
<%
	}
	if (request.getAttribute("msg") != null) {
%>
	<script>
		alert('${ msg }');
	</script>

<%
	}
%>
<hr>
<button onclick="displayDiv(1);">미팅 정보 작성</button>
<button onclick="displayDiv(2);">미팅 정보 검색</button>
<script>
function displayDiv(type) {
	if(type == 1) {
		document.getElementById("search").style.display='none';
		document.getElementById("write").style.display='block';
	} else if(type == 2) {
		document.getElementById("write").style.display='none';
		document.getElementById("search").style.display='block';
	}	
}
function displayUpdateForm(cv) {
    var doms = document.getElementsByClassName(cv)
	document.getElementById("write").style.display='block';	
	document.getElementById("m_name").value = 
		                                  doms[0].textContent;
	document.getElementById("m_title").value = 
		                                  doms[1].textContent;
	var str = doms[2].textContent;
	var ary = str.split(/\D+/g)
	var meeting_dt = ary[0]+"-"+ary[1]+"-"+ary[2]+
	                          "T"+ary[3]+":"+ary[4];
	document.getElementById("m_dt").value = meeting_dt;
	document.getElementById("divT").textContent="미팅정보 수정";
	document.querySelector("#write [type=submit]").value="수정";
	document.querySelector("#write [type=hidden]").value=cv;
}
</script>
<div id="write"  style="display:none">
<hr><h2 id="divT">미팅정보 작성</h2>
<form method = "post" action = "/mvc/meeting">
<input type="hidden" name="action" value="insert">
미팅 대상 이름 : <input id="m_name" type="text"  name="name">
<br>
미팅 목적 : <br>
<textarea id="m_title"  rows="3" cols="30" name = "title" ></textarea>
<br>
날짜와 시간 :  <input id="m_dt" type="datetime-local" name="meetingDate">
<br>
<input type = "submit" value = "등록">
<input type = "reset" value = "재작성">
</form>
</div>
<div id="search" style="display:none">
<form method = "get" action ="/mvc/meeting">
검색어 : <input type = "search" name = "keyword" >
<input type = "submit" value = "검색">
<hr>
<button type="button" onclick="location.href='/mvc/meeting' ">전체 미팅 스케쥴 보기</button>
</form>
</div>
</body>
</html>





