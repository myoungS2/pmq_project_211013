package com.pmq.timeline;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pmq.edition.bo.EditionBO;
import com.pmq.edition.model.Edition;
import com.pmq.user.bo.UserBO;
import com.pmq.user.model.User;

@RequestMapping("/timeline")
@Controller
public class TimelineController {
	
	// UserBO 연결
	@Autowired
	private UserBO userBO;
	
	// EditionBO 연결
	@Autowired
	private EditionBO editionBO;
	
	// 타임라인 뷰 
	// edtion(썸네일, 썸네일클릭 시) , user 정보 연결(로그인 시)
	// 검색기능 연결
	@RequestMapping("/view")
	public String timelineView(Model model, HttpServletRequest request) {
		
		// 로그인 여부 확인-> userId정보 내려주기
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		// TODO: userId로 userRole정보 내려주기 -> 발행시작 버튼 (publisher일때만 보이게)
		 User user = userBO.getUser(userId);
		 model.addAttribute("userInfo" ,user);
		 
		// edition(전체) 가져와서 thumbnailPath 뿌려주기
		List<Edition> editionList = editionBO.getEditionList();
		model.addAttribute("editionList", editionList);
		
		model.addAttribute("viewName", "timeline");
		
		return "template/layout_timeline";
	}
}