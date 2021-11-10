package com.pmq.publication.bo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pmq.publication.model.Mail;
import com.pmq.publication.model.Publication;
import com.pmq.subscribe.bo.InterestBO;
import com.pmq.subscribe.model.InterestView;

@Service
public class MailBO {
	// interestBO 연결
	@Autowired
	private InterestBO interestBO;
	
	// publicationBO 연결
	@Autowired
	private PublicationBO publicationBO;
	
	public List<Mail> sendMail(
			int UserId,
			int editionId,
			int loginUserId) {
		List<Mail> mailList = new ArrayList<>();
		Mail mail = new Mail();
		
		// address, subject, content 가져오기 (각각의 BO로 부터)
		// address -> interestBO
		List<InterestView> interestViewList = interestBO.generateInterestViewList(loginUserId);
		for (InterestView interestView : interestViewList) {
			String address = interestView.getSubscribe().getuserEmail();
			
			mail.setAddress(address);
		}
		
		// subject, content -> publicationBO
		List<Publication> publicationList = publicationBO.getPublicationListByUserIdAndEditionId(UserId, editionId);
		for (Publication publication : publicationList) {
			String subject = publication.getSubject();
			String content = publication.getContent();
			
			mail.setSubject(subject);
			mail.setContent(content);
		}
		mailList.add(mail);
		
		return mailList;
	}
}
