package com.pmq.like.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmq.like.dao.LikeDAO;
import com.pmq.like.model.Like;

@Service
public class LikeBO {
	
	// LikeDAO 연결
	@Autowired
	private LikeDAO likeDAO;
	
	// 좋아요 여부
		public void LikeYn(int userId, String userNickname, int editionId) {
			boolean existLike = existLike(userId, editionId);
			if (existLike) {
				likeDAO.deleteLikeByEditionIdUserId(userId, editionId);
			} else {
				likeDAO.insertLike(userId, userNickname, editionId);
			}
		}
	
		public boolean existLike(int userId, int editionId) {
			int count = likeDAO.selectLikeCountByEditionIdOrUserId(userId, editionId);
			return count > 0? true : false; // 이 부분 코드가 무슨 뜻일까...(if문 짧게 -> 삼항연산자)
		}
	
		// select like count 
		public int getLikeCountByEditionId(int userId,int editionId) {
			return likeDAO.selectLikeCountByEditionIdOrUserId(userId ,editionId); 
		}
		
	// getLikeListByUserid
		public List<Like> getLikeListByUserId (int loginUserId){
			return likeDAO.selectLikeListByUserId(loginUserId);
		}
	
}
