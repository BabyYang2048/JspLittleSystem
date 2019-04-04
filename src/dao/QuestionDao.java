package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectDataBase;
import domain.Question;

public class QuestionDao {

	/**
	 * @return 数据库中的question对象
	 */	
	
	public List<Question> QList() {
		
		Question question = null;
		List<Question> questionList = new ArrayList<Question>();
		ConnectDataBase cdb = new ConnectDataBase();
		Connection conn = cdb.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from question";
		try{
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				question = new Question();
				question.id = rs.getString("id");
				question.title = rs.getString("title");
				question.optionA = rs.getString("optionA");
				question.optionB = rs.getString("optionB");
				question.optionC = rs.getString("optionC");
				question.optionD = rs.getString("optionD");
				question.type = rs.getString("type");
				question.trueAnswer = rs.getString("trueAnswer");
				questionList.add(question);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)	conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return questionList;
	}
	
	
	/**
	 * 根据用户选择答案和正确答案比对来判分
	 * @param s1 选择的答案
	 * @param s2 正确答案
	 * @return score 分数 
	 */
	
	public int getScore(String s1,String s2){
		int score=0;
		String selection="";
		String trueAnswers="";
		selection = selection + s1;
		trueAnswers = trueAnswers + s2;
		System.out.println("selection="+selection+" trueAnswers="+trueAnswers);
		
		int i = selection.length()-1;  //客户提交的第i题答案在selection中的位置
		int m = trueAnswers.length();
		//System.out.println("i="+i+"  m="+m);
		
		if(i<=m-1){
			try{
				for(int j=i;j>=0;j--){
					if(selection.charAt(j)==trueAnswers.charAt(j)){
						if(selection.charAt(j)!='\''){
							score++;
						}
					}
					//System.out.println("selection.charAt("+j+")="+selection.charAt(j));
					//System.out.println("trueAnswers.charAt("+j+")="+trueAnswers.charAt(j));
				}
			}catch(StringIndexOutOfBoundsException e){
				i=0;
				//System.out.println("i=0后：i="+i+"  m="+m);
			}
		}
		return score;
	}
	
	/**
	 * 教师增加习题 
	 */
	public Question add(String title,String optionA,String optionB,String optionC,String optionD,String trueAnswer,String type){
		Question question = null;
		ConnectDataBase cdb = new ConnectDataBase();
		Connection conn = cdb.getConn();
		PreparedStatement pstmt = null;
		
		
		try {
			conn = cdb.getConn();
			String sql = "insert into question(title,optionA,optionB,optionC,optionD,trueAnswer,type) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,optionA);
			pstmt.setString(3,optionB);
			pstmt.setString(4, optionC);
			pstmt.setString(5, optionD);
			pstmt.setString(6, trueAnswer);
			pstmt.setString(7, type);
			pstmt.executeUpdate();
			
			question = findQuestion(title);
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return question;	
	}
	
	
	/**
	 * 教师删除习题 
	 * 根据title
	 */
	public Question deleteQuestion(String title){
		Question question=null;
		ConnectDataBase cdb = new ConnectDataBase();
		Connection conn = cdb.getConn();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from question where title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.executeUpdate();
			
			question = findQuestion(title);
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return question;
	}

	/**
	 * 教师删除习题 
	 * 根据id
	 */
	public Question deleteQuestion2(String id) {
		Question question=null;
		ConnectDataBase cdb = new ConnectDataBase();
		Connection conn = cdb.getConn();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from question where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
			
			question = findQuestion(id);
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return question;
	}
	
	
	/**
	 * 根据题目查找返回习题
	 * 题库规则存储规则：所有题目不能一样 
	 */
	private Question findQuestion(String title) {
		Question question = null;
		ConnectDataBase cdb = new ConnectDataBase(); 
		Connection conn = cdb.getConn();
		
		//防止sql注入
		String sql ="select * from question where title = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			
			ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				question = new Question();
				question.title = rs.getString("title");		
			}
			
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("这里好像不太对！");
		}
		
		return question ;
	}



	
	

}
