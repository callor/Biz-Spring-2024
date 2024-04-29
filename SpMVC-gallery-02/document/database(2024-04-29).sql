-- galleryDB2
USE galleryDB2;
DESC tbl_images;

SELECT * FROM tbl_gallerys;
SELECT * FROM tbl_images;
SELECT last_insert_id();

DROP TABLE tbl_images;
DROP TABLE tbl_gallerys;

