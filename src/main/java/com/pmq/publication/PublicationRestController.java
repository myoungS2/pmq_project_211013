package com.pmq.publication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmq.publication.bo.PublicationBO;
import com.pmq.publication.model.Publication;

@RequestMapping("/publication")
@RestController
public class PublicationRestController {
	
	// Publication BO 연결
	@Autowired
	private PublicationBO publicationBO;
	
	// 발행 (발행->메일)
	@PostMapping("/create")
	public Map<String, Object> publicationSend(
			@RequestParam("editionId") int editionId,
			@RequestParam("userId") int userId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			@RequestParam("state") String state,
			HttpServletRequest request,
			Model model){
		
		// session에서 유저정보 가져오기
		HttpSession session = request.getSession();
		String userNickname = (String) session.getAttribute("userNickname");
		
		Map<String, Object> result = new HashMap<>();
		
		// insert DB
		int row = publicationBO.createPublication(editionId, userId, userNickname, subject, content, state);
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
		}	
		return result;
	}
	
	// 발행 (임시저장->메일)
	
}
