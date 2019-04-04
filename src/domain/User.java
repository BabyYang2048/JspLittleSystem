package domain;

/*
 *用户实体类
 *关于type的说明： 0-管理员 1-教师 2-学生 
 */

public class User {
	public int id;
	public String username;
	public String password;
	public String type;
	public String schoolno;
	public String classno;
	
	public User(){
		
	}
	public User(int id,String username,String password,String type,String schoolno,String classno){
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.classno = classno;
		this.schoolno = schoolno;
	}
	public String getSchoolno() {
		return schoolno;
	}
	public void setSchoolno(String schoolno) {
		this.schoolno = schoolno;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}

