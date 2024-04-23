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
public class BBsVO {

	private String b_id;
	private String b_date;
	private String b_time;
	private String b_writer;
	private String b_subject;
	private String b_content;
}
