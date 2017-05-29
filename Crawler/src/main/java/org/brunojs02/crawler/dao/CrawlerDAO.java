package org.brunojs02.crawler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.brunojs02.crawler.entities.Link;
import org.brunojs02.crawler.entities.Page;

public class CrawlerDAO {
	
	private Factory fac = null;
	private Connection con = null;
	private Logger log = Logger.getLogger("CrawlerDAO");
	
	public CrawlerDAO(){
		fac = new Factory();
	}
	
	public void save(Page page){
		con = fac.getConnection();
		try {
			con.setAutoCommit(false);
			saveLink(page.getLink());
			savePage(page);
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		fac.closeConnection();
	}
	
	private void savePage(Page page) throws SQLException{
		log.info("Starting save a Page on BD: " + page.getDocument().title());
		String sql = "insert into page (id_link_page, document, qtd_tag_img, qtd_tag_a, qtd_tag_link, qtd_tag_script, "
				+ "qtd_tag_div, qtd_tag_ul, qtd_tag_li, qtd_tag_input) " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, page.getLink().getId());
		stmt.setString(2, page.getDocument().toString());
		stmt.setInt(3, page.getQtdImgs());
		stmt.setInt(4, page.getQtdLinks());
		stmt.setInt(5, page.getQtdCssFiles());
		stmt.setInt(6, page.getQtdJsFiles());
		stmt.setInt(7, page.getQtdDivs());
		stmt.setInt(8, page.getQtdUl());
		stmt.setInt(9, page.getQtdLi());
		stmt.setInt(10, page.getQtdInputs());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()){
            page.setId(rs.getInt(1));
        }
		stmt.close();
		log.info("Page saved on BD: " + page.getDocument().title());
	}
	
	private void saveLink(Link link) throws SQLException{
		log.info("Starting save a Link on BD: " + link.getLink());
		String sql = "insert into link (link, depth) values(?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, link.getLink());
		stmt.setInt(2, link.getDepth());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()){
            link.setId(rs.getInt(1));
        }
		stmt.close();
		log.info("Link saved on DB: " + link.getLink());
	}
	
	
}
