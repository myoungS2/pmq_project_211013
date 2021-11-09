package com.pmq.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmq.like.bo.LikeBO;

@RequestMapping("/like")
@RestController
public class LikeRestController {
	// logger
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// LikeBO 연결
	@Autowired
	private LikeBO likeBO;
	
	@RequestMapping("/like")
	public Map<String, Object> like(
			@RequestParam("editionId") int editionId,
			@RequestParam("userId") int userId,
			HttpServletRequest request){
		
		Map<String, Object> result = new HashMap<>();
		HttpSession session = request.getSession();
//		Integer userId = (Integer) session.getAttribute("userId");
		String userNickname = (String) session.getAttribute("userNickname");
		
		
		// like BO
		likeBO.LikeYn(userId, userNickname, editionId);
			result.put("result", "success");
			return result;
		}
}
