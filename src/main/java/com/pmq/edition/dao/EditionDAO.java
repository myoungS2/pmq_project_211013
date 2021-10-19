package com.pmq.edition.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface EditionDAO {
	
	// 발행글 등록
	public int insertEdition(
		@Param("userId") int userId,
		@Param("imagePath")String imagePath,
		@Param("subject")String subject,
		@Param("category")String category,
		@Param("publishingDate")int publishingDate,
		@Param("content")String content);
}
