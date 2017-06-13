package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			ds = (DataSource)(new InitialContext()).lookup("java:comp/enc/jsbc/MySQL");
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
			subject.setSubId(subId);
			subject.setSubName(subName);
			subject.setSubGroup(subGroup);

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
