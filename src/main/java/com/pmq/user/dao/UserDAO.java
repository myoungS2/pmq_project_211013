package com.pmq.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pmq.user.model.User;

@Repository
public interface UserDAO {
	
	/**
	 * 아이디 중복확인
	 * @param loginId
	 * @return
	 */
	public boolean existLoginId(String loginId);
	
	/**
	 * 닉네임 중복확인
	 * @param nickname
	 * @return
	 */
	public boolean existNickname(String nickname);
	
	/** 
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param profileImgPath
	 * @param name
	 * @param nickname
	 * @param address
	 * @param website
	 * @param introduce
	 * @param role
	 * @return
	 */
	public int insertUser(
			@Param("loginId")String loginId, 
			@Param("password")String password, 
			@Param("profileImgPath")String profileImgPath, 
			@Param("name")String name, 
			@Param("nickname")String nickname, 
			@Param("email")String email,
			@Param("address")String address, 
			@Param("website")String website,
			@Param("introduce")String introduce, 
			@Param("role")String role);
	
	/**
	 * 로그인
	 * @param loginId
	 * @param password
	 * @return
	 */
	public User selectUserByLoginIdAndPassword(
			@Param("loginId")String loginId, 
			@Param("password")String password);
	
	
	
}
