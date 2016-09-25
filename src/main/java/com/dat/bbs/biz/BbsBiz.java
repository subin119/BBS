package com.dat.bbs.biz;

import java.util.List;

import com.dat.bbs.vo.BbsVO;

public interface BbsBiz {
	
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
	 * 추천수 증가
	 * @param bbsId
	 */
	public boolean updateRecommendCount(int bbsId);
	
	/**
	 * 글 삭제
	 * @param bbsId
	 * @return 
	 */
	public boolean deleteWriting(int bbsId);

}
