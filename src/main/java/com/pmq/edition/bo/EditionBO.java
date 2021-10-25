package com.pmq.edition.bo;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pmq.common.FileManagerService;
import com.pmq.edition.dao.EditionDAO;
import com.pmq.edition.model.Edition;

@Service
public class EditionBO {
	// logger
	private Logger logger = LoggerFactory.getLogger(EditionBO.class);
	
	// EditionDAO 연결
	@Autowired
	private EditionDAO editionDAO;
	
	// FileManagerService 연결
	@Autowired
	private FileManagerService fileManagerService;
	
	/**
	 * create edition
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
	 * get edition List
	 * @return
	 */
	public List<Edition> getEditionList(){
		return editionDAO.selectEditionList();
	}
	
	/**
	 * select edition by editionId
	 * @param editionId
	 * @return
	 */
	public Edition getEdition(int editionId) {
		return editionDAO.selectEdition(editionId);
	}
	
	/**
	 * update edition
	 * @param editionId
	 * @param userId
	 * @param userLoginId
	 * @param file
	 * @param subject
	 * @param category
	 * @param publishingDate
	 * @param content
	 */
	public void updateEdition(int editionId,int userId, String userLoginId, MultipartFile file, String subject, String category,int publishingDate, String content) {
		
		// edition 유무 검증
		Edition edition = getEdition(editionId);
		if (edition == null) {
			logger.error("[글 수정] edition is null. editionId:{}", editionId); 
			return;
		}
		
		// file이 있으면 업로드 후 thumbnailPath를 얻어와야한다.
		String thumbnailPath = null;
		if(file != null) {
			try {
				thumbnailPath = fileManagerService.saveFile(userLoginId, file);
				
				// 기존에 있던 파일 제거 -> thumbnailPath가 존재 && 기존에 파일이 있을 시
				if(thumbnailPath != null && edition.getThumbnailPath() != null) {
					// 업로드가 실패할 수 있으므로, 업로드 성공 후 제거
					fileManagerService.deleteFile(edition.getThumbnailPath());
				}
			} catch (IOException e) {
				
			}
		}
		
		editionDAO.updateEdition(editionId, userId, userLoginId, thumbnailPath, subject, category, publishingDate, content);
		
	}
	
	// delete edition
}	