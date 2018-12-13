package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Note;

public class NoteDAO {

	private Connection con;
	
	
	// Adding note to database records
	public int addNote(Note note) throws SQLException {
		
		try {
			 con=DBUtil.getConnection();
			 PreparedStatement pstate = con.prepareStatement("insert into notes values (?, ?,?,?,?)");
			 pstate.setString(1 , note.getNoteid());
			 pstate.setString(2 , note.getTitle());
			 pstate.setString(3 , note.getNote());
			 pstate.setString(4 , note.getStickyDate());
			 pstate.setString(5 , note.getStatus());
			 
			int res= pstate.executeUpdate();
			if(res==1) {
				System.out.println("Record Inserted Successfully");
			}else {
				System.out.println("Unable to insert reccord");
			}
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con.close();
		}
		return 0;
		}
	public List<Note> getlist() {
		
		 Statement state;
		try {
			 con=DBUtil.getConnection();
			 state = con.createStatement();
			 ResultSet rs = state.executeQuery("select * from notes");
			 List<Note> nlist=new ArrayList<>();
			 Note note;
			 while (rs.next()) {
				 note=new Note();
				note.setNoteid(String.valueOf(rs.getInt(1)));
				note.setTitle(rs.getString(2));
				note.setNote(rs.getString(3));
				note.setStickyDate(rs.getString(4));
				note.setStatus(rs.getString(5));
				nlist.add(note);
			}
			 return nlist;
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public void updateNote(Note note) throws SQLException {
		 
		con=DBUtil.getConnection();
		 PreparedStatement pstate = con.prepareStatement("update notes set title = ?, note = ?, stickyDate =?, status = ?  where noteid =?");
		 pstate.setString(1, note.getTitle());
		 pstate.setString(2, note.getNote());
		 pstate.setString(3, note.getStickyDate());
		 pstate.setString(4, note.getStatus());
		 pstate.setString(5, note.getNoteid());
		 
		 pstate.execute();
	}
	
	public void deleteNote(int noteid) throws SQLException {
		con=DBUtil.getConnection();
		 PreparedStatement pstate = con.prepareStatement("delete from notes where noteid ="+ noteid);
		 
		 pstate.execute();

	}
}
