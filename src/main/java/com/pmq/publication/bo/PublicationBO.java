package com.pmq.publication.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmq.publication.dao.PublicationDAO;
import com.pmq.publication.model.Publication;

@Service
public class PublicationBO {
	// Publication DAO 연결
	@Autowired
	private PublicationDAO publicationDAO;
	
	// select DB 
	public List<Publication> getPublicationList(int userId){
		return publicationDAO.selectPublicationList(userId);
	}
	
	// insert DB
	public int createPublication(int editionId, int userId, 
		String userNickname, String subject, String content, String state) {
	return publicationDAO.insertPublication(editionId, userId, userNickname, subject, content, state);
		
	}
	
	// select DB
	public Publication getPublicationById(int id) {
		return publicationDAO.selectPublicationById(id);
	}
	
	// update DB
	
}
