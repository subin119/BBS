package com.dat.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dat.bbs.vo.BbsVO;

public class BbsDaoImpl implements BbsDao{

	@Override
	public boolean addWriting(BbsVO bbsVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBS","BBS");
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO BBS ( ");
			query.append("       	 BBS_ID ");
			query.append("       	 , TITLE ");
			query.append("       	 , CONT ");
			query.append("       	 , HIT_CNT ");
			query.append("       	 , RCND_CNT ");
			query.append("       	 , CRTR_NM ");
			query.append("       	 , CRT_DT ) ");
			query.append("VALUES	( BBS_ID_SEQ.NEXTVAL, ?, ?, 0, 0, ?, SYSDATE ) ");
			
			pstmt = conn.prepareStatement(query.toString());
			
			pstmt.setString(1, bbsVO.getTitle());
			pstmt.setString(2, bbsVO.getContent());
			pstmt.setString(3, bbsVO.getCreaterName());
			
			int insertCount = pstmt.executeUpdate();	
			
			return insertCount > 0 ;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	@Override
	public List<BbsVO> getWriting() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBS","BBS");
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	BBS_ID ");
			query.append("			, TITLE ");
			query.append("			, CONT ");
			query.append("			, HIT_CNT ");
			query.append("			, RCND_CNT ");
			query.append("			, CRTR_NM ");
			query.append("			, TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
			query.append(" FROM		BBS ");
			query.append(" ORDER	BY    BBS_ID DESC ");
			
			pstmt = conn.prepareStatement(query.toString());
			
			rs = pstmt.executeQuery();
			
			List<BbsVO> bbses = new ArrayList<BbsVO>();
			
			BbsVO bbsVO = null;
			
			while(rs.next()) {
				
				bbsVO = new BbsVO();
				bbsVO.setBbsId(rs.getInt("BBS_ID"));
				bbsVO.setTitle(rs.getString("TITLE"));
				bbsVO.setContent(rs.getString("CONT"));
				bbsVO.setHitCount(rs.getInt("HIT_CNT"));
				bbsVO.setRecommendCount(rs.getInt("RCND_CNT"));
				bbsVO.setCreaterName(rs.getString("CRTR_NM"));
				bbsVO.setCreatedDate(rs.getString("CRT_DT"));
				
				bbses.add(bbsVO);
			}
			return bbses;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public BbsVO getWritingAt(int bbsId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	BBS_ID ");
			query.append("			, TITLE ");
			query.append("			, CONT ");
			query.append("			, HIT_CNT ");
			query.append("			, RCND_CNT ");
			query.append("			, CRTR_NM ");
			query.append("			, TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT ");
			query.append(" FROM		BBS ");
			query.append(" WHERE	BBS_ID = ? ");

			pstmt = conn.prepareStatement(query.toString());
			
			pstmt.setInt(1, bbsId);
			rs = pstmt.executeQuery();

			BbsVO bbsVO = null;
			
			while(rs.next()) {
				
				bbsVO = new BbsVO();
				bbsVO.setBbsId(rs.getInt("BBS_ID"));
				bbsVO.setTitle(rs.getString("TITLE"));
				bbsVO.setContent(rs.getString("CONT"));
				bbsVO.setHitCount(rs.getInt("HIT_CNT"));
				bbsVO.setRecommendCount(rs.getInt("RCND_CNT"));
				bbsVO.setCreaterName(rs.getString("CRTR_NM"));
				bbsVO.setCreatedDate(rs.getString("CRT_DT"));
			}
			return bbsVO;	
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		finally {
			// rs.pstmt,conn 을 순서대로 닫는다.
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void deleteWriting(int bbsId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS");
			StringBuffer query = new StringBuffer();
			query.append(" DELETE	     ");
			query.append(" FROM		BBS ");
			query.append(" WHERE	BBS_ID = ? ");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, bbsId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void updateHitCount(int bbsId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS");

			StringBuffer query = new StringBuffer();
			query.append(" UPDATE	BBS ");
			query.append(" SET      HIT_CNT = HIT_CNT + 1 ");
			query.append(" WHERE	BBS_ID = ? ");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, bbsId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}

	@Override
	public void updateRecommendCount(int bbsId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS");

			StringBuffer query = new StringBuffer();
			query.append(" UPDATE	BBS ");
			query.append(" SET      RCND_CNT = RCND_CNT + 1 ");
			query.append(" WHERE	BBS_ID = ? ");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, bbsId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
