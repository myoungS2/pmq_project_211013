package com.pmq.publication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/publication")
@Controller
public class PublicationController {
	
	// 발행글 작성 뷰(메일로 보내지는 글)
	@RequestMapping("/create_view")
	public String publicationCreateView(Model model) {
		
		model.addAttribute("viewName", "publication/create");
		return "/template/layout_publication";
	}
}
