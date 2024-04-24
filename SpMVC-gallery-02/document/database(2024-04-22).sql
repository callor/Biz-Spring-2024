-- gallery
CREATE DATABASE galleryDB;
USE galleryDB;
DROP TABLE tbl_gallerys;
CREATE TABLE tbl_gallerys (
	g_id	VARCHAR(125)	PRIMARY KEY,
	g_date	VARCHAR(10)	NOT NULL,
	g_time	VARCHAR(10)	NOT NULL,
	g_author	VARCHAR(20)	NOT NULL,
	g_subject	VARCHAR(20)	NOT NULL,
	g_content	VARCHAR(100)	NOT NULL,
	g_image	LONGTEXT	NOT NULL
);
DESC tbl_gallerys;


