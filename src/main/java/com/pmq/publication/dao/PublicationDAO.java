package com.pmq.publication.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pmq.publication.model.Publication;

@Repository
public interface PublicationDAO {
	
	// select DB
	public Publication selectPublication();
	
	// insert DB
	public void insertPublication(
			@Param("editionId") int editionId, 
			@Param("userId") int userId, 
			@Param("userNickname") String userNickname, 
			@Param("subject") String subject, 
			@Param("content") String content, 
			@Param("state") String state);
}
