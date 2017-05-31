drop database if exists webcrawler;
create database webcrawler;
use webcrawler;
create table link(
	id_link Integer not null auto_increment,
	link text not null,
	depth Integer not null,
	crawled tinyint(1) not null,
	primary key(id_link)
);
create table page(
	id_page Integer not null auto_increment,
	id_link_page Integer not null,
	document longtext not null,
	page_title text not null,
	qtd_tag_img Integer null,
	qtd_tag_a Integer null,
	qtd_tag_link Integer null,
	qtd_tag_script Integer null,
	qtd_tag_div Integer null,
	qtd_tag_ul Integer null,
	qtd_tag_li Integer null,
	qtd_tag_input Integer null,
	primary key(id_page),
	foreign key(id_link_page) references link(id_link)
);
create table page_link(
	id_page_link Integer not null auto_increment,
	link_id Integer not null,
	page_id Integer not null,
	primary key(id_page_link),
	foreign key(link_id) references link(id_link),
	foreign key(page_id) references page(id_page)
);