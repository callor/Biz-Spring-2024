package com.callor.gallery.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImagesVO {
	
	private String i_id;		//	VARCHAR(125)
	private String i_gid;		//	VARCHAR(125)
	private String i_origin_image;//	VARCHAR(255)
	private String i_up_image;//	VARCHAR(255)


}
