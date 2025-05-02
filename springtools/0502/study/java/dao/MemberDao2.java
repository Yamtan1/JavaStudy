package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MemberDTO;

@Repository //원래는 컴포넌트가 맞음
public class MemberDao2 {
	@Autowired
	private JdbcTemplate jt; //jdbc 템플릿 활용
	
	List<MemberDTO> list = new ArrayList<>();
	
	public MemberDTO viewMember(String id) {
		String query = "SELECT * FROM tbl_member WHERE id = ?";
		MemberDTO member = jt.queryForObject(query, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class), id); //목록 데이터 중 하나만 뽑을땐 queryForObject 
		
		return member;
	}

	public List<MemberDTO> list(){ //Dbcon 안쓰는중
		String query = "SELECT * FROM tbl_member";
		List<MemberDTO> list = jt.query(query, //목록데이터를 뽑을 때 query
				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class)); //와일문으로 만든 리스트를 자동으로 추가해준다
				
		return list;
	}
	
	public List<MemberDTO> getList(){
		String query = "SELECT * FROM tbl_member";
			
		try(Connection conn = Dbconn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();	) {
			while(rs.next()) {
				MemberDTO m = new MemberDTO();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setPw(rs.getString("pw"));
				m.setGrade(rs.getString("grade"));
				
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
