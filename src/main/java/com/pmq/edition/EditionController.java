package com.pmq.edition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/edition")
@Controller
public class EditionController {
	
	// 에디션 글 작성 뷰
	@RequestMapping("/create_view")
	public String editionCreateView(Model model) {
		
		model.addAttribute("viewName", "edition/create");
		return "/template/layout_edition";
	}
	
	// 에디션 디테일 뷰
	@RequestMapping("/detail_view")
	public String editionDetailView(
			// 어떤 글을 클릭하고 들어왔는지 넘겨받아야 한다.
			Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// edition가져오기
		
		// user Role정보 가져와서 각각 다른 viewName내려보내주기
		
		return "/template/layout_edition";
		
	}
	
	
}
