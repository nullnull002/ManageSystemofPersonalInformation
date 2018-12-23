package yang.bean;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import com.mysql.jdbc.Statement;

@SuppressWarnings("unchecked")
public class UserInfoDaoImpl implements UserInfoDao{

	private static Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final int planNum = 30;
	private static final String url = "jdbc:mysql://localhost:3306/info?useUnicode=true&characterEncoding=utf8";
	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			try {
				conn = DriverManager.getConnection(url,"root","123456");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	private void release(ResultSet rs, PreparedStatement pstmt) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public boolean select(UserInfoBean userInfo,HttpServletRequest request) {//登陆
		//TODO  登陆
		// 声明返回值变量
		boolean flag = false;
		// 声明sql语句
		String sql = "select * from userinfo where loginName=? and password=?";
		try {
			// 创建
			pstmt = conn.prepareStatement(sql);
			// 为占位符赋值
			int index = 1;
			pstmt.setObject(index++, userInfo.getLoginName());
			pstmt.setObject(index++, userInfo.getPassword());
			// 执行更新
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setUserSex(rs.getString("userSex"));
				userInfo.setUserBirthday(rs.getString("userBirthday"));
				userInfo.setUserTelephone(rs.getString("userTelephone"));
				userInfo.setUserNation(rs.getString("userNation"));
				userInfo.setUserEmail(rs.getString("userEmail"));
				userInfo.setUserAddress(rs.getString("userAddress"));
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", userInfo);
				ArrayList<Integer> list = new ArrayList<>();
				String sq2="select * from userschedule where loginName='"+userInfo.getLoginName()+"'";
				pstmt = conn.prepareStatement(sq2);
				rs=pstmt.executeQuery();
				UserPlanBean[] userPlan = new UserPlanBean[30];
				index = 0;
				if(rs != null){
				while(rs.next()){
					String s2 = rs.getString("date");
					String s3 = rs.getString("plan");
					System.out.println(s2+"  "+s3);
					userPlan[index] = new UserPlanBean();//记得先建立对象
					userPlan[index].setDate(s2);
					userPlan[index].setPlan(s3);
					list.add(Integer.parseInt(rs.getString("id")));
					index++;
					}
				}
				session.setAttribute("userPlan", userPlan);
				session.setAttribute("index", index);
				session.setAttribute("list",list);
			}
			release(rs, pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, pstmt);
		// 修改返回值变量
		return flag;
	}


	@Override
	public boolean modifyInfo(UserInfoBean userInfo) {
		//TODO 修改个人信息 
		boolean flag = false;
		String sql2="update userinfo set userName='"+userInfo.getUserName()+"',userSex='"+userInfo.getUserSex()+"',userBirthday='"
				 +userInfo.getUserBirthday()+"', userNation='"+ userInfo.getUserNation()
		 +"',userTelephone='"+userInfo.getUserTelephone()+"', userEmail='"+ userInfo.getUserEmail()
		+"',userAddress='"+userInfo.getUserAddress()+"' where loginName='"+userInfo.getLoginName()+"'";
		try {
			pstmt = conn.prepareStatement(sql2);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
				System.out.println("修改成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, pstmt);
		return flag;

	}


	@Override
	public boolean modifyPass(UserInfoBean userInfo) {
		//TODO 修改登陆密码
		boolean flag = false;
		String sql="update   userinfo  set password='"+userInfo.getPassword()+"'where loginName='"+userInfo.getLoginName()+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
				System.out.println("修改成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, pstmt);
		return flag;
	}

	@Override
	public boolean insert(UserInfoBean userInfo) {
		// TODO 注册账号
		boolean flag = false;
		Statement st=null;
		String sql = "insert into userinfo(userName,userSex,userBirthday,userNation,loginName,password,userTelephone,userEmail,userAddress) values(?,?,?,?,?,?,?,?,?)";
		String sql2="select * from userinfo where loginName='"+userInfo.getLoginName()+"'";
		try {
				st = (Statement) conn.createStatement();
				rs=st.executeQuery(sql2);
				if(rs.next()) {
					String msg="该用户名已存在，请重新输入！";
					int type=JOptionPane.YES_NO_OPTION;
					String title="信息提示";
					JOptionPane.showMessageDialog(null,msg,title,type);return flag;} 
				else{
			pstmt = conn.prepareStatement(sql);
			int index = 1;
			pstmt.setObject(index++, userInfo.getUserName());
			pstmt.setObject(index++, userInfo.getUserSex());
			pstmt.setObject(index++, userInfo.getUserBirthday());
			pstmt.setObject(index++, userInfo.getUserNation());
			pstmt.setObject(index++, userInfo.getLoginName());
			pstmt.setObject(index++, userInfo.getPassword());
			pstmt.setObject(index++, userInfo.getUserTelephone());
			pstmt.setObject(index++, userInfo.getUserEmail());
			pstmt.setObject(index++, userInfo.getUserAddress());
			
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
				System.out.println("插入成功");
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, pstmt);
		return flag;
	}
	
	@Override
	public boolean findPass(UserInfoBean userInfo) {
		//TODO 找回密码
		boolean flag = false;
		String s1 = userInfo.getLoginName();
		String s2 = userInfo.getUserEmail();
		String sql="select password from userinfo where loginName='"+s1+"'and userEmail='"+s2+"'";
		try{pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			if(rs.next())
			{
			userInfo.setPassword(rs.getString("password"));
			flag=true;}
		release(rs, pstmt);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	release(rs, pstmt);
	return flag;
	}
	
	@Override
	public void modifyPlan(UserInfoBean userInfo, UserPlanBean[] userPlan, HttpServletRequest request,int index) {
		// TODO 修改日程
		String s1 = userInfo.getLoginName();
		HttpSession session = request.getSession();
		ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("list");
		boolean flag = false;
		for (int i = 0; i < index; i++) {
			String sql="update   userSchedule  set date='"+userPlan[i].getDate()+"',plan='"+userPlan[i].getPlan()+"'where loginName='"+s1+"'and id='"+list.get(i)+"'";
			try {
				pstmt = conn.prepareStatement(sql);
				int j = pstmt.executeUpdate();
				if(j > 0){
					flag = true;
					System.out.println(flag);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		release(rs, pstmt);
	}
	@Override
	public boolean addPlan(UserInfoBean userInfo, UserPlanBean addP, HttpServletRequest request, int index) {
		// TODO 增加日程
		boolean flag = false;
		String sql = "insert into userSchedule(date,plan,loginName)values('"+addP.getDate()+"','"+addP.getPlan()+"','"+userInfo.getLoginName()+"')";
		HttpSession session = request.getSession();
		ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("list");
		UserPlanBean[]userPlan = (UserPlanBean[])session.getAttribute("userPlan");
		int j = 0;
		for(int i = 0; i < index; i++){
			if(addP.getDate().equals(userPlan[i].getDate())){
				j = 1;
				String msg="该日期已存在，可以修改该日期的日程安排！";
				int type=JOptionPane.YES_NO_OPTION;
				String title="信息提示";
				JOptionPane.showMessageDialog(null,msg,title,type);
				break;
			}
		}
		if(j == 1){}
		else{
			try {
				Statement st = (Statement)conn.createStatement();  
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					flag = true;
					list.add(rs.getInt(1));
					userPlan[index] = new UserPlanBean();
					userPlan[index].setDate(addP.getDate());
					userPlan[index].setPlan(addP.getPlan());
					session.setAttribute("userPlan", userPlan);
					session.setAttribute("index", (index+1));
					System.out.println(userPlan[index].getDate());
					System.out.println("插入成功");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return flag;
	}
	
	@Override
	public void deletePlan(UserInfoBean userInfo, UserPlanBean deletePlan, HttpServletRequest request,
			int index,int dIndex) {
		//TODO 删除日程
		HttpSession session = request.getSession();
		ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("list");
		String sql="delete from userschedule where id='"+(list.get(dIndex))+"'";
		UserPlanBean[]userPlan = (UserPlanBean[])session.getAttribute("userPlan");
		try {
			pstmt = conn.prepareStatement(sql);
			int j =  pstmt.executeUpdate();
			if(j > 0){
				list.remove(dIndex);
				session.setAttribute("index", index-1);
				userPlan[dIndex] = null;
				UserPlanBean[]newPlan = new UserPlanBean[planNum];
				j = 0;
				for(int i = 0; i < index; i++){
					if(userPlan[i] != null){
						newPlan[j++] = userPlan[i];
					}
				}
				session.setAttribute("userPlan", newPlan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, pstmt);
	}
}
