package com.pmq.subscribe;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmq.subscribe.bo.SubscribeBO;



@RequestMapping("/subscribe")
@RestController
public class SubscribeRestController {
	// SubscribeBO 연결
	private SubscribeBO subscribeBO;
	
	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// start subscribe
	@RequestMapping("/start")
	public Map<String, Object> subscribeStart(
			@RequestParam("editionId") int editionId,
			HttpServletRequest request){
		
		Map<String, Object> result = new HashMap<>();
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		String userLoginId = (String) session.getAttribute("userLoginId");
		if (userId == null) {
			result.put("result", "error");
			logger.error("[subscribe] no userId");
			return result;
		}
		
		// insert DB
		subscribeBO.SubscribeYN(userId, userLoginId, editionId);
		result.put("result", "success");
		return result;
	}
}
