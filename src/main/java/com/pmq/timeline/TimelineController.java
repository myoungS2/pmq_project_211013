package com.pmq.timeline;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/timeline")
@Controller
public class TimelineController {
	
	// 타임라인 뷰 
	// TODO: edtion(썸네일, 썸네일클릭 시) , user 정보 연결(로그인 시)
	// TODO: 검색기능 연결
	@RequestMapping("/view")
	public String timelineView(Model model) {
		
		// TODO: 로그인 여부 확인-> userId정보 내려주기
		// TODO: edition(전체) 가져와서 thumbnailPath 뿌려주기
		
		model.addAttribute("viewName", "timeline");
		
		return "template/layout_timeline";
	}
}
