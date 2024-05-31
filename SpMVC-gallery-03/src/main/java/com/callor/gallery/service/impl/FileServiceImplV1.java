package com.callor.gallery.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.config.QualifierConfig;
import com.callor.gallery.models.ImageVO;
import com.callor.gallery.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_SERVICE_V1)
public class FileServiceImplV1 implements FileService {
	
	/*
	 * 편의상 FileServiceImplV1 을 FileServiceV2 에서 상속하였다
	 * V1 과 V2 는 FileService 인터페이스를 implements 하고 있다
	 * 결국 두 클래스는 모두 FileService 인터페이스의 자손이다
	 * V1 에서 구현된 코드를 V2 에서 확장(일부 변경)하여 사용하고자 한다
	 * 이때 V1 과 V2 는 모두 upLoadPath 변수를 사용해야 한다
	 * 이럴경우 변수를 private 으로 선언해 버리면
	 * V2 에서 다시 생성자를 통하여 upLoadPath 변수를 주입받아야 한다
	 * 상속을 해 주려는 클래스와 상속을 받는 클래스에서 공통으로
	 * 사용하는 변수가 있을 경우 이 변수는 protected 로 선언해야 한다
	 * 
	 * 또한 유의해야 할 것은
	 * 생성자는 상속 되지 않는다
	 * 
	 */
	protected final String upLoadPath;
	public FileServiceImplV1(String upLoadPath) {
		this.upLoadPath = upLoadPath;
		log.debug("업로드 폴더 {}", this.upLoadPath);
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		String fileName = file.getOriginalFilename();
		if(fileName.isBlank()) {
			return null;
		}
		File path = new File(upLoadPath);
		// 업로드할 폴더가 없으면 폴더 생성하기
		if( !path.exists() ) {
			/*
			 * path.mkdir(), path.mkdirs()
			 * 폴더를 생성하는 method
			 * mkdir() : 한개의 폴더만 생성하기 : app/upload 폴더를 생성할경우
			 * 		app 폴더가 없으면 오류가 발생
			 * mkdirs() : 여러 경로의 폴더 생성하기 : app/upload 폴드를 생성할 경우
			 * 		app 폴더, upload 폴더를 모두 생성
			 */
			path.mkdirs();
		}
		
		String uuid = UUID.randomUUID().toString();
		// 원래의 파일이름 앞에 uuid 를 부착하여 업로드할 파일이름 생성
		// 파일이름 injection 공격 대비
		fileName = String.format("%s-%s",uuid,fileName);
		File upload = new File(upLoadPath, fileName);
		
		// Multipart 클래스에 정의된 파일 전송 method;
		file.transferTo(upload);
		
		// DB 에 파일이름을 저장하기 위해서 변경된 파일이름을 return 하기
		return fileName;
	}

	@Override
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) throws Exception {

		/*
		 * view의 form input[type='file'] tag 의 name( =files) 속성을 통하여
		 * 파일 리스트 추출하기
		 */
		List<MultipartFile> fileList = files.getFiles("files");
		List<ImageVO> resultFiles = new ArrayList<>();	
		for(MultipartFile file : fileList) {
			String resultName = this.fileUp(file);
			String originName = file.getOriginalFilename();
			ImageVO vo = ImageVO.builder()
						.i_up_image(resultName)
						.i_origin_image(originName)
						.build();
			resultFiles.add(vo);
		}
		return resultFiles;
	}

}
