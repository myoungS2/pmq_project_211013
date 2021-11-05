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
	
	// 발행
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
		
		// select DB (state확인, null확인 후 createDB 가능하도록)
		Publication publication = publicationBO.getPublication();
		// 만약 state가 send일 경우 -> 또 보내지면 x
		if (publication.getState().contains("send")) {
			result.put("result", "error");
		}
		
		// insert DB
		publicationBO.createPublication(editionId, userId, userNickname, subject, content, state);
		
		
		return result;
		
	}
}
