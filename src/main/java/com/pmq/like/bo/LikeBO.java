package com.pmq.like.bo;

import org.springframework.stereotype.Service;

import com.pmq.like.dao.LikeDAO;

@Service
public class LikeBO {
	// LikeDAO 연결
	private LikeDAO likeDAO;
	
	// 좋아요 여부
		public void LikeYn(int userId, String userNickname, int editionId) {
			boolean existLike = existLike(editionId, userId);
			if (existLike) {
				likeDAO.deleteLikeByEditionIdUserId(editionId, userId);
			} else {
				likeDAO.insertLike(userId, userNickname, editionId);
			}
		}
		
		public boolean existLike(int editionId, Integer userId) {
			// 로그인 하지 않을 시 좋아요x
			if (userId == null) {
				return false;
			}
			
			int count = likeDAO.selectLikeCountByEditionIdOrUserId(editionId, userId);
			return count > 0? true : false; // 이 부분 코드가 무슨 뜻일까...(if문 짧게 -> 삼항연산자)
		}
		
		// select like count 
		public int getLikeCountByEditionId(int editionId) {
			return likeDAO.selectLikeCountByEditionIdOrUserId(editionId, null); 
		}
		
		// delete like
		public void deleteLikeByEditionIdUserId(int editionId, int userId) {
			likeDAO.deleteLikeByEditionIdUserId(editionId, userId);
		}
}
