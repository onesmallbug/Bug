package com.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.*;

@WebServlet(name = "/MemberServlet", loadOnStartup = 1000, urlPatterns = "/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 8444049065177790665L;

	private MemberDAO memberDAO = null;
	private List<MemberVO> list = null;
	private List<String> accountList = null;
	private List<String> nameList = null;

	@Override
	public void init() throws ServletException {
		memberDAO = new MemberDAOImpl();
		list = new ArrayList<MemberVO>();
		accountList = new ArrayList<String>();
		nameList = new ArrayList<String>();
		getServletContext().setAttribute("memberList", list);
		getServletContext().setAttribute("memberAccountList", accountList);
		getServletContext().setAttribute("memberNameList", nameList);
		fresh();
	}

	private void fresh() {
		
		list.clear();
		accountList.clear();
		nameList.clear();
		
		for (MemberVO memberVO : memberDAO.getAll()) {
			list.add(memberVO);
			accountList.add(memberVO.getMember_account());
			nameList.add(memberVO.getMember_name());
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("BIG5");
		res.setContentType("text/html; charset=Big5");

		HttpSession session = req.getSession();
		session.invalidate();
		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return;

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("BIG5");
		res.setContentType("text/html; charset=Big5");

		HttpSession session = req.getSession();

		String action = req.getParameter("action");
		String errorMessage = null;

		/*-------------------------new Start-------------------------*/
		if ("new".equals(action)) {

			String regex = "[a-z,A-Z,\\d]{4,8}";
			String member_account = req.getParameter("member_account");
			String password1 = req.getParameter("password1");
			String password2 = req.getParameter("password2");
			String member_name = req.getParameter("member_name");

			if (accountList.contains(member_account)) {
				errorMessage = "帳號已存在，請重新輸入";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("password1", password1);
				req.setAttribute("password2", password2);
				req.setAttribute("member_name", member_name);
				req.getRequestDispatcher("/Register.jsp").forward(req, res);
				return;
			}

			if (nameList.contains(member_name)) {
				errorMessage = "名稱已存在，請重新輸入";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("member_account", member_account);
				req.setAttribute("password1", password1);
				req.setAttribute("password2", password2);
				req.getRequestDispatcher("/Register.jsp").forward(req, res);
				return;
			}

			if (!member_account.matches(regex)) {
				errorMessage = "帳號格式錯誤，請重新檢查";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("password1", password1);
				req.setAttribute("password2", password2);
				req.setAttribute("member_name", member_name);
				req.getRequestDispatcher("/Register.jsp").forward(req, res);
				return;
			}
			if (!password1.equals(password2)) {
				errorMessage = "密碼輸入錯誤，請重新檢查";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("member_account", member_account);
				req.setAttribute("member_name", member_name);
				req.getRequestDispatcher("/Register.jsp").forward(req, res);
				return;
			}
			if (!password1.matches(regex)) {
				errorMessage = "密碼格式錯誤，請重新檢查";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("member_account", member_account);
				req.setAttribute("member_name", member_name);
				req.getRequestDispatcher("/Register.jsp").forward(req, res);
				return;
			}

			if (member_name.length()>20) {
				errorMessage = "名稱長度過長，請重新輸入20個字以內的名稱";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("member_account", member_account);
				req.setAttribute("password1", password1);
				req.setAttribute("password2", password2);
				req.getRequestDispatcher("/Register.jsp").forward(req, res);
				return;
			}
			
			MemberVO memberVO = new MemberVO();

			memberVO.setMember_account(member_account);
			memberVO.setMember_password(password1);
			memberVO.setMember_name(member_name);

			memberDAO.insert(memberVO);
			fresh();

			session.setAttribute("member_account", member_account);
			session.setAttribute("member_name", member_name);

		}
		/*-------------------------new End-------------------------*/
		/*-------------------------SignIn Start-------------------------*/
		if ("signin".equals(action)) {
			String regex = "[a-z,A-Z,\\d]{4,8}";
			String member_account = req.getParameter("member_account").trim();
			String member_password = req.getParameter("member_password").trim();
			
			if (!member_account.matches(regex) || !member_password.matches(regex)) {
				errorMessage = "格式錯誤，請重新檢查格式";
				req.setAttribute("errorMessage", errorMessage);
				req.getRequestDispatcher("/SignIn.jsp").forward(req, res);
				return;
			}
			
			if (!accountList.contains(member_account)) {
				errorMessage = "帳號不存在，請重新輸入";
				req.setAttribute("errorMessage", errorMessage);
				req.getRequestDispatcher("/SignIn.jsp").forward(req, res);
				return;
			}
			
			MemberVO memberVO = new MemberVO();

			memberVO.setMember_account(member_account);
			memberVO.setMember_password(member_password);			
			
			if (!list.contains(memberVO)) {
				errorMessage = "密碼輸入錯誤，請重新輸入";
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("member_account", member_account);
				req.getRequestDispatcher("/SignIn.jsp").forward(req, res);
				return;
			}
			
			int index = list.lastIndexOf(memberVO);
			String member_name = list.get(index).getMember_name();
			session.setAttribute("member_account", member_account);
			session.setAttribute("member_name", member_name);			
			
		}
		/*-------------------------SignIn End-------------------------*/

		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return;

	}

}
