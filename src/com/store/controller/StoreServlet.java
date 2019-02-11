package com.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.model.*;

@WebServlet(name = "/StoreServlet", loadOnStartup = 1, urlPatterns = "/StoreServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = -6296117164972640627L;

	private StoreDAO storeDAO = null;
	public List<StoreVO> list = null;

	@Override
	public void init() throws ServletException {
		storeDAO = new StoreDAOImpl();
		list = new ArrayList<StoreVO>();
		getServletContext().setAttribute("storeList", list);
		fresh();
	}

	private void fresh() {
		
		list.clear();
		
		for (StoreVO storeVO : storeDAO.getAll()) {
			list.add(storeVO);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("BIG5");
		res.setContentType("text/html; charset=Big5");

		HttpSession session = req.getSession();

		String action = req.getParameter("action");
		String errorMessage = null;
		
		if("newStore".equals(action)) {
			
			String member_account = (String)session.getAttribute("member_account");
			
			if(member_account==null) {
				errorMessage = "新增店家前，請先登入";
				req.setAttribute("errorMessage", errorMessage);
				req.getRequestDispatcher("/SignIn.jsp").forward(req, res);
				return;
			}
			
			String regex = "[0-9]{8,10}";
			String store_name = req.getParameter("store_name");
			String store_phone = req.getParameter("store_phone");
			String store_address = req.getParameter("store_address");
			String store_other = req.getParameter("store_other");
			
			if(!store_phone.matches(regex)) {				
				errorMessage = "電話格式錯誤";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("store_name", store_name);
				req.setAttribute("store_phone", store_phone);
				req.setAttribute("store_address", store_address);
				req.setAttribute("store_other", store_other);
				req.getRequestDispatcher("/ManageStore.jsp").forward(req, res);
				return;
			}
			
			StoreVO storeVO = new StoreVO();
			storeVO.setStore_name(store_name);
			storeVO.setStore_phone(store_phone);
			storeVO.setStore_address(store_address);
			storeVO.setStore_other(store_other);
			
			storeDAO.insert(storeVO);
			
			errorMessage = "新增 "+store_name+" 店家成功";
			req.setAttribute("errorMessage", errorMessage);
			req.getRequestDispatcher("/SelectStoreToManageMenu.jsp").forward(req, res);
			fresh();
			return;
			
		}

		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return;
	}

}
