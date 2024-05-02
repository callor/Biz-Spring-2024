-- galleryDB
USE galleryDB2;
CREATE TABLE tbl_users (
	username	VARCHAR(125)	PRIMARY KEY,
	password	VARCHAR(125)	NOT NULL,
	email	VARCHAR(125)	NOT NULL,
	tel	VARCHAR(125)	NOT NULL
);
CREATE TABLE IF NOT EXISTS tbl_roles (
	r_username	VARCHAR(125),
	r_role	VARCHAR(125)	NOT NULL,
    
    CONSTRAINT PK_ROLE
    PRIMARY KEY (r_username, r_role),
    
	CONSTRAINT FK_USER
	FOREIGN KEY (r_username)
	REFERENCES tbl_users(username) ON DELETE CASCADE
)

DROP TABLE tbl_roles;
DROP TABLE tbl_users;
SHOW TABLES;


