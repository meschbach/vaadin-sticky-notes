package com.meschbach.xp.vaadin.sticky.model.memory;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeClass;

import java.util.List;


import com.meschbach.xp.vaadin.sticky.model.StickyException;
import com.meschbach.xp.vaadin.sticky.model.StickyNote;
import com.meschbach.xp.vaadin.sticky.model.StickyQuotaException;
import com.meschbach.xp.vaadin.sticky.model.StickyUser;
import com.meschbach.xp.vaadin.sticky.model.memory.MemoryStickyUser;

public class MemoryStickyUserComboTest {
	
	StickyUser stickyUser;
	StickyNote stickyNote;
	String testString;	
	
	@BeforeClass
	public void setup(){
		stickyUser = new MemoryStickyUser("TestUserName",2);
		stickyNote = null;
		testString  = "You're the man, Mark!";

	}

	@Test
	public void testCreateNoteSetMessageGetNotes() {
					
		try {
			stickyNote = stickyUser.createNote();
		} catch (StickyQuotaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StickyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stickyNote.setMessage(testString);
		List<StickyNote> stickyNotes = null;
		
		try {
			stickyNotes = stickyUser.getNotes();
		} catch (StickyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StickyNote result = ( stickyNotes ).get(0);
		
		assertTrue (stickyNotes != null, "FAIL! For some reason the returned list of sticky notes is null.");
		
		assertTrue (stickyNotes.size()==1,"FAIL! For some other reason the size of the returned list of sticky notes is not one! ");
		
		assertTrue (result.getMessage().equals(testString),"FAIL! For some reason we could not retrieve the result." );
		
		
	}
	
	@Test
	public void testFoo(){
		assertFalse (stickyNote == null, "Just to test that TestNG is still working properly");
	}
}