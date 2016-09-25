package com.dat.bbs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dat.bbs.biz.BbsBiz;
import com.dat.bbs.biz.BbsBizImpl;
import com.dat.bbs.vo.BbsVO;

public class AddBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BbsBiz biz;
	
    public AddBbsServlet() {
        super();
        biz = new BbsBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String createrName = request.getParameter("createrName");
		
		content = content.replaceAll("\n", "<br/>")
				         .replaceAll("\r", "");
		
		BbsVO bbsVO = new BbsVO();
		bbsVO.setTitle(title);
		bbsVO.setContent(content);
		bbsVO.setCreaterName(createrName);
		
		biz.addWriting(bbsVO);
		
		response.sendRedirect("/BbsMVC/bbsList");
	}

}
