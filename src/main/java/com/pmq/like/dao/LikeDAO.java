package com.pmq.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	// select DB (LikeCount)
		public int selectLikeCountByEditionIdOrUserId(
				@Param("editionId") int editionId,
				@Param("userId") Integer userId);
		
		// insert DB
		public void insertLike(
				@Param("userId") int userId,
				@Param("userNickname") String userNickname,
				@Param("editionId") int editionId);
		
		// delete DB
		public void deleteLikeByEditionIdUserId(
				@Param("editionId") int editionId,
				@Param("userId") int userId);
}
