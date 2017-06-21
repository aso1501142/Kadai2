package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Subject;

public class SubjectDAO {

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



	public Subject getSubject(int subId,String subName,String subGroup){

		Subject subject = new Subject();

		try{
			connection();
			String sql = "INSERT INTO subject(sub_id.sub_name,sub_group) VALUES(?,'?','?') ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, subId);
			stmt.setString(2, subName);
			stmt.setString(3, subGroup);

			rs.next();
			subject.setSub_id(subId);
			subject.setSub_name(subName);
			subject.setSub_group(subGroup);

		}catch(Exception e){
			subject = null;
		}finally{
			try{
				close();
			}catch(Exception e){

			}
		}
		return subject;
	}
	public ArrayList<Subject> getSubjectdata(){

		ArrayList<Subject> subjects = new ArrayList<Subject>();

		try{
			//DB接続

			connection();

			System.out.println("con");


			String sql = "SELECT * "
					+ "FROM  subject";
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();


			while (rs.next()) {

			Subject subject = new Subject();

			subject.setSub_id(rs.getInt("sub_id"));
			subject.setSub_name(rs.getString("sub_name"));
			subject.setSub_group(rs.getString("sub_group"));
			subject.setTea_id(rs.getInt("tea_id"));

			System.out.println(rs.getInt("sub_id"));

			subjects.add(subject);
			}

		}catch(Exception e){

			}finally{
				try{
					close();
				}catch (Exception e){

				}
		}
		return subjects;

	}
	public Subject getSubject(int subId){

		Subject subject = new Subject();

		try{
			connection();
			String sql = "SELECT sub_id FROM zemi WHERE sub_id = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, subId);
			rs.next();
			subject.setSubId(subId);


		}catch(Exception e){
			subject = null;
		}finally{
			try{
				close();
			}catch(Exception e){

			}
		}
		return subject;


	}

}
