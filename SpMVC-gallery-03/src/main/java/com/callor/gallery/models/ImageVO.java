package com.callor.gallery.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ImageVO {
	
	private String i_id; 		//  VARCHAR(125) PRIMARY KEY,
	private int i_seq; 		//  INT,
	private String i_gid; 		//  VARCHAR(125) NOT NULL,
	private String i_origin_image; //  VARCHAR(255),
	private String i_up_image; 	//  VARCHAR(255),


}
