package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Student;

public class StudentDAO {

	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public Connection connection() throws Exception {

		if (ds == null) {
			ds = (DataSource) (new InitialContext()).lookup("java:comp/enc/jsbc/MySQL");
		}
		return con;

	}

	public void close() throws Exception {

		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

	public Student getStudent(int stu_id, String password) {

		Student student = new Student();

		try{

			connection();
			String sql ="SELECT stu_id , stu_password FROM student WEHRE stu_id = ? AND stu_password = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, stu_id);
			stmt.setString(2, password);

			rs.next();
			student.setStu_id(stu_id);
			student.setStu_password(password);

		}catch(Exception e){
			student = null;
		}finally{
			try{
				close();
			}catch(Exception e){

			}
		}
		return student;
	}

}
