package com.pmq.like.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pmq.like.model.Like;

@Repository
public interface LikeDAO {
	// select DB (LikeCount)
		public int selectLikeCountByEditionIdOrUserId(
				@Param("userId") int userId,
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
		
	// selectLikeListByUserId
	public List<Like> selectLikeListByUserId(int userId);
}
