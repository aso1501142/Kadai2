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
//こここここここっここここ
	public ArrayList<Student> getStudent() {

		ArrayList<Seminar> seminar = new ArrayList<Seminar>();

		try {
			// DB接続

			connection();

			String sql = "SELECT sub_id , stu_id " + "FROM  seminar WHERE sub_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, sub);

			rs = stmt.executeQuery();

			while (rs.next()) {

				Seminar sem = new Seminar();

				sem.setSub_id(rs.getInt("sub_id"));
				sem.setStu_id(rs.getInt("stu_id"));

				System.out.println(rs.getInt("sub_id"));

				seminar.add(sem);
			}

		} catch (Exception e) {

		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return seminar;

	}

}
