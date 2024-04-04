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
import org.springframework.web.bind.annotation.PathVariable;
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

	/*
	 * POST /insert 와 POST /update/seq 로 요청이 들어오면
	 * 모두 처리하는 method
	 */
	@RequestMapping(value={"/insert","/update/{seq}" },method=RequestMethod.POST)
	public String insertOrUpdate(@PathVariable(name = "seq",required = false,value="") 
					String seq, IolistVO iolistVO, Model model) {
		
		if( seq != null) {
			iolistVO.setIo_seq(Long.valueOf(seq));
		}
		log.debug(iolistVO.toString());
		
		int result = iolistDao.insertOrUpdate(iolistVO);
		if(result > 0) 	{
			return "redirect:/iolist/";
		} else {
			model.addAttribute("BODY","IOLIST_INPUT");
			return "layout";
		}
	}
	
	@RequestMapping(value="/detail/{seq}",method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model) {
		
		Long io_seq = Long.valueOf(seq);
		IolistVO vo = iolistDao.findBySeq(io_seq);
		
		model.addAttribute("IO",vo);
		model.addAttribute("BODY","IOLIST_DETAIL");
		return "layout";
	}
	
	@RequestMapping(value="/update/{seq}",method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq,Model model) {
		
		Long io_seq = Long.valueOf(seq);
		IolistVO vo = iolistDao.findBySeq(io_seq);
		model.addAttribute("IO",vo);
		model.addAttribute("BODY","IOLIST_INPUT");
		return "layout";
	}
	
	
}
