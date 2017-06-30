package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
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

	public Seminar getSeminar(int stu_id, int sub_id) {

		Seminar seminar = new Seminar();

		try {
			connection();
			String sql = "";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, stu_id);
			stmt.setInt(2, sub_id);
			rs = stmt.executeQuery();

			rs.next();
			seminar.setStu_id(stu_id);
			seminar.setSub_id(sub_id);

		} catch (Exception e) {
			seminar = null;
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		return seminar;
	}

	public ArrayList<Seminar> getSeminar(int sub) {

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
				sem.setStu_id(rs.getInt("stu_id"));
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
