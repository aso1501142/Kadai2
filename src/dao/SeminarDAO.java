package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Seminar;

public class SeminarDAO {

	DataSource ds = null;
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public Connection connection() throws Exception {

		if (ds == null) {
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jsbc/MySQL");
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
	public Seminar getSeminar(int stu_id,int sub_id){

		Seminar seminar = new Seminar();

		try{
			connection();
			String sql = "";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, stu_id);
			stmt.setInt(2, sub_id);
			rs = stmt.executeQuery();

			rs.next();
			seminar.setStu_id(stu_id);
			seminar.setSub_id(sub_id);

		}catch(Exception e){
			seminar = null;
		}finally{
			try{
				close();
			}catch(Exception e){
			}
			}
		return seminar;
	}
}
