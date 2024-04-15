-- userDB;
USE userDB;
CREATE TABLE IF NOT EXISTS tbl_users (
	username VARCHAR(30) PRIMARY KEY,
	password VARCHAR(64) NOT NULL,
	email VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS tbl_rols (
 		r_username VARCHAR(30) NOT NULL,
 		r_role VARCHAR(20) NOT NULL,
 		FOREIGN KEY (r_username)
 		REFERENCES tbl_users(username) 
        ON DELETE CASCADE
);



