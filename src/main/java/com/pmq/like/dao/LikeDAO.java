package com.pmq.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	// select DB (LikeCount)
		public int selectLikeCountByEditionIdOrUserId(
				@Param("userId") Integer userId,
				@Param("editionId") int editionId);
		
		// insert DB
		public void insertLike(
				@Param("userId") int userId,
				@Param("userNickname") String userNickname,
				@Param("editionId") int editionId);
		
		// delete DB
		public void deleteLikeByEditionIdUserId(
				@Param("userId") int userId,
				@Param("editionId") int editionId);
}
