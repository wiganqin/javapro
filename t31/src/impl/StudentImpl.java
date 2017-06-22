package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Student;
import db.DBConn;

public class StudentImpl {

	public String joinString(String[] slikes) {
		String joinlikes = "";
		for (String temp : slikes) {
			joinlikes += temp + "-";
		}
		return joinlikes.substring(0, joinlikes.length() - 1);
	}
	
	public void updateStudent(Student student){
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre=con.prepareStatement("UPDATE student SET sname=?,saddress=? WHERE sid=?");
			pre.setString(1, student.getSname());
			pre.setString(2, student.getSaddress());
			pre.setInt(3, student.getSid());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteStudent(int sid){
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre=con.prepareStatement("DELETE FROM student WHERE sid=?");
			pre.setInt(1, sid);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Student> queryStudent(String sname){
		ArrayList<Student> students=new ArrayList<Student>();
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs=null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre=con.prepareStatement("SELECT * FROM student WHERE sname LIKE ?");
			pre.setString(1, "%" + sname + "%");
			rs=pre.executeQuery();
			while(rs.next()){
				Student student=new Student();
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setSaddress(rs.getString("saddress"));
				student.setSlikes(rs.getString("slikes"));
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

	public void saveStudent(Student student) {
		// 连接数据库 完成数据的录入操作
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con
					.prepareStatement("INSERT INTO student (sname,saddress,slikes) VALUES (?,?,?)");
			pre.setString(1, student.getSname());
			pre.setString(2, student.getSaddress());
			pre.setString(3, student.getSlikes());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
