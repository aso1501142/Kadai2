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
		con = (Connection) ds.getConnection();
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

		System.out.println(teacherId);
		System.out.println(password);

		Teacher teacher = new Teacher();

		try{

			connection();
			String sql ="SELECT tea_id FROM teacher WHERE tea_id = ? AND tea_password = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, teacherId);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			rs.next();
			teacher.setTeacherId(rs.getInt("tea_id"));

		}catch(Exception e){
			System.out.println(e);
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
