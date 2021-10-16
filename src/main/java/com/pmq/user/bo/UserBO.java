package com.pmq.user.bo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pmq.common.FileManagerService;
import com.pmq.user.dao.UserDAO;
import com.pmq.user.model.User;

@Service
public class UserBO {
	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// FileManagerService 연결
	@Autowired
	private FileManagerService fileManagerService;
	
	// UserDAO 연결
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 아이디 중복확인
	 * @param loginId
	 * @return
	 */
	public boolean existLoginId(String loginId) {
		return userDAO.existLoginId(loginId); 
	}
	
	/**
	 * 닉네임 중복확인
	 * @param nickname
	 * @return
	 */
	public boolean existNickname(String nickname) {
		return userDAO.existNickname(nickname);
	}
	
	/**
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param file
	 * @param name
	 * @param nickname
	 * @param address
	 * @param website
	 * @param introduce
	 * @param role
	 * @return
	 */
	public int addUser(String loginId, String password, MultipartFile file, String name, 
			String nickname, String email ,String address, String website, String introduce, String role) {
		 String profileImgPath = null; 
		 if (file != null) { try {
				profileImgPath = fileManagerService.saveFile(loginId, file);
			} catch (IOException e) {
				logger.error("[파일업로드 에러] " + e.getMessage());
			}
		}
		 
		return userDAO.insertUser(loginId, password, profileImgPath, name, nickname, email, address, website, introduce, role); 
	}
	
	
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdAndPassword(loginId, password);
	}
	
}
