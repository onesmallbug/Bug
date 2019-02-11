package com.groups.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groups.model.*;

@WebServlet("/GroupsServlet")
public class GroupsServlet extends HttpServlet{
	private static final long serialVersionUID = 4244423014665857601L;
	
	private GroupsDAO groupsDAO;
	private List<GroupsVO> list = null;
	private List<GroupsVO> effectList = null;

	@Override
	public void init() throws ServletException {
		groupsDAO = new GroupsDAOImpl();
		list = new ArrayList<>();
		effectList = new ArrayList<>();
		getServletContext().setAttribute("groupsList", list);
		getServletContext().setAttribute("effectGroupsList", effectList);
		fresh();
	}
	
	private void fresh() {
		
		long effectDate = new GregorianCalendar().getTime().getTime();
		
		list.clear();
		effectList.clear();
		for (GroupsVO groupsVO : groupsDAO.getAll()) {
			
			list.add(groupsVO);
			
			if(groupsVO.getGroups_expire().getTime()>effectDate) {
				effectList.add(groupsVO);				
			}
		}		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		long effectDate = new GregorianCalendar().getTime().getTime();
		effectList.clear();
		for (GroupsVO groupsVO : list) {
			if(groupsVO.getGroups_expire().getTime()>effectDate) {
				effectList.add(groupsVO);				
			}
		}
		
		req.getRequestDispatcher("/readGroups.jsp").forward(req, res);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
