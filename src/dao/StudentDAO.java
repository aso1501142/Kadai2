package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Seminar;
import model.Student;

public class StudentDAO {

	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public Connection connection() throws Exception {

		if (ds == null) {
			ds = (DataSource)(new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		con = (Connection) ds.getConnection();
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
			rs = stmt.executeQuery();

			rs.next();
			student.setStu_id(stu_id);

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


	public ArrayList<Student> getStudent(ArrayList<Seminar> list) {

		ArrayList<Student> student = new ArrayList<Student>();


		try {
			// DB接続

			connection();

			for(int i = 0; i < list.size(); i++){

			String sql = "SELECT stu_name FROM student WHERE stu_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,list.get(i).getStu_id());

			rs = stmt.executeQuery();
			rs.next();
			    Student stu = new Student();
				stu.setStu_name(rs.getString("stu_name"));
				student.add(stu);
			}

		} catch (Exception e) {

		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return student;
	}

}
