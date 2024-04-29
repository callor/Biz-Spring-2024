package com.callor.gallery.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.ImageVO;
import com.callor.gallery.service.FileUploadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileUploadServiceImpl implements FileUploadService{

	private final String folder;  
	
	// Spring 에서 제공하는 프로젝트 Context 정보를 담고있는 객체
	private final ServletContext context;
	public FileUploadServiceImpl(ServletContext context) {
		super();
		this.context = context;
		
		// tomcat 폴더가 아닌 Servr 의 로컬 스토리지의 임의의 폴더
		folder = "/app/upload";
	}

	@Override
	public String fileUpload(MultipartFile file) throws Exception {
		
		String orignalFileName = file.getOriginalFilename();
		if(orignalFileName.isEmpty()) {
			return null;
		}
		
		/*
		 * context.getRealPath("path") 이 method 는
		 * 실행중인 Server 의 Work Folder 를 가리킨다
		 * Server 가 정상적으로 실행되는 동안에는 아무런 묹제 없이 이 폴더에
		 * 파일을 저장하거나, 읽기가 가능하다
		 * 하지만 Tomcat WorkDirectory Clean 을 실행하면 이 폴더는 삭제 되어 버린다
		 * 파일을 업로드 할때 절대 이 폴더에 저장하면 안된다.
		 */
		// 프로젝트 contextRoot/static/upload 폴더 정보 지정하기
		// 실제로른 프로젝트/webapp/static/upload 폴더를 가리킨다
		// String folder = context.getRealPath("/static/upload");
		// log.debug("업로드 폴더 {}",folder);
		
		
		
		// 문자열로 된 폴더 정보를 Java 에서 사용하기 위해 객체로 변환하기
		File path = new File(folder);
		
		// 업로드할 폴더를 검사해 보고 없으면 생성하라
		if(!path.exists()) {
			path.mkdirs();
		}
		
		/*
		 * 같은 이름의 파일을 업로드하여 기존에 업로드된 파일을 변형하는 공격을
		 * 막기 위하여 파일이름 앞에 UUID 를 부착하여 저장되는 파일의 이름을
		 * 변형한다
		 */
		String uuid =  UUID.randomUUID().toString();
		String upLoadFileName = String.format("%s-%s", uuid,orignalFileName);
		
		
		// 폴더이름 + 파일이름 을 결합하여 업로드할 파일 정보를 생성하여 
		// upLoadFile 객체에 저장
		File upLoadFile = new File(folder,upLoadFileName);
		
		// file 을 upLoadFile 정보로 복사하라
		// 업로드를 실행하라
		file.transferTo(upLoadFile);
		
		// 실제 저장된 파일의 이름을 return
		return upLoadFileName;
	}

	@Override
	public List<ImageVO> filesUpload(MultipartHttpServletRequest files) throws Exception {

		// 업로드된 멀티파일을 List type 의 MultipartFile 로 분해하기
		// 업로드된 멀티파일을 추출하기 위해서 "파일즈.getFiles("이름")" 를 사용하는데
		// 이름 은 form 의 input tag 에 붙여진 이름을 사용한다.
		List<MultipartFile> result = files.getFiles("image_files");
		List<ImageVO> resultImages = new ArrayList<>();
		for(MultipartFile f : result) {
			String resName = this.fileUpload(f);
			resultImages.add(
					ImageVO.builder()
						.i_id(UUID.randomUUID().toString())
						.i_origin_image(f.getOriginalFilename())
						.i_up_image(resName).build()
			);
		}
		return resultImages;
	}
	
	

}
