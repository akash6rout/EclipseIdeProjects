package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nt.entities.Student;

public class StudentDAO {
	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn=conn;
	}
	
	public boolean addStudent(Student student)
	{
		boolean f= false;
		
		try {
			String sql="insert into student(name,address,email) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getEmail());
			
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	public List<Student> getAllStudent()
	{
		List<Student> list=new ArrayList<Student>();
		Student s=null;
		
		try {
			String sql="select * from student";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setEmail(rs.getString(4));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public Student getStudentById(int id) throws SQLException
	{
		Student s=null;
		String sql="select * from student where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			s=new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAddress(rs.getString(3));
			s.setEmail(rs.getString(4));
		}
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	public boolean updateStudentDetails(Student student)
	{
		boolean f=false;
		try {
			String sql="update student set name=?,address=?,email=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getEmail());
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	public boolean deleteStudent(int id)
	{
		boolean f=false;
		try {
			String sql="delete from student where id=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
