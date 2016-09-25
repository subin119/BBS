package com.dat.bbs.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dat.bbs.biz.BbsBiz;
import com.dat.bbs.biz.BbsBizImpl;
import com.dat.bbs.vo.BbsVO;

public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private BbsBiz biz;

    public BbsServlet() {
        super();
        biz = new BbsBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BbsVO> bbses = biz.getWriting();
		
		String viewPath = "WEB-INF/view/bbsList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("bbses", bbses);
		
		rd.forward(request, response);
	}

}
