package com.pmq.edition.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.pmq.edition.model.Edition;

@Repository
public interface EditionDAO {
	
	/**
	 * insert Edition
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
	
	// 등록 된 발행글 가져오기
	public List<Edition> selectEditionList();
}
