package com.callor.gallery.service;

import com.callor.gallery.models.GalleryVO;

/*
 * Spring MVC 에서 Service 인터페이스 및 클래스
 * MVC 패턴에서는 Controller == Dao 간에 연결을 통하여 
 * 기본적인 CRUD 를 구현할 수 있다.
 * 그러기 위해서는 Controller 에 Dao 를 DI 하여 사용을 하면된다
 * 하지만 Controller 는 Front 와 연계되어 매우 빈번하게 호출되는 클래이다
 * Controller 클래스에 많은 요소들이 첨가되어 있으면 아무래도 성능상에
 * 이슈가 발생할 수 있다
 * 
 * 그래서 외부 다른 요소, 도구를 사용하여 연산을 수행이 필요한 경우
 * 중간에 Service 를 두고, 그곳에서 처리하는 것이 다소간에 연산의 잇점이 있다
 * 
 * 만약 매우 단순하게 Controller 와 Dao 간에 1:1 로 매칭되어 진행이 될수 있는 경우라도
 * 가급적 중간에 Service 가 Toss 역할을 수행하도록 하는 것을 권장한다
 */

public interface GalleryService {
	
	public GalleryVO createGallery(GalleryVO vo) ;

}
