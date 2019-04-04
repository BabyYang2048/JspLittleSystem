package service;

import dao.*;
import domain.*;


public class UserService {

	private UserDao userDao = new UserDao();
	private QuestionDao questionDao = new QuestionDao();

	/**
	 * 提供登录服务
	 * */
	public User loginUser(String username,String password,String type){
		return userDao.match(username, password, type);
	}
	
	/**
	 * 提供注册服务
	 * */
	public User registerUser(String un,String pw,String type, String classno, String schoolno){
		return userDao.add(un, pw, type,classno,schoolno);
	}
	
	/**
	 * 提供删除用户服务
	 * */
	public User deleteUser(String message){
		return userDao.deleteUser(message);
	}
	
	/**
	 * 提供管理员重置密码服务
	 * */
	public boolean resetPassword(String message) {
		return userDao.resetPassword(message);
	}
	/**
	 * 提供老师增加题目服务
	 * */
	public Question addQuestion(String title, String optionA, String optionB, 
			String optionC, String optionD, String trueAnswer, String type){
		return questionDao.add(title, optionA, optionB, optionC, optionD, trueAnswer, type);
	} 
	/**
	 * 提供老师删除题目服务
	 * */
	public Question deleteQuestion(String title){
		return questionDao.deleteQuestion(title);
	}

	public Question deleteQuestion2(String id) {
		return questionDao.deleteQuestion2(id);
	}
	/**
	 * 提供根据用户schoolno查找用户服务
	 * */
	public User findUser(String schoolno){
		return userDao.finduser(schoolno);
	}
	
	
}
