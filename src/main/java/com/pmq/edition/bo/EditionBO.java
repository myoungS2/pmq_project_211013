package com.pmq.edition.bo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pmq.common.FileManagerService;
import com.pmq.edition.dao.EditionDAO;
import com.pmq.edition.model.Edition;

@Service
public class EditionBO {
	// EditionDAO 연결
	@Autowired
	private EditionDAO editionDAO;
	
	// FileManagerService 연결
	@Autowired
	private FileManagerService fileManagerService;
	
	/**
	 * create Edition
	 * @param userId
	 * @param userNickname
	 * @param file
	 * @param subject
	 * @param category
	 * @param publishingDate
	 * @param content
	 * @return
	 */
	public int createEdition(int userId, String userLoginId, MultipartFile file, String subject, String category,int publishingDate, String content) {
		
		// fileManagerService 이미지 주소를 요청(사용자가 업로드한 파일을 그대로 DB에 저장할 수 없으므로!)
		String thumbnailPath = null;
		
		if (file != null) {
			try {
				thumbnailPath = fileManagerService.saveFile(userLoginId, file);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return editionDAO.insertEdition(userId, userLoginId , thumbnailPath, subject, category, publishingDate, content);
	}
	
	/**
	 * get Edition List
	 * @return
	 */
	public List<Edition> getEditionList(){
		return editionDAO.selectEditionList();
	}
	
	// select edition by editionId
	public Edition getEdition(int editionId) {
		return editionDAO.selectEdition(editionId);
	}
	
	
}	