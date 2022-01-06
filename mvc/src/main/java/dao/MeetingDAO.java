package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.MeetingVO;

public class MeetingDAO implements Meeting{
	public ArrayList<MeetingVO> listAll(){
		ArrayList<MeetingVO> list = new ArrayList<>();
		Connection conn = MySQL.connect();
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select id, name, title, date_format(meetingdate, '%Y년 %m월 %d일 %H시 %i분') from meeting");){	
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		MySQL.close(conn);
		return list;
	}
	
	public ArrayList<MeetingVO> search(String keyword){
		ArrayList<MeetingVO> list = new ArrayList<>();
		Connection conn = MySQL.connect();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select id, name, date_format(meetingdate, '%Y년 %m월 %d일 %H시 %i분'), "
						+ "title from meeting where title like '%"+keyword + "%'");){	
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setMeetingDate(rs.getString(3));
				vo.setTitle(rs.getString(4));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		MySQL.close(conn);
		return list;
	}
	
	public boolean insert(MeetingVO vo) {
		boolean result = true;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("insert into meeting (name, title, meetingdate) values(? ,?, ?)");){
			System.out.println(vo.getMeetingDate());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
			pstmt.executeUpdate();			
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		MySQL.close(conn);
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("delete from meeting where id = ?");){
			pstmt.setInt(1,id);
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum != 1)
				result = false;
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		MySQL.close(conn);
		return result;
	}
	public boolean update(MeetingVO vo) {
		boolean result = true;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement(
						"update meeting set " + 
						"name = ?, " + 
						"title = ?, " + 
						"meetingdate = ? " + 
						"where id = ?");){
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();			
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		MySQL.close(conn);
		return result;
	}
	
}
