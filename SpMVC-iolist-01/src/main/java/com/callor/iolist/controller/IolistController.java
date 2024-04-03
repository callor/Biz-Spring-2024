package com.callor.iolist.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.iolist.models.IolistVO;
import com.callor.iolist.persistance.IolistDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/iolist")
public class IolistController {
	
	private final IolistDao iolistDao;
	public IolistController(IolistDao iolistDao) {
		this.iolistDao = iolistDao;
	}
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("BODY","IOLIST_HOME");
		List<IolistVO> iolist = iolistDao.selectAll();
		model.addAttribute("IOLIST",iolist);
		return "layout";
	}
	

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		
		// 날짜와 관련된 java 1.8 이전버전의 클래스
		Date today = new Date();
		Calendar ca = Calendar.getInstance();
		
		// java 1.8 이상에서 사용하는 클래스
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		/*
		 * Builder pattern 을 사용하여 IolistVO 객체 생성하기
		 * Builder pattern 을 사용하면 필요한 필드에 값만 세팅하면서
		 * 객체를 생성할수 있다
		 */
//		IolistVO vo = new IolistVO();
//		vo.setIo_date(localDateTime.format(dayFormat));
//		vo.setIo_time(localDateTime.format(timeFormat));
		
		IolistVO vo = IolistVO.builder()
						.io_date(localDateTime.format(dayFormat))
						.io_time(localDateTime.format(timeFormat))
						.build();
		model.addAttribute("IO",vo);
		model.addAttribute("BODY","IOLIST_INPUT");
		return "layout";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(IolistVO iolistVO, Model model) {
		log.debug(iolistVO.toString());
		int result = iolistDao.insert(iolistVO);
		if(result > 0) 	{
			return "redirect:/iolist/";
		} else {
			model.addAttribute("BODY","IOLIST_INPUT");
			return "layout";
		}
	}
}
