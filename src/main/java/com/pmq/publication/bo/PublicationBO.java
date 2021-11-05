package com.pmq.publication.bo;

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
	public Publication getPublication(){
		return publicationDAO.selectPublication();
	}
	
	// insert DB
	public void createPublication(int editionId, int userId, 
			String userNickname, String subject, String content, String state) {
		publicationDAO.insert();
	}
	
	// update DB
	
}
