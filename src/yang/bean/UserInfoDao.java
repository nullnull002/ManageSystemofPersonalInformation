package yang.bean;

import javax.servlet.http.HttpServletRequest;

public interface UserInfoDao {
	boolean modifyInfo(UserInfoBean userinfobean);//修改个人信息
	boolean modifyPass(UserInfoBean userinfobean);//修改登陆密码
	boolean insert(UserInfoBean userinfobean);
	boolean select(UserInfoBean userinfobean,HttpServletRequest request);
	boolean findPass(UserInfoBean userinfobean);
	void modifyPlan(UserInfoBean userinfobean,UserPlanBean[] userPlan,HttpServletRequest request,int index);
	boolean addPlan(UserInfoBean userinfobean,UserPlanBean addPlan,HttpServletRequest request,int index);
	void deletePlan(UserInfoBean userinfobean,UserPlanBean deletePlan,HttpServletRequest request,int index,int dIndex);
}
