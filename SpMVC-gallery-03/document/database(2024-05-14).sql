-- galleryDB2;
USE galleryDB2;
SHOW TABLES;
DROP TABLE tbl_mygallery;
CREATE TABLE tbl_mygallery (
	g_id VARCHAR(125) PRIMARY KEY,
	g_date VARCHAR(10),
	g_time VARCHAR(10),
	g_subject VARCHAR(125),
	g_content VARCHAR(400),
	g_writer VARCHAR(125),
	g_password VARCHAR(125),
	g_image VARCHAR(255)
);

CREATE TABLE tbl_myimages (
	i_id VARCHAR(125) PRIMARY KEY,
    i_seq INT,
    i_gid VARCHAR(125) NOT NULL,
    i_origin_image VARCHAR(255),
    i_up_image VARCHAR(255),
    CONSTRAINT FK_image
    FOREIGN KEY (i_gid)
    REFERENCES tbl_mygallery(g_id)
    ON DELETE CASCADE
)


