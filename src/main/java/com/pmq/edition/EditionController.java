package com.pmq.edition;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmq.edition.bo.EditionBO;
import com.pmq.edition.model.Edition;
import com.pmq.like.bo.LikeBO;
import com.pmq.publication.bo.PublicationBO;
import com.pmq.publication.model.Publication;
import com.pmq.subscribe.bo.SubscribeBO;
import com.pmq.subscribe.model.Subscribe;
import com.pmq.user.bo.UserBO;
import com.pmq.user.model.User;

@RequestMapping("/edition")
@Controller
public class EditionController {
	// PublicationBO 연결
	@Autowired
	private PublicationBO publicationBO;
	
	// LikeBO 연결
	@Autowired
	private LikeBO likeBO;
	
	// SubscribeBO 연결
	@Autowired
	private SubscribeBO subscribeBO;
	
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
		model.addAttribute("userInfo",userInfo);
			if (userInfo.getRole().equals("publisher")) {
				model.addAttribute("viewName", "edition/publisher_detail");
			} else {
				model.addAttribute("viewName", "edition/subscriber_detail");
			}
		
		// 구독 (여부) -> 취소하기, 구독시작 버튼을 여부에 따라 보여주게 됨
		Boolean existSubscribe =  subscribeBO.existSubscribe(userInfo.getId(), editionId);
		model.addAttribute("existSubscribe", existSubscribe);
		
		// 좋아요 (여부)
		Boolean existLike = likeBO.existLike(editionId, userInfo.getId());
		model.addAttribute("existLike" ,existLike);
		
		// 좋아요 (count)
		int likeCount = likeBO.getLikeCountByEditionId(editionId);
		model.addAttribute("likeCount", likeCount);
		
		// 구독자 리스트
		List<Subscribe> subscriberList = subscribeBO.getSubscribeList(editionId);
		model.addAttribute("subscriberList", subscriberList);
		
		// 발행글 리스트
		List<Publication> publicationList = publicationBO.getPublicationList(userId);
		model.addAttribute("publicationList", publicationList);
		
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
	
	// excel
	@GetMapping("/excel/download")
	public void excelDownload(
			@RequestParam("editionId") int editionId,
			HttpServletResponse response,
			Model model) {
		
		Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet1");
        Row row = null;
        Cell cell = null;
        int rowNum = 1;
        
	    // 구독자 리스트
	    List<Subscribe> subscriberList = subscribeBO.getSubscribeList(editionId);
	    model.addAttribute("subscriberList", subscriberList);
	    
        
        // header
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue("subscriber");
        cell = row.createCell(1);
        cell.setCellValue("subscriber email");
        cell = row.createCell(2);
        cell.setCellValue("subscribe date");
        
        // body (자동증가+내용_subscriberList로 부터)
	}
}
