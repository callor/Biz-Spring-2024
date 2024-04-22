package com.callor.gallery.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GalleryVO {
	private String g_id;		//	VARCHAR(125)
	private String g_date;		//	VARCHAR(10)
	private String g_time;		//	VARCHAR(10)
	private String g_author;	//	VARCHAR(20)
	private String g_subject;	//	VARCHAR(20)
	private String g_content;	//	VARCHAR(100)
	private String g_image;		//	LONGTEXT
}
