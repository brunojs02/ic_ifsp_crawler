drop database if exists webcrawler;
create database webcrawler;
use webcrawler;
create table link(
	id_link Integer not null auto_increment,
	link varchar(500) not null,
	depth Integer not null,
	primary key(id_link)
);
create table page(
	id_page Integer not null auto_increment,
	id_link_page Integer not null,
	document longtext not null,
	qtd_imgs Integer null,
	qtd_links Integer null,
	qtd_css_files Integer null,
	qtd_js_files Integer null,
	qtd_divs Integer null,
	qtd_ul Integer null,
	qtd_li Integer null,
	qtd_input Integer null,
	primary key(id_page),
	foreign key(id_link_page) references link(id_link)
);