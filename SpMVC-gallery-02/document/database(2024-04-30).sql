-- galleryDB
USE galleryDB2;
CREATE TABLE tbl_users (
	username	VARCHAR(125)	PRIMARY KEY,
	password	VARCHAR(125)	NOT NULL,
	email	VARCHAR(125)	NOT NULL,
	tel	VARCHAR(125)	NOT NULL
);
CREATE TABLE tbl_roles (
	r_username	VARCHAR(125)	PRIMARY KEY,
	r_role	VARCHAR(125)	NOT NULL
);

DROP TABLE tbl_roles;
DROP TABLE tbl_users;


