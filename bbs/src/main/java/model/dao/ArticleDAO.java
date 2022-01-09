package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ArticleVO;

public class ArticleDAO {
	// 게시글 생성
	public boolean createArticle(ArticleVO vo) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn
				.prepareStatement("INSERT INTO article (writer, title, content, write_date) values (?, ?, ?, now())")) {
			pstmt.setInt(1, vo.getWriter_id());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.err.println("게시글 생성 오류 : " + e.getMessage());
		}
		MySQL.close(conn);
		return result;
	}

	// 모든 게시물 조회
	public List<ArticleVO> readAllArticles() {
		Connection conn = MySQL.connect();
		List<ArticleVO> aList = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt
					.executeQuery("SELECT article_id, u.name, date_format(write_date, '%Y년 %m월 %d일') write_date, title "
							+ "FROM article a JOIN user u ON a.writer = u.uid " + "ORDER BY write_date DESC");
			aList = new ArrayList<ArticleVO>();
			ArticleVO vo;
			while (rs.next()) {
				vo = new ArticleVO();
				vo.setArticle_id(rs.getInt("article_id"));
				vo.setWriter_name(rs.getString("name"));
				vo.setWrite_date(rs.getString("write_date"));
				vo.setTitle(rs.getString("title"));
				aList.add(vo);
			}
		} catch (Exception e) {
			System.err.println("전체 게시글 조회 오류 : " + e.getMessage());
		}
		MySQL.close(conn);
		return aList;
	}

	// 선택한 게시물 조회
	public ArticleVO readOneArticle(int article_id) {
		Connection conn = MySQL.connect();
		ArticleVO article = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT article_id, writer_id, writer_name, title, content, write_date, modify_date, view_cnt "
							+ "FROM article a JOIN user u ON a.writer_id = u.uid " + "WHERE article_id=" + article_id);
			if (rs.next()) {
				article = new ArticleVO(rs);
				System.out.println(article.getArticle_id() + " 조회 성공!");
			}
		} catch (Exception e) {
			System.err.println(article_id + " 계정 조회 오류" + e.getMessage());
		}
		MySQL.close(conn);
		return article;
	}

	// 특정 유저 게시물 조회
	public List<ArticleVO> readUserArticles(String name) {
		Connection conn = MySQL.connect();
		List<ArticleVO> aList = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt
					.executeQuery("SELECT article_id, u.name, date_format(write_date, '%Y년 %m월 %d일') write_date, title "
							+ "FROM article a JOIN user u ON a.writer = u.uid " + "WHERE u.name=" + name
							+ " ORDER BY write_date DESC");
			aList = new ArrayList<ArticleVO>();
			ArticleVO vo;
			while (rs.next()) {
				vo = new ArticleVO();
				vo.setArticle_id(rs.getInt("article_id"));
				vo.setWriter_name(rs.getString("name"));
				vo.setWrite_date(rs.getString("write_date"));
				vo.setTitle(rs.getString("title"));
				aList.add(vo);
			}
		} catch (Exception e) {
			System.err.println("특정 유저 게시글 조회 오류 : " + e.getMessage());
		}
		MySQL.close(conn);
		return aList;
	}

	// 특정 내용 게시물 조회
	public List<ArticleVO> readWordArticles(String word) {
		Connection conn = MySQL.connect();
		List<ArticleVO> aList = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt
					.executeQuery("SELECT article_id, u.name, date_format(write_date, '%Y년 %m월 %d일') write_date, title "
							+ "FROM article a JOIN user u ON a.writer = u.uid " + "WHERE a.title LIKE %" + word
							+ "% OR a.content LIKE %" + word + "% ORDER BY write_date DESC");
			aList = new ArrayList<ArticleVO>();
			ArticleVO vo;
			while (rs.next()) {
				vo = new ArticleVO();
				vo.setArticle_id(rs.getInt("article_id"));
				vo.setWriter_name(rs.getString("name"));
				vo.setWrite_date(rs.getString("write_date"));
				vo.setTitle(rs.getString("title"));
				aList.add(vo);
			}
		} catch (Exception e) {
			System.err.println("특정 내용 게시글 조회 오류 : " + e.getMessage());
		}
		MySQL.close(conn);
		return aList;
	}

	public boolean updateArticle(ArticleVO vo) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn
				.prepareStatement("UPDATE article SET content=?, modify_date=NOW() WHERE article_id=?")) {
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getArticle_id());
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.err.println(vo.getArticle_id() + " 게시물 수정 오류" + e.getMessage());
		}
		MySQL.close(conn);
		return result;
	}

	public boolean deleteArticle(int article_id) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM article WHERE article_id=?")) {
			pstmt.setInt(1, article_id);
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.err.println(article_id + " 게시글 삭제 오류" + e.getMessage());
		}
		MySQL.close(conn);
		return result;
	}

}
