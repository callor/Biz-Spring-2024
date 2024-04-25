package com.callor.gallery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	private final GalleryService galleryService;
	public GalleryController(GalleryService galleryService) {
		super();
		this.galleryService = galleryService;
	}

	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		List<GalleryVO> gList = galleryService.selectAll();
		model.addAttribute("GALLERYS",gList);
		return "gallery/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		GalleryVO galleryVO = GalleryVO.builder()
				.g_up_image("no_image.png")
				.g_origin_image("no_image.png")
				.build();
		model.addAttribute("GALLERY",galleryVO);
		return "gallery/input";
	}

	/*
	 * MultipartFile : form 의 input[type='file'] tag 에 담겨서 전달되는
	 * 파일을 수신하는 객체
	 * 
	 * MultipartHttpServletRequest : form 의 input[type='file'] tag 에 
	 * 담겨서 전달되는 여러개의 파일을 수신하는 객체
	 * 여기에는 절대 @RequestParam() 을 붙여서는 안된다.
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(GalleryVO galleryVO,
			
			@RequestParam("image_file")
			MultipartFile image_file,
			
			MultipartHttpServletRequest image_files,
			Model model) {
		
		log.debug("파일 업로드 {}", image_file.getOriginalFilename());

		String singleFileName = image_file.getOriginalFilename();
		GalleryVO resultVO = null;
		try {
			if(!singleFileName.isEmpty()) {
				resultVO = galleryService.createGallery(galleryVO,image_file);
			}
			/*
			 * Multi file 의 경우는 매개변수의 이름과 form 에서 전달한 이름은
			 * 전혀 연관이 없다
			 * Multi 파일의 경우는 변수.getFiles() method 를 실행할때
			 * form 에서 설정한 name 속성값을 매개변수로 전달한다
			 */
			if(image_files.getFiles("image_files").size() > 0 ) {
				List<GalleryVO> VOs 
					= galleryService
						.createGallery(galleryVO, image_files);
			}
			model.addAttribute("GALLERY",resultVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("IMAGE",image_file.getOriginalFilename());
		return "gallery/input";
	}

	
}
