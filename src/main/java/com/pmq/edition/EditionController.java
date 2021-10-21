package com.pmq.edition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmq.edition.bo.EditionBO;
import com.pmq.edition.model.Edition;
import com.pmq.user.bo.UserBO;
import com.pmq.user.model.User;

@RequestMapping("/edition")
@Controller
public class EditionController {
	// EditionBO 연결
	@Autowired
	private EditionBO editionBO;
	
	// UserBO 연결
	@Autowired
	private UserBO userBO;
	
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
			@RequestParam("editionId") int editionId,
			Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// edition가져오기
		Edition editionInfo = editionBO.getEdition(editionId);
		model.addAttribute("editionInfo", editionInfo);
		
		// user Role정보 가져와서 각각 다른 viewName내려보내주기
		User userInfo = userBO.getUser(userId);
		if (userInfo.getRole().equals("publisher")) {
			model.addAttribute("viewName", "edition/publisher_detail");
		} else {
			model.addAttribute("viewName", "edition/subscriber_detail");
		}
		
		return "/template/layout_edition";
		
	}
	
	
}
