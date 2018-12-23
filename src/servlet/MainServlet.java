package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yang.bean.UserInfoBean;
import yang.bean.UserInfoDaoImpl;
import yang.bean.UserPlanBean;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoDaoImpl uDao = new UserInfoDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO doGet
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("methodName");
		if (method.equals("0")) {//登陆
			// TODO 登陆
			if(select(request, response)){
			request.getRequestDispatcher("manage.jsp").forward(request,
					response);
			}
			else {
				request.getRequestDispatcher("loginError.jsp").forward(request,
						response);
				}
		} else if (method.equals("1")) {//注册
			// TODO 注册
			try {
				if(insert(request, response)){
				request.getRequestDispatcher("registerSuccess.jsp").forward(request,
						response);
				}
				else{
					request.getRequestDispatcher("register.jsp").forward(request,
							response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(method.equals("2")){//更改个人信息
			// TODO 更改个人信息
			try {
				if(modifyInfo(request, response)){
					request.getRequestDispatcher("modifyInfoSuccess.jsp").forward(request,
							response);
				}else{
					request.getRequestDispatcher("modifyInfoError.jsp").forward(request,
							response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(method.equals("3")){//更改登陆密码
			// TODO 更改登陆密码
				if(modifyPass(request, response)){
					request.getRequestDispatcher("modifyPassSuccess.jsp").forward(request,
							response);
				}else{
					request.getRequestDispatcher("modifyPassError.jsp").forward(request,
							response);
				}
		}else if(method.equals("4")){//找回密码
			// TODO 找回密码
			if(findPass(request, response)){
				request.getRequestDispatcher("findPassSuccess.jsp").forward(request,
						response);
			}else{
				request.getRequestDispatcher("findPassError.jsp").forward(request,
						response);
			}
		}else if(method.equals("5")){//修改日程
			// TODO 修改日程
			modifyPlan(request, response);
			request.getRequestDispatcher("modifyScheduleSuccess.jsp").forward(request,
					response);
		}else if(method.equals("6")){//增加日程
			// TODO 增加日程
			if(AddPlan(request, response)){
			request.getRequestDispatcher("AddScheduleSuccess.jsp").forward(request,
					response);}
			else{
				request.getRequestDispatcher("AddScheduleError.jsp").forward(request,
						response);}
			}else if(method.equals("7")){//删除日程
				// TODO 删除日程
				deletePlan(request, response);
				request.getRequestDispatcher("deleteScheduleSuccess.jsp").forward(request,
						response);
			}else {
			System.out.println("！！！出错啦！！！");
		}
 
	}
	

	public boolean select(HttpServletRequest request, HttpServletResponse response) {
		// TODO 登陆
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setLoginName(loginName);
		userInfo.setPassword(password);
		boolean flag = uDao.select(userInfo,request);
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("loginName", loginName);
			System.out.println("登录成功");
			return flag;
		} else {
			System.out.println("登录失败");
			return flag;
		}
	}
 
	public boolean insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO 注册
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		String userBirthday = request.getParameter("userBirthday");
		String userNation = request.getParameter("userNation");
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String userTelephone = request.getParameter("userTelephone");
		String userEmail = request.getParameter("userEmail");
		String userAddress = request.getParameter("userAddress");
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setUserName(userName);
		userInfo.setUserSex(userSex);
		userInfo.setUserBirthday(userBirthday);
		userInfo.setUserNation(userNation);
		userInfo.setLoginName(loginName);
		userInfo.setPassword(password);
		userInfo.setUserTelephone(userTelephone);
		userInfo.setUserEmail(userEmail);
		userInfo.setUserAddress(userAddress);
		
		boolean flag = uDao.insert(userInfo);
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败,请重新注册！");
		}
		return flag;
	}

	public boolean modifyInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO 修改个人信息
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		String userBirthday = request.getParameter("userBirthday");
		String userNation = request.getParameter("userNation");
		String userTelephone = request.getParameter("userTelephone");
		String userEmail = request.getParameter("userEmail");
		String userAddress = request.getParameter("userAddress");
		HttpSession session = request.getSession();
		UserInfoBean userInfo =(UserInfoBean) session.getAttribute("userInfo");
		userInfo.setUserName(userName);
		userInfo.setUserSex(userSex);
		userInfo.setUserBirthday(userBirthday);
		userInfo.setUserNation(userNation);
		userInfo.setUserTelephone(userTelephone);
		userInfo.setUserEmail(userEmail);
		userInfo.setUserAddress(userAddress);
		System.out.println(userInfo.getLoginName());
		boolean flag = uDao.modifyInfo(userInfo);
		if (flag) {
			session.setAttribute("userInfo", userInfo);
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败,请重新修改！");
		}
		return flag;
	}
	
	public boolean modifyPass(HttpServletRequest request, HttpServletResponse response) {
		// TODO 修改登陆密码
		HttpSession session = request.getSession();
		UserInfoBean userInfo =(UserInfoBean) session.getAttribute("userInfo");
		userInfo.setPassword((String)request.getParameter("password"));
		boolean flag = uDao.modifyPass(userInfo);
		if (flag) {
			session.setAttribute("userInfo", userInfo);
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败,请重新修改！");
		}
		return flag;
	}
	
	public boolean findPass(HttpServletRequest request, HttpServletResponse response) {
		// TODO 通过用户名与邮箱账号找回密码
		String loginName =(String) request.getParameter("loginName");
		String userEmail =(String) request.getParameter("userEmail");
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setLoginName(loginName);
		userInfo.setUserEmail(userEmail);
		//System.out.println(loginName+userEmail);
		boolean flag = uDao.findPass(userInfo);
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
			System.out.println("找回成功");
		} else {
			System.out.println("找回失败");
		}
		return flag;
	}
	
	public void modifyPlan(HttpServletRequest request, HttpServletResponse response) {
		// TODO 修改日程
		HttpSession session = request.getSession();
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("userInfo");
		UserPlanBean[] userPlan = (UserPlanBean[])session.getAttribute("userPlan");
		for(int i = 0; i < (Integer)session.getAttribute("index"); i++ ){
			userPlan[i].setDate(request.getParameter("date"+i));
			userPlan[i].setPlan(request.getParameter("plan"+i));
		}
		uDao.modifyPlan(userInfo,userPlan,request,(Integer)session.getAttribute("index"));
		session.setAttribute("userPlan", userPlan);
	}
	
	public boolean AddPlan(HttpServletRequest request, HttpServletResponse response) {
		// TODO 增加日程
		HttpSession session = request.getSession();
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("userInfo");
		UserPlanBean addPlan = new UserPlanBean();
		addPlan.setDate(request.getParameter("date"));
		addPlan.setPlan(request.getParameter("plan"));
		boolean flag = uDao.addPlan(userInfo,addPlan,request,(Integer)session.getAttribute("index"));
		return flag;
	}
	
	private void deletePlan(HttpServletRequest request, HttpServletResponse response) {
		// TODO 删除日程
		HttpSession session = request.getSession();
		int dIndex = -1;
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("userInfo");
		UserPlanBean deletePlan = new UserPlanBean();
		dIndex = Integer.parseInt( request.getParameter("delete"));
		System.out.println(dIndex);
		uDao.deletePlan(userInfo,deletePlan,request,(Integer)session.getAttribute("index"),dIndex);
	}
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO doPost
		doGet(request, response);
	}

}
