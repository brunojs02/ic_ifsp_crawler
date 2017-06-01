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
			if (findLink(page.getLink()).getId() == null) {
				saveLink(page.getLink());
			}
			savePage(page);
			con.commit();
			saveOrUpdatePageLink(page);
		}catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			fac.closeConnection();
		}
	}
	
	private void savePage(Page page) throws SQLException{
		log.info("Starting save a Page on BD: " + page.getDocument().title());
		String sql = "insert into page (id_link_page, document, page_title, qtd_tag_img, qtd_tag_a, qtd_tag_link, qtd_tag_script, "
				+ "qtd_tag_div, qtd_tag_ul, qtd_tag_li, qtd_tag_input) " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, page.getLink().getId());
		stmt.setString(2, page.getDocument().toString());
		stmt.setString(3, page.getDocument().title());
		stmt.setInt(4, page.getQtdTagImg());
		stmt.setInt(5, page.getLinksOnThisPage().size());
		stmt.setInt(6, page.getQtdTagLink());
		stmt.setInt(7, page.getQtdTagScript());
		stmt.setInt(8, page.getQtdTagDiv());
		stmt.setInt(9, page.getQtdTaUl());
		stmt.setInt(10, page.getQtdTagLi());
		stmt.setInt(11, page.getQtdTagInput());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()){
            page.setId(rs.getInt(1));
        }
		stmt.close();
		log.info("Page saved on BD: " + page.getDocument().title());
	}
	
	private void saveOrUpdatePageLink(Page page){
		log.info("Starting save a list of links from page on BD");
		String sql = "insert into page_link (link_id, page_id) values (?, ?)";
		for(Link link:page.getLinksOnThisPage()){
			try{
				if (findLink(link).getId() == null) {
					saveLink(link);
				}
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, link.getId());
				stmt.setInt(2, page.getId());
				stmt.executeUpdate();
				stmt.close();
				con.commit();
			}catch(SQLException e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		log.info("list of links from page saved on BD");
	}
	
	private Link findLink(Link link) throws SQLException{
		log.info("Starting searching a link on BD: " + link.getLink());
		String sql = "select id_link from link where link = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, link.getLink());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			link.setId(rs.getInt("id_link"));
			log.info("Link finded: " + link.getId());
		}
		return link;
	}
	
	private void saveLink(Link link) throws SQLException{
		log.info("Starting save a Link on BD: " + link.getLink());
		String sql = "insert into link (link, depth, crawled) values(?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, link.getLink());
		stmt.setInt(2, link.getDepth());
		stmt.setBoolean(3, link.getCrawled());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()){
            link.setId(rs.getInt(1));
        }
		stmt.close();
		log.info("Link saved on DB: " + link.getLink());
	}
	
	
}
