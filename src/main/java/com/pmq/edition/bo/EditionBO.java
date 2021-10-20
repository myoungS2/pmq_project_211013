package com.pmq.edition.bo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pmq.common.FileManagerService;
import com.pmq.edition.dao.EditionDAO;

@Service
public class EditionBO {
	// EditionDAO 연결
//	@Autowired
//	private EditionDAO editionDAO;
//	
//	// FileManagerService 연결
//	@Autowired
//	private FileManagerService fileManagerService;
//	
//	// 발행글 등록
//	public int createEdition(
//			int userId,
//			String userNickname,
//			MultipartFile thumbnailPath, 
//			String subject, 
//			String category,
//			int publishingDate, 
//			String content) {
//		
//		String imagePath = null;
//		
//		// fileManagerService 이미지 주소를 요청(사용자가 업로드한 파일을 그대로 DB에 저장할 수 없으므로!)
//		
//		if (thumbnailPath != null) {
//			try {
//				imagePath = fileManagerService.saveFile(userNickname, thumbnailPath);
//			} catch (IOException e) {
//				imagePath = null;
//			}
//		}
//		
//		return editionDAO.insertEdition(userId, imagePath, subject, category, publishingDate, content);
//	
}
