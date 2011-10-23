package com.meschbach.xp.vaadin.sticky.model.memory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.meschbach.xp.vaadin.sticky.model.StickyException;
import com.meschbach.xp.vaadin.sticky.model.StickyNote;
import com.meschbach.xp.vaadin.sticky.model.StickyQuotaException;
import com.meschbach.xp.vaadin.sticky.model.StickyUser;
import com.meschbach.xp.vaadin.sticky.model.memory.MemoryStickyUser;

public class MemoryStickyUserTest {
	
	StickyUser stickyUser;
	StickyNote stickyNote;
	String testString;	
	
	@Before
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
		
		assertTrue ("FAIL! For some reason the returned list of sticky notes is null.",stickyNotes != null);
		
		assertTrue ("FAIL! For some other reason the size of the returned list of sticky notes is not one! ",stickyNotes.size()==1);
		
		assertTrue ("FAIL! For some reason we could not retrieve the result.", result.getMessage().equals(testString)    );
		
		
	}
	
	@Test
	public void testFoo(){
		assertFalse ("Just to test that JUnit is still working properly",stickyNote != null);
	}

}
