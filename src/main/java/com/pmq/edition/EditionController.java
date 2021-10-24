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
	
	/**
	 * edition create view
	 * @param model
	 * @return
	 */
	@RequestMapping("/create_view")
	public String editionCreateView(Model model) {
		
		model.addAttribute("viewName", "edition/create");
		return "/template/layout_edition";
	}
	
	/**
	 * edition detail view
	 * @param userId
	 * @param editionId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/detail_view")
	public String editionDetailView(
			// 클릭한 글이 어떤 글인지, 그 글을 누가 썼는지 넘겨받기
			@RequestParam("userId") int userId,
			@RequestParam("editionId") int editionId,
			Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer loginUserId = (Integer)session.getAttribute("userId");
		
		// edition가져오기 -> 넘겨받은 파라미터
		Edition editionInfo = editionBO.getEdition(editionId);
		model.addAttribute("editionInfo", editionInfo);
		
		// edition 작성 user(publisher)정보 가져오기 -> 넘겨받은 파라미터
		User publisherInfo = userBO.getPublisher(userId);
		model.addAttribute("publisherInfo", publisherInfo);
		
		// user Role정보 가져와서 각각 다른 viewName내려보내주기 -> 로그인 된 유저정보
		User userInfo = userBO.getUser(loginUserId);
		if (userInfo.getRole().equals("publisher")) {
			model.addAttribute("viewName", "edition/publisher_detail");
		} else {
			model.addAttribute("viewName", "edition/subscriber_detail");
		}
		
		// 좋아요 (여부)
		
		// 좋아요 (count)
		
		// 구독자 리스트
		
		// 발행글 리스트
		
		return "/template/layout_edition";
		
	}
	
	// edition update view
	@RequestMapping("/update_view")
	public String editionUpdateView(
			// 클릭한 글이 어떤 글인지, 그 글을 누가 썼는지 넘겨받기
			@RequestParam("userId") int userId,
			@RequestParam("editionId") int editionId,
			Model model,
			HttpServletRequest request) {
		
		// edition가져오기 -> 넘겨받은 파라미터
		Edition editionInfo = editionBO.getEdition(editionId);
		model.addAttribute("editionInfo", editionInfo);
		
		// edition 작성 user(publisher)정보 가져오기 -> 넘겨받은 파라미터
		User publisherInfo = userBO.getPublisher(userId);
		model.addAttribute("publisherInfo", publisherInfo);
		
		
		model.addAttribute("viewName", "edition/update");
		
		return "/template/layout_edition";
	}
}
