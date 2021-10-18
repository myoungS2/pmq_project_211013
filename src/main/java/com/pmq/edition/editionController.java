package com.pmq.edition;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/edition")
@Controller
public class editionController {
	
	// 에디션 글 작성 뷰
	@RequestMapping("/create_view")
	public String editionCreateView(Model model) {
		
		model.addAttribute("viewName", "edition/create");
		return "/template/layout_edition";
	}
	
}
