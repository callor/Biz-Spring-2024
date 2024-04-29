package com.callor.gallery.exec;

import com.callor.gallery.models.GalleryVO;

public class CallByRef {

	
	public static void getGid(GalleryVO vo) {
		vo.setG_id("000111000");
	}
	
	public static void main(String[] args) {
		GalleryVO gVO = new GalleryVO();
		System.out.println(gVO.getG_id());
		
		getGid(gVO);
		System.out.println(gVO.getG_id());
		
	}

}
