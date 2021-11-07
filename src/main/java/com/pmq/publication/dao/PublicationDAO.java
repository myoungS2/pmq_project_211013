package com.pmq.publication.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pmq.publication.model.Publication;

@Repository
public interface PublicationDAO {
	
	// select DB
	public List<Publication> selectPublicationList(int userId);
	
	// insert DB
	public int insertPublication(
			@Param("editionId") int editionId, 
			@Param("userId") int userId, 
			@Param("userNickname") String userNickname, 
			@Param("subject") String subject, 
			@Param("content") String content, 
			@Param("state") String state);
	
	// select DB
	public Publication selectPublicationById(int id);
	
}
