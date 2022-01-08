package model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleVO {
	private int article_id;
	private int writer_id;
	private String writer_name;
	private String title;
	private String content;
	private String write_date;
	private String modify_date;
	private int view_cnt;
	private String file_path;

	public ArticleVO() {

	}
	
	public ArticleVO(ResultSet rs) throws SQLException {
		article_id = rs.getInt("article_id");
		writer_id = rs.getInt("writer_id");
		writer_name = rs.getString("writer_name");
		title = rs.getString("title");
		content = rs.getString("content");
		write_date = rs.getString("write_date");
		modify_date = rs.getString("modify_date");
		view_cnt = rs.getInt("view_cnt");
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	@Override
	public String toString() {
		return "ArticleVO [article_id=" + article_id + ", writer_id=" + writer_id + ", writer_name=" + writer_name
				+ ", title=" + title + ", content=" + content + ", write_date=" + write_date + ", modify_date="
				+ modify_date + ", view_cnt=" + view_cnt + ", file_path=" + file_path + "]";
	}

}
