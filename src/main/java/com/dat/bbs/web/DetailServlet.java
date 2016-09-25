package com.dat.bbs.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dat.bbs.biz.BbsBiz;
import com.dat.bbs.biz.BbsBizImpl;
import com.dat.bbs.vo.BbsVO;

public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BbsBiz biz;
	
    public DetailServlet() {
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
		
		BbsVO bbs = biz.getWritingAt(bbsId);
		
		String viewPath = "WEB-INF/view/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("BbsVO", bbs);
		rd.forward(request, response);
	}

}
