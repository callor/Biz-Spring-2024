package com.callor.gallery.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GalleryVO {
	private String g_id;
	private String g_date;
	private String g_time;
	private String g_subject;
	private String g_content;
	private String g_writer;
	private String g_password;
	private String g_image;
}
