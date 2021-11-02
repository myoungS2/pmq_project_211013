package com.pmq.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pmq.edition.bo.EditionBO;
import com.pmq.edition.model.Edition;
import com.pmq.like.bo.LikeBO;
import com.pmq.like.model.Like;
import com.pmq.subscribe.bo.SubscribeBO;
import com.pmq.subscribe.model.Subscribe;
import com.pmq.user.bo.UserBO;
import com.pmq.user.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// UserBO 연결
	@Autowired
	private UserBO userBO;
	
	// EditionBO 연결
	@Autowired
	private EditionBO editionBO;
	
	// SubscribeBO 연결
	@Autowired
	private SubscribeBO subscribeBO;
	
	// LikeBo 연결
	@Autowired
	private LikeBO likeBO;
	
	/**
	 * 로그인 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/sign_in_view")
	public String signInView(Model model) {
		model.addAttribute("viewName", "user/sign_in");
		return "/template/layout_user";
	}
	
	/**
	 * 회원가입 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/sign_up_view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "user/sign_up");
		return "/template/layout_user";
	}
	
	// 프로필 화면
	@RequestMapping("/profile_view")
	public String profileView(
			Model model,
			HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		Integer loginUserId = (Integer)session.getAttribute("userId");	
		
		// edition (publisher)
		List<Edition> editionList = editionBO.getEditionListByUserId(loginUserId);
		model.addAttribute("editionList", editionList);
		
		// subscribe (subscriber)
		List<Subscribe> subscribeList = subscribeBO.getSubscribeListByUserId(loginUserId);
		model.addAttribute("subscribeList", subscribeList);
		
		// like (subscriber)
		List<Like> likeList = likeBO.getLikeListByUserId(loginUserId);
		model.addAttribute("likeList", likeList);
		
		List<Map<String, Object>> subscribeEdtionList = subscribeBO.getSubscribeEdtionList();
		model.addAttribute("subscribeEdtionList",subscribeEdtionList);

		// user Role정보 가져와서 각각 다른 viewName내려보내주기 -> 로그인 된 유저정보
		User userInfo = userBO.getUser(loginUserId);
		model.addAttribute("userInfo",userInfo);
			if (userInfo.getRole().equals("publisher")) {
				model.addAttribute("viewName", "user/publisher_profile");
			} else {
				model.addAttribute("viewName", "user/subscriber_profile");
			}
		 
			
	return "/template/layout_profile";
	
	}

	// 프로필 수정 화면
	@RequestMapping("/profile_update_view")
	public String profileUpdateView(
			Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer loginUserId = (Integer)session.getAttribute("userId");
		
		User userInfo = userBO.getUser(loginUserId);
		model.addAttribute("userInfo",userInfo);
		
		model.addAttribute("viewName", "/user/update_profile");
		
		return "/template/layout_user";
		
	}
}
