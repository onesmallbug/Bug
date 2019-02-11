package com.menu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.menu.model.*;
import com.store.model.*;

@WebServlet(name = "/MenuServlet", loadOnStartup = 2, urlPatterns = "/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 2387089088872043982L;

	private MenuDAO menuDAO = null;
	private List<MenuVO> list = null;
	private Map<Integer, List<MenuVO>> map = null;
	private List<StoreVO> storeList = null;
	private int storeListSize;

	@Override
	public void init() throws ServletException {
		menuDAO = new MenuDAOImpl();
		list = new ArrayList<MenuVO>();
		map = new HashMap<Integer, List<MenuVO>>();
		fresh();
	}

	public void fresh() {
		
		list.clear();
		for (MenuVO menuVO : menuDAO.getAll()) {
			list.add(menuVO);
		}
		
		storeList = (List<StoreVO>) getServletContext().getAttribute("storeList");
		storeListSize = storeList.size();
		for (StoreVO storeVO : storeList) {

			Integer integer = storeVO.getStore_no();
			ArrayList<MenuVO> menulist = new ArrayList<MenuVO>();

			for (MenuVO menuVO : list) {
				if (menuVO.getStore_no() == integer) {
					menulist.add(menuVO);
				}
			}
			map.put(integer, menulist);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("BIG5");
		res.setContentType("text/html; charset=Big5");

		HttpSession session = req.getSession();

		String action = req.getParameter("action");
		String errorMessage = null;
		
		if(storeListSize!=storeList.size()) {
			fresh();
		}
		
		/*-------------------------readMenu Start-------------------------*/
		if ("readMenu".equals(action)) {

			Integer theMenuS = Integer.parseInt(req.getParameter("store_no"));
			req.setAttribute("theMenuS", map.get(theMenuS));
			req.getRequestDispatcher("/readStore.jsp").forward(req, res);
			return;

		}
		/*-------------------------readMenu End-------------------------*/
		/*-------------------------managemenu Start-------------------------*/
		if ("managemenu".equals(action)) {

			String member_account = (String) session.getAttribute("member_account");

			if (member_account == null) {
				errorMessage = "新增菜單前，請先登入";
				req.setAttribute("errorMessage", errorMessage);
				req.getRequestDispatcher("/SignIn.jsp").forward(req, res);
				return;
			}

			Integer store_no = Integer.parseInt(req.getParameter("store_no"));
			req.setAttribute("store_no", store_no);
			req.getRequestDispatcher("/SelectStoreToManageMenu.jsp").forward(req, res);
			return;

		}

		/*-------------------------managemenu End-------------------------*/
		/*-------------------------newmenu Start-------------------------*/
		if ("newmenu".equals(action)) {

			String member_account = (String) session.getAttribute("member_account");

			if (member_account == null) {
				errorMessage = "新增菜單前，請先登入";
				req.setAttribute("errorMessage", errorMessage);
				req.getRequestDispatcher("/SignIn.jsp").forward(req, res);
				return;
			}
			
			Integer store_no = Integer.parseInt(req.getParameter("store_no"));
			String menu_name = req.getParameter("menu_name");
			String menu_price = req.getParameter("menu_price");
			String regex = "[0-9]{2,3}";
			
			if (menu_name==null||menu_price==null||menu_name.trim().isEmpty()) {
				errorMessage = "請輸入完整資料";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("store_no", store_no);
				
				if(!(menu_name==null)) {
					menu_name = menu_name.trim();
				}
				
				req.setAttribute("menu_name", menu_name);
				req.setAttribute("menu_price", menu_price);
				req.getRequestDispatcher("/SelectStoreToManageMenu.jsp").forward(req, res);
				return;
			}	
			
			if (!menu_price.matches(regex)) {
				errorMessage = "價格輸入格式錯誤";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("store_no", store_no);
				req.setAttribute("menu_name", menu_name);
				req.setAttribute("menu_price", menu_price);
				req.getRequestDispatcher("/SelectStoreToManageMenu.jsp").forward(req, res);
				return;
			}
			
			MenuVO menuVO = new MenuVO();
			menuVO.setStore_no(store_no);
			menuVO.setMenu_name(menu_name);
			menuVO.setMenu_price(Integer.parseInt(menu_price));
			
			menuDAO.insert(menuVO);
			
			fresh();
			errorMessage = "新增菜色"+menu_name+"價格"+menu_price+"成功";
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("store_no", store_no);
			
			req.getRequestDispatcher("/SelectStoreToManageMenu.jsp").forward(req, res);
			return;

		}
		/*-------------------------newmenu End-------------------------*/
		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return;
	}

}
