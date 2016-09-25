package com.dat.bbs.dao;

import java.util.List;

import com.dat.bbs.vo.BbsVO;

public interface BbsDao {
	
	/**
	 * 글 작성
	 * @param bbsVO
	 */
	public boolean addWriting(BbsVO bbsVO);
	
	/**
	 * 글 가져오기
	 * @return
	 */
	public List<BbsVO> getWriting();
	
	/**
	 * 글 상세조회
	 * @param bbsId
	 * @return
	 */
	public BbsVO getWritingAt(int bbsId);
	
	/**
	 * 글 삭제
	 * @param bbsId
	 */
	public void deleteWriting(int bbsId);
	
	/**
	 * 조회수를 증가
	 * @param bbsId
	 */
	public void updateHitCount(int bbsId);
	
	/**
	 * 추천수를 증가
	 * @param bbsId
	 */
	public void updateRecommendCount(int bbsId);
	

}
