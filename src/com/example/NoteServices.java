package com.example;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.NoteDAO;
import com.model.Note;
 
@Path("/note")
public class NoteServices {
	
	private NoteDAO ndao=new NoteDAO();
 
	// fetching all records from database
	@GET
	@Path("/getNotes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getNotes() {
 
		return ndao.getlist();
 
	}
	
	// Request handling the add notes record
	@POST
	@Path("/addNote")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Note addNote123(Note note) {
		try {
			System.out.println("Details form Request: "+note.getNoteid()+","+note.getStatus()+","+note.getNote());
			int res=ndao.addNote(note);
			if(res==1) {
				return note;
			}else {
				return null;
			}
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return note;
	}
	
	//request handling update notes
	@POST
	@Path("/updateNote")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Note note) throws SQLException {
		ndao.updateNote(note);
	}

	@GET
	@Path("/deleteNote/{noteid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delNote(@PathParam("noteid") int noteid) throws SQLException {
		ndao.deleteNote(noteid);
		
	}
	
//	@GET
//	@Path("/get/{noteid}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void getNoteId(@PathParam("noteid") int noteid) {
//		
// 
//			System.out.println(noteid);
// 
//	}
}