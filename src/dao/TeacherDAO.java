package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Teacher;

public class TeacherDAO {

	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public Connection connection() throws Exception{

		if(ds == null){
			ds = (DataSource)(new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		return con;

	}

	public void close() throws Exception{

		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(con != null){
			con.close();
		}
	}

	public Teacher getTeacher(int teacherId, String password){

		Teacher teacher = new Teacher();

		try{

			connection();
			String sql ="SELECT tea_id,tea_password FROM teacher WEHRE tea_id = ? and tea_password = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, teacherId);
			stmt.setString(2, password);

			rs.next();
			teacher.setTeacherId(teacherId);
			teacher.setPassword(password);


		}catch(Exception e){
			teacher = null;
		}finally{
			try{
				close();
			}catch(Exception e){

			}
		}
		return teacher;
	}


}
