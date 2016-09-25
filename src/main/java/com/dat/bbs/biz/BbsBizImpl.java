package com.dat.bbs.biz;

import java.util.List;

import com.dat.bbs.dao.BbsDao;
import com.dat.bbs.dao.BbsDaoImpl;
import com.dat.bbs.vo.BbsVO;

public class BbsBizImpl implements BbsBiz{

	private BbsDao bbsDao;
	
	public BbsBizImpl() {
		bbsDao = new BbsDaoImpl();		
	}
	
	@Override
	public boolean addWriting(BbsVO bbsVO) {
		return bbsDao.addWriting(bbsVO);
	}

	@Override
	public List<BbsVO> getWriting() {
		return bbsDao.getWriting();
	}

	@Override
	public BbsVO getWritingAt(int bbsId) {
		bbsDao.updateHitCount(bbsId);
		return bbsDao.getWritingAt(bbsId);
	}

	@Override
	public boolean deleteWriting(int bbsId) {
		bbsDao.deleteWriting(bbsId);
		return true;
	}

	@Override
	public boolean updateRecommendCount(int bbsId) {
		bbsDao.updateHitCount(bbsId);
		return true;
	}


}
