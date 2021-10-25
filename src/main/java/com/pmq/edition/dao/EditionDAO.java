package com.pmq.edition.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.pmq.edition.model.Edition;

@Repository
public interface EditionDAO {
	
	/**
	 * insert edition
	 * @param userId
	 * @param userNickname
	 * @param thumbnailPath
	 * @param subject
	 * @param category
	 * @param publishingDate
	 * @param content
	 * @return
	 */
	public int insertEdition(
		@Param("userId") int userId,
		@Param("userLoginId") String userLoginId,
		@Param("thumbnailPath")String thumbnailPath,
		@Param("subject")String subject,
		@Param("category")String category,
		@Param("publishingDate")int publishingDate,
		@Param("content")String content);
	

	/**
	 * select edition List
	 * @return
	 */
	public List<Edition> selectEditionList();
	
	/**
	 * select edition by editionId
	 * @param id
	 * @return
	 */
	public Edition selectEdition(int id);
	
	/**
	 * update edition
	 * @param editionId
	 * @param userId
	 * @param userLoginId
	 * @param thumbnailPath
	 * @param subject
	 * @param category
	 * @param publishingDate
	 * @param content
	 */
	public void updateEdition(
			@Param("id") int editionId,
			@Param("userId") int userId,
			@Param("userLoginId") String userLoginId,
			@Param("thumbnailPath")String thumbnailPath,
			@Param("subject")String subject,
			@Param("category")String category,
			@Param("publishingDate")int publishingDate,
			@Param("content")String content);
	
	// delete Edition
	public void deleteEdition(int id);
	
}
