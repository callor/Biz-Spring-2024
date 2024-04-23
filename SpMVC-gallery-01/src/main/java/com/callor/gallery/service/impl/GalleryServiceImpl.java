package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GalleryServiceImpl implements GalleryService{

	private final GalleryDao galleryDao;
	public GalleryServiceImpl(GalleryDao galleryDao) {
		super();
		this.galleryDao = galleryDao;
	}


	/*
	 * 입력화면에서 제목, 내용, 이미지(base64)를 전달받고
	 * 여기에 작성일자, 작성시각, PK 값을 생성하여 VO 를 다시 세팅하고
	 * Dao 에 전달하여 데이터를 insert 하도록 하기 
	 */
	@Override
	public GalleryVO createGallery(GalleryVO vo) {

		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");

		/*
		 * UUID v5(또는 v4) 를 사용하기 위하여 randomUUID() method 를 호출하여
		 * UUID 값을 만들기
		 */
		vo.setG_id(UUID.randomUUID().toString());
		vo.setG_date(lt.format(date));
		vo.setG_time(lt.format(time));
		vo.setG_author("callor@callor");
		
		log.debug("ID {}, date {}, date {}, Subject {} ",
			vo.getG_id(), vo.getG_date(), vo.getG_time(),vo.getG_subject());
		
		int ret = galleryDao.insert(vo);
		if(ret > 0) {
			return vo;
		}
		return null;
	}

}
