package com.dat.bbs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dat.bbs.biz.BbsBiz;
import com.dat.bbs.biz.BbsBizImpl;

public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BbsBiz biz;
	
    public RecommendServlet() {
        super();
        biz = new BbsBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bbsIdParam = request.getParameter("bbsId");
		if(bbsIdParam == null) {
			bbsIdParam = "0";
		}
		int bbsId = Integer.parseInt(bbsIdParam);
		
		biz.updateRecommendCount(bbsId);
		
		response.sendRedirect("/BBS/bbsList");
	}

}
